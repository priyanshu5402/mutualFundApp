package com.ofss.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.model.MutualFund;
import com.ofss.model.Stocks;
import com.ofss.model.Users;
import com.ofss.services.FundService;
import com.ofss.services.UserService;

@RestController
public class FundController {
	
	@Autowired
	FundService fundservice;
	
	@RequestMapping(value="/addFund", method=RequestMethod.POST)
	public String addFund(@RequestBody MutualFund mutualfund,@RequestBody ArrayList<Stocks> stocks) {
		System.out.println("addFund function called..");
		if(fundservice.addFund(mutualfund,stocks) == null) {
		return "invalid user";
		}
		else {
		return fundservice.addFund(mutualfund, stocks);
		}
	}
}
