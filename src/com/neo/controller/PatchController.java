package com.neo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/patch")
public class PatchController {
	
	private static final String CREATE_PATCH_PAGE = "createPatch";

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createNewEnvironment(ModelMap map) {

		return CREATE_PATCH_PAGE;
	}

}
