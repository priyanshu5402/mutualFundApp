package com.ofss.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ofss.model.Users;

public interface StockRepository extends CrudRepository<Stocks, Integer> {
	
//	@Query(value = "SELECT * FROM Stocks", nativeQuery = true)
//	ArrayList<Stocks> getAllStocks();	
	
	

}
