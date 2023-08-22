package com.ofss.restcontroller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.model.Investor;
import com.ofss.model.MutualFund;
import com.ofss.model.Stocks;
import com.ofss.pojo.MutualFundPOJO;
import com.ofss.services.FundService;

@RestController
public class FundController {
	
	@Autowired
	FundService fundservice;
	
	@RequestMapping(value="/addFund", method=RequestMethod.POST)
	public String addFund(@RequestBody MutualFundPOJO mutualfundpojo) {
		System.out.println("Controller addFund function called..");
		try {
		MutualFund mutualfund = new MutualFund();
		mutualfund.setEntryLoad(mutualfundpojo.getEntryLoad());
		mutualfund.setExit_load(mutualfundpojo.getExitLoad());	
		mutualfund.setExpenseRatio(mutualfundpojo.getExpenseRatio());
		mutualfund.setMutualFundName(mutualfundpojo.getMutualFundName());
		mutualfund.setTotalOutstandingUnits(mutualfundpojo.getNumberOfOutstandinUnits());
		mutualfund.setRemainingUnits(mutualfundpojo.getNumberOfOutstandinUnits());

		//mutualfund.setTotalInvestment(1000000000);
		
		fundservice.addMutualFund(mutualfund,mutualfundpojo.getStockIds(),mutualfundpojo.getWeightage());
		
//		fundservice.addMutualFundStocks(mutualfund,mutualfundpojo.getStockIds(),mutualfundpojo.getWeightage());
		return "fund and stocks are added";
	}
		catch(Exception e) {
			e.printStackTrace();
			return "error occured";
	}
		
	}
	@RequestMapping(value="/showMutualFunds", method=RequestMethod.GET ,produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ArrayList<MutualFund> login() {
		System.out.println("ShowMutualFUnd function called..");
		
		ArrayList<MutualFund> mutualfunds = fundservice.getAllMutualFunds();
		
		return mutualfunds;
	}
}
