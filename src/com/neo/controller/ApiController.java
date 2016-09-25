package com.neo.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.neo.dto.EnvironmentDTO;
import com.neo.dto.PingResult;
import com.neo.persistence.PingResultDAO;
import com.neo.service.EnvironmentService;

@Controller
@RequestMapping(value = "/api")
public class ApiController {

	@Autowired
	EnvironmentService environmentService;

	@Autowired
	PingResultDAO pingResultDAO;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	@ResponseBody
	public List<EnvironmentDTO> showAllEnvironment(ModelMap map) {
		return environmentService.getAllEnvironment();
	}

	@RequestMapping(value = "/getKeyId/{keyId}", method = RequestMethod.GET)
	@ResponseBody
	public EnvironmentDTO getEnvironmentByKey(@PathVariable("keyId") String key) {
		return environmentService.getEnvironmentByKey(key);
	}
	
	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	@ResponseBody
	public EnvironmentDTO getEnvironmentById(@PathVariable("id") int id) {
		return environmentService.getEnvironmentById(id);
	}

	@RequestMapping(value = "/getStatus", method = RequestMethod.GET)
	@ResponseBody
	public List<PingResult> getEnvironmentStatus() {
		return pingResultDAO.getAllStatus();
	}
	@RequestMapping(value = "/getStatusById/{id}", method = RequestMethod.GET)
	@ResponseBody
	public PingResult getEnvironmentStatusById(@PathVariable("id") int id) {
		return pingResultDAO.getAllStatusById(id);
	}
	
	@RequestMapping(value = "/buildDetials", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getEnvironmentBuildDetails(
			@RequestParam(value = "user", required = false) String user,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "host", required = false) String host,
			@RequestParam(value = "remotePath", required = false) String remotePath,
			ModelMap map) {
		int port = 22;
		List<String> result = new ArrayList<String>();
		try {
			JSch jsch = new JSch();
			Session session = jsch.getSession(user, host, port);
			session.setPassword(password);
			session.setConfig("StrictHostKeyChecking", "no");
			System.out.println("Establishing Connection...");
			session.connect();
			System.out.println("Connection established.");
			System.out.println("Crating SFTP Channel.");
			ChannelSftp sftpChannel = (ChannelSftp) session.openChannel("sftp");
			sftpChannel.connect();
			System.out.println("SFTP Channel created.");

			InputStream out = null;
			String fileName = null;
			@SuppressWarnings("rawtypes")
			Vector filelist = sftpChannel.ls(remotePath);
            for(int i=0; i<filelist.size();i++){
                //System.out.println(filelist.toString());
                LsEntry entry = (LsEntry) filelist.get(i);
                fileName = entry.getFilename();
                if(fileName.contains("revision")){
                	System.out.println(fileName);
                	out = sftpChannel.get(remotePath+"/"+fileName);
        			BufferedReader br = new BufferedReader(new InputStreamReader(out));
        			String line;
        			while ((line = br.readLine()) != null)
        				result.add(line.split(":")[1].replaceAll(" ", ""));
        			br.close();
                }
            }
		} catch (Exception e) {
			System.err.print(e);
		}
		result.set(0, result.get(0).split("@")[1]);
		return result;

	}

}
