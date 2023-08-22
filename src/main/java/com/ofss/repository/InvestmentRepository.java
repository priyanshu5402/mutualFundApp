package com.ofss.repository;

import com.ofss.model.Investor;
import com.ofss.model.MutualFund;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ofss.model.*;

public interface InvestmentRepository extends JpaRepository<Investment,Integer>{
	
	Investment findByInvestorAndMutualFund(Investor investor,MutualFund mutualFund);

}
