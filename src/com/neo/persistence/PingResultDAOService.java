package com.neo.persistence;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neo.dto.PingResult;
import com.neo.dto.PingResultDTO;

@Repository
@Transactional
public class PingResultDAOService implements PingResultDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public PingResultDTO getById(int id) {
        return (PingResultDTO) sessionFactory.getCurrentSession().get(PingResultDTO.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PingResultDTO> searchResults(String col, String search) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PingResultDTO.class);
        criteria.add(Restrictions.ilike(col, "%" +search +"%"));
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PingResultDTO> getAllResults() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PingResultDTO.class);
        return criteria.list();
    }

    @Override
    public int saveResult(PingResultDTO pingResultDTO) {
    	sessionFactory.getCurrentSession().save(pingResultDTO);
    	sessionFactory.getCurrentSession().save(new PingResult(pingResultDTO.getKeyid(),pingResultDTO.getResult(),pingResultDTO.getTimestamp(),pingResultDTO.getEnvType()));
        return (Integer) sessionFactory.getCurrentSession().save(pingResultDTO);
    }

    @Override
    public void updateResult(PingResultDTO pingResultDTO) {
        sessionFactory.getCurrentSession().merge(pingResultDTO);
        
    }

    @Override
    public void deleteResult(int id) {
        PingResultDTO pingResultDTO = getById(id);
        sessionFactory.getCurrentSession().delete(pingResultDTO);      
    }
    
    @Override
    public void deleteOldResult() {
    	sessionFactory.getCurrentSession().createQuery("delete from PingResult").executeUpdate();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<PingResult> getAllStatus() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(PingResult.class);
        return criteria.list();
    }

	@Override
	public PingResult getAllStatusById(int id) {
		return (PingResult) sessionFactory.getCurrentSession().get(PingResult.class, id);
	}
    

}
