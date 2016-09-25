package com.neo.service;

import java.util.List;

import com.neo.dto.EnvironmentDTO;

public interface EnvironmentService {
	
	public int addNewEnvironment(EnvironmentDTO environmentDTO);
	public List<EnvironmentDTO> getAllEnvironment();
	public EnvironmentDTO getEnvironmentById(int id);
	public EnvironmentDTO getEnvironmentByKey(String key);
	public void deleteEnvironmentById(int id);

}
