package com.neo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neo.dto.EnvironmentDTO;

@Controller
public class EnvironmentController {

	private static final String CREATE_ENVIRONMENT_PAGE = "createEnvironment";
	private static final String SHOW_ALL_ENVIRONMENT_PAGE = "showAllEnvironment"; 
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createNewEnvironment(ModelMap map) {
		
		EnvironmentDTO environmentDTO = new EnvironmentDTO();
		map.addAttribute("environment", environmentDTO);
		return CREATE_ENVIRONMENT_PAGE;

	}
	
	@RequestMapping(value="/showAll", method=RequestMethod.GET)
	public String showAllEnvironment(ModelMap map) {
		
		map.addAttribute("allEnvironment", null);
		return SHOW_ALL_ENVIRONMENT_PAGE;

	}
	
	

}
