package com.neo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {
	
	private static final String INDEX = "dashboard";

	@RequestMapping(value="/dashboard", method=RequestMethod.GET)
	public String getDashboard() {
		
		return INDEX;
	}

}
