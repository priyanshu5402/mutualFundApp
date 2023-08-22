	package com.ofss.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.model.Manager;
import com.ofss.repository.ManagerRepository;

@Service
public class ManagerService {
	
	@Autowired
	ManagerRepository managerRepo;
	
	
	public String login(Manager manager){
		Manager tempUser = managerRepo.findByManagerNamePass(manager.getUsername(), manager.getPassword());
		System.out.println(tempUser.getUsername()+"   "+manager.getUsername());
		
		if(( tempUser.getUsername().equals(manager.getUsername()) ) && ( tempUser.getPassword().equals(manager.getPassword()) )) {

			return "Manager Signed in";

		}
		else {
			return "invalid Manager";
		}
	}
	
}
