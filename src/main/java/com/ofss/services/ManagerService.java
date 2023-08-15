package com.ofss.services;

import org.springframework.stereotype.Service;

import com.ofss.model.Users;

@Service
public class ManagerService {
	
	@Autowired
	ManagerRepository managerRepo;
	
	
	public String login(Users user){
		Users tempUser = managerRepo.findByUserNamePass(user.getUsername(), user.getPassword());
		System.out.println(tempUser.getUsername()+"   "+user.getUsername());
		
		if(( tempUser.getUsername().equals(user.getUsername()) ) && ( tempUser.getPassword().equals(user.getPassword()) )) {

			return "success sign in";

		}
		else {
			return "invalid user";
		}
	}
	
}
