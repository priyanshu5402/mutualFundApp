package com.ofss.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.model.StockDetail;
import com.ofss.model.StockID;
import com.ofss.model.Stocks;
import com.ofss.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	StockRepository stockRepository;
	
	LocalDate currentDate = LocalDate.now();
    Date localDate = Date.valueOf(currentDate);
	
	public ArrayList<Stocks> getAllStocks(){
		ArrayList<Stocks> stocks = stockRepository.getAllStocks();
		
		return stocks;
	}
	
	public ArrayList<Stocks> getUniqueStocks(){
		ArrayList<Stocks> stocks = stockRepository.getUniqueStocks();
		
		return stocks;
	}
	public ArrayList<Stocks> getStockDetailById(int stock_id){
//		Stocks stock = stockRepository.findOne(stock_id);
		ArrayList<Stocks> stocks = stockRepository.findOneStockDetails(stock_id);
		
		return stocks;
	}
//	public Stocks getMe(int stockId)
//	{
//		stockRepo.findAll();
//	}
}
