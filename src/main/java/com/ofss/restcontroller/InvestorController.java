package com.ofss.restcontroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.model.Investor;
import com.ofss.model.Manager;
import com.ofss.pojo.TransactionPOJO;
import com.ofss.services.InvestorService;

@RestController
public class InvestorController {

	@Autowired
	InvestorService investorservice;
	
	@RequestMapping(value="/investorlogin", method=RequestMethod.POST)
	public Boolean login(@RequestBody Investor investor) {
		System.out.println("login function called..");
		if(investorservice.login(investor) == null) {
//		return "invalid user";
			return false;
		}
		else {
		return investorservice.login(investor);
		}
	}
	
	@RequestMapping(value="/buy",method =RequestMethod.POST)
	public String buy(@RequestBody TransactionPOJO transactionpojo) {
		System.out.println("buy function called");		
		return investorservice.buy(transactionpojo);
		
	}
	
	@RequestMapping(value="/sell",method =RequestMethod.POST)
	public String sell(@RequestBody TransactionPOJO transactionpojo) {
		System.out.println("buy function called");		
		return investorservice.Sell(transactionpojo);
		
	}
	
	


}
