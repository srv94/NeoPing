package com.neo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neo.dto.EnvironmentDTO;
import com.neo.service.EnvironmentService;

@Controller
@RequestMapping(value="/api")
public class ApiController {
    
    @Autowired
    EnvironmentService environmentService;
    
    @RequestMapping(value="/getAll", method=RequestMethod.GET)
    @ResponseBody public List<EnvironmentDTO> showAllEnvironment(ModelMap map) {
        return environmentService.getAllEnvironment();  
    }
    
    @RequestMapping(value="/getKeyId/{keyId}", method=RequestMethod.GET)
    @ResponseBody public EnvironmentDTO getEnvironmentByKey(ModelMap map,@PathVariable("keyId") String key) {
        return environmentService.getEnvironmentByKey(key);  
    }


}
