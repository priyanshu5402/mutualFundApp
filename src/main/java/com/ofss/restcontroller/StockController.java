package com.ofss.restcontroller;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ofss.model.StockDetail;
import com.ofss.model.Stocks;
import com.ofss.services.StockService;

@RestController
public class StockController {

	@Autowired
	StockService stockservice;
	
	@RequestMapping(value="/stocks",method=RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ArrayList<Stocks> getAllStocks() {
		return stockservice.getAllStocks();
	}
	@RequestMapping(value="/uniquestocks",method=RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ArrayList<Stocks> getUniqueStocks() {
		return stockservice.getUniqueStocks();
	}
	@RequestMapping(value="/stockDetails/{id}",method=RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ArrayList<Stocks> getStockDetailById(@PathVariable("id") int stock_id){
		return stockservice.getStockDetailById(stock_id);
	}
	
	
}
