package com.neo.service;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.dto.NeoDirectory;
import com.neo.dto.NeoFile;

@Service
public class FileDirectoryService {
	
	@Autowired
	NeoDirectoryService neoDirectoryService;
	
	String rootPath;
	
	//@Autowired
	//NeoFileService neoFileService;
	
	@SuppressWarnings("resource")
	public void setJarFile(String path,NeoDirectory jarDir,PrintWriter out) throws IOException{
		JarFile file = new JarFile(path);
		Enumeration<JarEntry> entries = file.entries();
		while (entries.hasMoreElements()) {
			JarEntry entry = entries.nextElement();
			if (!entry.isDirectory()){
				NeoFile neoFile = new NeoFile(entry.getName(), "",entry.toString());
				neoFile.addNewPatchPath(jarDir.getPath().replace('\\', '/')+"#"+entry.toString());
				jarDir.addNewFile(neoFile);
				neoFile.setIndent(jarDir.getIndent()+1);
				//neoFileService.saveNeoFile(neoFile);
				//out.append("++++++file:" + entry.getName()
				//		+ "  " + entry + " \n");
			}
		}
	}

	public void displayDirectoryContents(File dir, PrintWriter out,
			NeoDirectory parentDir) {
		try {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					//out.append("directory:" + file.getCanonicalPath() + "\n");
					NeoDirectory childDir = new NeoDirectory(file.getName());
					childDir.setIndent(parentDir.getIndent() + 1);
					//System.out.println(file.getCanonicalPath().substring(rootPath.length()) +"   "+rootPath);
					childDir.setPath(file.getCanonicalPath().substring(rootPath.length()-1));
					parentDir.addNewDirectory(childDir);
					displayDirectoryContents(file, out, childDir);
					neoDirectoryService.saveNeoDirectory(childDir);
				} else {
					if (file.getName().contains(".jar")) {
						//out.append("-----jar:" + file.getCanonicalPath() + "\n");
						NeoDirectory childDir = new NeoDirectory(file.getName());
						childDir.setIndent(parentDir.getIndent() + 1);
						childDir.setPath(file.getCanonicalPath().substring(rootPath.length()-1));
						setJarFile(file.getCanonicalPath(), childDir, out);
						neoDirectoryService.saveNeoDirectory(childDir);
					}else{
						//out.append("++++++file:" + file.getCanonicalPath()
						//		+ "  " + file.getName() + " \n");

						NeoFile neoFile = new NeoFile(file.getName(), "",
								file.getCanonicalPath().substring(rootPath.length()-1));
						neoFile.addNewPatchPath(neoFile.getLocation().replace('\\', '/'));
						neoFile.setIndent(parentDir.getIndent()+1);
						parentDir.addNewFile(neoFile);
						//neoFileService.saveNeoFile(neoFile);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public long Start() throws IOException {
		File currentDir = new File("D:\\finnone-webapp\\"); // current directory
		long startTime = System.currentTimeMillis();
		long stopTime;
		long elapsedTime = 0;
		NeoDirectory rootDir = new NeoDirectory("Root");
		rootPath = "^"+currentDir.getCanonicalPath().toString();
		rootDir.setPath(currentDir.getCanonicalPath());
		try (PrintWriter out = new PrintWriter("D:\\testdata1.txt")) {

			displayDirectoryContents(currentDir, out, rootDir);
			neoDirectoryService.saveNeoDirectory(rootDir);
			stopTime = System.currentTimeMillis();
			elapsedTime = stopTime - startTime;
			out.append(rootPath);
			out.append("Total time : " + elapsedTime);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		neoDirectoryService.saveNeoDirectory(rootDir);
		return elapsedTime;
		
	}

}
