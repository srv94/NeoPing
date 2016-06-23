package com.neo.scheduledTask; // NOSONAR


import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.neo.dto.EnvironmentDTO;
import com.neo.dto.PingResultDTO;
import com.neo.persistence.PingResultDAO;
import com.neo.service.EnvironmentService;
import com.neo.service.PingUtil;

@Component
public class PingTask {
    
    @Autowired
    EnvironmentService environmentService;
    
    @Autowired
    PingResultDAO pingResultDao;
    
    @Scheduled(fixedDelay = 60000000)
    public void checkUrlStaus()
    {
        java.util.Date date= new java.util.Date();
        Timestamp time = new Timestamp(date.getTime());
        for(EnvironmentDTO environmentDTO : environmentService.getAllEnvironment()){
            PingResultDTO resultDTO = new PingResultDTO(environmentDTO.getKeyId(),time);
            resultDTO.setResult(PingUtil.checkUrl("http://"+environmentDTO.getEnvUrl()+"/finnone-webapp/app/auth/getCaptcha?1465279781280"));
            pingResultDao.saveResult(resultDTO);
        }
        
    }
}
