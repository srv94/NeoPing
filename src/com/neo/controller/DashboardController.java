package com.neo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neo.dto.PingResult;
import com.neo.persistence.PingResultDAO;

@Controller
public class DashboardController {
	
	@Autowired
	PingResultDAO pingResultDAO;
	
	private static final String CAS = "CAS";
	private static final String LMS = "LMS";
	
	private static final String INDEX = "dashboard";

	@RequestMapping(value="/dashboard", method=RequestMethod.GET)
	public String getDashboard(ModelMap map) {
		
		List<PingResult> results = pingResultDAO.getAllStatus();
		
		Integer CASTotal=0,LMSTotal=0,INTTotal=0,CASDown=0,LMSDown=0,INTDown=0;
		for(PingResult pingResult : results){
			if(pingResult.getEnvType().equals(CAS)){
				CASTotal++;
				if(pingResult.isResult() == false){
					CASDown++;
				}
			}else{
				if(pingResult.getEnvType().equals(LMS)){
					LMSTotal++;
					if(pingResult.isResult() == false){
						LMSDown++;
					}
				}else{
					INTTotal++;
					if(pingResult.isResult() == false){
						INTDown++;
					}
				}
			}
		}
		map.put("TotalCAS", CASTotal);
		map.put("TotalLMS", LMSTotal);
		map.put("TotalINT", INTTotal);
		map.put("DownCAS", CASDown);
		map.put("DownLMS", LMSDown);
		map.put("DownINT", INTDown);
		map.put("Total", CASTotal+LMSTotal+INTTotal);
		map.put("TotalDown", CASDown+LMSDown+INTDown);
		
		return INDEX;
	}

}
