package com.neo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neo.dto.EnvironmentDTO;

public interface EnvironmentService {
	
	public int addNewEnvironment(EnvironmentDTO environmentDTO);
	public List<EnvironmentDTO> getAllEnvironment();
	public EnvironmentDTO getEnvironmentById(int id);

}
