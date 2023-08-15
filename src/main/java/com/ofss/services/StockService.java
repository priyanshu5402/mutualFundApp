package com.ofss.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	StockRepository stockRepo;
	
	public Iterable<Stocks> getAllStocks(){
		Iterable<Stocks> stocks = stockRepo.findAll();
		return stocks;
	}
}