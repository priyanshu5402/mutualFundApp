package com.ofss.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ofss.model.StockDetail;
import com.ofss.model.StockID;
import com.ofss.model.Stocks;

public interface StockRepository extends CrudRepository<Stocks, StockID> {
	
	@Query(value = "SELECT * FROM stocks", nativeQuery = true)
	ArrayList<Stocks> getAllStocks();	
	
	@Query(value ="SELECT * FROM STOCKS s WHERE s.PRESENT_DATE = TRUNC(SYSDATE)", nativeQuery=true)
	ArrayList<Stocks> getUniqueStocks();	

	
	
}
