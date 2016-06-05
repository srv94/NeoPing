package com.neo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neo.dto.EnvironmentDTO;
import com.neo.service.EnvironmentService;
import com.sivalabs.contacts.Contact;

@Controller
public class EnvironmentController {

	private static final String CREATE_ENVIRONMENT_PAGE = "createEnvironment";
	private static final String SHOW_ALL_ENVIRONMENT_PAGE = "showAllEnvironment";
	private static final String REDIRECT_TO_SHOW_ALL_ENVIRONMENT_PAGE = "redirect:showAll"; 
	
	@Autowired
	EnvironmentService environmentService;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createNewEnvironment(ModelMap map) {
		
		EnvironmentDTO environmentDTO = new EnvironmentDTO();
		map.addAttribute("environment", environmentDTO);
		return CREATE_ENVIRONMENT_PAGE;
	}
	
	@RequestMapping(value="/saveEnvironment", method=RequestMethod.POST)
	public String addNewEnvironment(@ModelAttribute("environment")EnvironmentDTO environmentDTO){
		
		environmentService.addNewEnvironment(environmentDTO);
		return REDIRECT_TO_SHOW_ALL_ENVIRONMENT_PAGE;
	}
	
	@RequestMapping(value="/showAll", method=RequestMethod.GET)
	public String showAllEnvironment(ModelMap map) {
		
		List<EnvironmentDTO> environmentDTOs  = environmentService.getAllEnvironment();
		
		map.addAttribute("allEnvironment", environmentDTOs);
		return SHOW_ALL_ENVIRONMENT_PAGE;

	}

	@RequestMapping(value="/getEnvironmentById/{id}", method=RequestMethod.GET)
	public String getEnvironmentById(ModelMap map,@PathVariable("id") int id) {
		
		map.addAttribute("environment", environmentService.getEnvironmentById(id));
		return CREATE_ENVIRONMENT_PAGE;

	}
	
	
	

}
