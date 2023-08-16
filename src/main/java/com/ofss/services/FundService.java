package com.ofss.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.ofss.model.MutualFund;
import com.ofss.model.Stocks;
import com.ofss.repository.FundRepository;

public class FundService {
	
	@Autowired
	FundRepository fundRepo;
	
	public String addFund(MutualFund mutualfund,ArrayList<Stocks> stocks) {
		return "";
	}

}
