package com.ofss.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ofss.model.StockDetail;
import com.ofss.model.StockID;
import com.ofss.model.Stocks;
import com.ofss.model.Users;

public interface StockRepository extends CrudRepository<Stocks, StockID> {
	
	@Query(value = "SELECT * FROM stocks where stock_id>8", nativeQuery = true)
	ArrayList<Stocks> getAllStocks();	
	
	
}
