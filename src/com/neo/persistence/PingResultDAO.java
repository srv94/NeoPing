package com.neo.persistence;

import java.util.List;

import com.neo.dto.PingResult;
import com.neo.dto.PingResultDTO;

public interface PingResultDAO {
    
    public PingResultDTO getById(int id);
    public List<PingResultDTO> searchResults(String col,String search);
    public List<PingResultDTO> getAllResults();
    public int saveResult(PingResultDTO pingResultDTO);
    public void updateResult(PingResultDTO pingResultDTO);
    public void deleteResult(int id);
	void deleteOldResult();
	List<PingResult> getAllStatus();

}
