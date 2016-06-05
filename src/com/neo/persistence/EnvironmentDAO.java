package com.neo.persistence;

import java.util.List;

import com.neo.dto.EnvironmentDTO;

public interface EnvironmentDAO {
	
	public EnvironmentDTO getById(int id);
	public List<EnvironmentDTO> searchEnvironments(String search);
	public List<EnvironmentDTO> getAllEnvironments();
	public int saveEnvironment(EnvironmentDTO environmentDTO);
	public void updateEnvironment(EnvironmentDTO environmentDTO);
	public void deleteEnvironment(int id);

}
