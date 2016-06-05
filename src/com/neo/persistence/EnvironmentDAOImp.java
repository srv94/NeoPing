package com.neo.persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neo.dto.EnvironmentDTO;

@Repository
public class EnvironmentDAOImp implements EnvironmentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public EnvironmentDTO getById(int id) {
		return (EnvironmentDTO) sessionFactory.getCurrentSession().get(EnvironmentDTO.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EnvironmentDTO> searchEnvironments(String search) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EnvironmentDTO.class);
		criteria.add(Restrictions.ilike("name", search+"%"));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EnvironmentDTO> getAllEnvironments() {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EnvironmentDTO.class);
		return criteria.list();
	}

	@Override
	public int saveEnvironment(EnvironmentDTO environmentDTO) {
		return (Integer) sessionFactory.getCurrentSession().save(environmentDTO);
	}

	@Override
	public void updateEnvironment(EnvironmentDTO environmentDTO) {
		sessionFactory.getCurrentSession().merge(environmentDTO);
		
	}

	@Override
	public void deleteEnvironment(int id) {
		EnvironmentDTO environmentDTO = getById(id);
		sessionFactory.getCurrentSession().delete(environmentDTO);
	}

}
