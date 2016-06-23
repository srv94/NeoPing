package com.neo.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neo.dto.EnvironmentDTO;
import com.neo.persistence.EnvironmentDAO;

@Service
@Transactional
public class EnvironmentServiceImp implements EnvironmentService {

    @Autowired
    EnvironmentDAO environmentDAO;

    @Override
    public int addNewEnvironment(EnvironmentDTO environmentDTO) {
        if (environmentDTO.getKeyId() == null || environmentDTO.getKeyId().isEmpty()) {
            java.util.Date date = new java.util.Date();
            environmentDTO.setKeyId(new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Timestamp(date.getTime())));
            return environmentDAO.saveEnvironment(environmentDTO);
        }else{
            environmentDAO.updateEnvironment(environmentDTO);
            return 0;
        }
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

    @Override
    public EnvironmentDTO getEnvironmentByKey(String key) {
        // TODO Auto-generated method stub
        return environmentDAO.searchEnvironments("keyId", key).iterator().next();
    }

    @Override
    public void deleteEnvironmentById(int id) {
        environmentDAO.deleteEnvironment(id);
        
    }

}
