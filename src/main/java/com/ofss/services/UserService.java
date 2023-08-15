package com.ofss.services;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ofss.repository.UserRepository;
import com.ofss.model.*;
@Service
public class UserService {
	@Autowired
	UserRepository userRepo;

	public String login(Users user){
		Users tempUser = userRepo.findByUserNamePass(user.getUsername(), user.getPassword());
		System.out.println(tempUser.getUsername()+"   "+user.getUsername());

		if(( tempUser.getUsername().equals(user.getUsername()) ) && ( tempUser.getPassword().equals(user.getPassword()) )) {

			return "success sign in";

		}
		else {
			return "invalid user";
		}
	}
}
