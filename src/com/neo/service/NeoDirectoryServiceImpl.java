package com.neo.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neo.dto.NeoDirectory;

@Service
@Transactional
public class NeoDirectoryServiceImpl implements NeoDirectoryService {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int saveNeoDirectory(NeoDirectory neoDirectory) {
		if (neoDirectory.getId() == 0) {
			return (Integer) sessionFactory.getCurrentSession().save(
					neoDirectory);
		} else {
			sessionFactory.getCurrentSession().merge(neoDirectory);
			return 0;
		}
	}

	@Override
	public int updateNeoDirectory(NeoDirectory neoDirectory) {
		// TODO Auto-generated method stub
		return 0;
	}

}
