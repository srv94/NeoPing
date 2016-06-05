package com.neo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neo.dto.EnvironmentDTO;
import com.neo.persistence.EnvironmentDAO;

@Service
@Transactional
public class EnvironmentServiceImp implements EnvironmentService{

	@Autowired
	EnvironmentDAO environmentDAO;
	
	@Override
	public int addNewEnvironment(EnvironmentDTO environmentDTO) {

		return environmentDAO.saveEnvironment(environmentDTO);
	}

	@Override
	public List<EnvironmentDTO> getAllEnvironment() {
		// TODO Auto-generated method stub
		return environmentDAO.getAllEnvironments();
	}

	@Override
	public EnvironmentDTO getEnvironmentById(int id) {
		return environmentDAO.getById(id);
	}

}
