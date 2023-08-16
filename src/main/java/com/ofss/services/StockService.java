package com.ofss.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.model.StockDetail;
import com.ofss.model.Stocks;
import com.ofss.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	StockRepository stockRepo;
	
	public ArrayList<Stocks> getAllStocks(){
		ArrayList<Stocks> stocks = stockRepo.getAllStocks();
		
		
		return stocks;
	}
	
//	public Stocks getMe(int stockId)
//	{
//		stockRepo.findAll();
//	}
}
