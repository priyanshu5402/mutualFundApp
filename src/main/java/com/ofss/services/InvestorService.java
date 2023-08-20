package com.ofss.services;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ofss.repository.InvestorRepository;
import com.ofss.model.*;
@Service
public class InvestorService {
	@Autowired
	InvestorRepository investorRepo;

	public Boolean login(Investor investor){
		Investor tempUser = investorRepo.findByInvestorNamePass(investor.getUsername(), investor.getPassword());
		System.out.println(tempUser.getUsername()+"   "+investor.getUsername());
		
		if(( tempUser.getUsername().equals(investor.getUsername()) ) && ( tempUser.getPassword().equals(investor.getPassword()) )) {
			
			System.out.println("Logged in ");
			return true;
			//return "redirect:/dashboard";

		}
		else {
			System.out.println("Invalid User");
			return false;
		}
	}
	
//	public String login(Manager manager){
//		Manager tempUser = investorRepo.findByUserNamePass(manager.getUsername(), manager.getPassword());
//		System.out.println(tempUser.getUsername()+"   "+manager.getUsername());
//		
//		if(( tempUser.getUsername().equals(manager.getUsername()) ) && ( tempUser.getPassword().equals(manager.getPassword()) )) {
//
//			return "Manager success sign in";
//
//		}
//		else {
//			return "invalid user";
//		}
//	}
//	
	
	
	
}
