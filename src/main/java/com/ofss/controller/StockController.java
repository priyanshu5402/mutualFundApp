package com.ofss.controller;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ofss.model.StockDetail;
import com.ofss.model.Stocks;
import com.ofss.services.StockService;

@RestController
public class StockController {

	@Autowired
	StockService stockservice;
	
	@RequestMapping(value="/stocks",method=RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Iterable<Stocks> getAllStocks() {
		System.out.println("getAllStocks function called..");
		return stockservice.getAllStocks();
	}
}
