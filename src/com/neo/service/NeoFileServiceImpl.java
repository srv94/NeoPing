package com.neo.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neo.dto.NeoFile;

@Service
@Transactional
public class NeoFileServiceImpl implements NeoFileService{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int saveNeoFile(NeoFile neoFile) {
		if (neoFile.getId() == 0) {
			return (Integer) sessionFactory.getCurrentSession().save(
					neoFile);
		} else {
			sessionFactory.getCurrentSession().merge(neoFile);
			return 0;
		}
	}

	@Override
	public int updateNeoFile(NeoFile neoFile) {
		// TODO Auto-generated method stub
		return 0;
	}

}
