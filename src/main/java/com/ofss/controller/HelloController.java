package com.ofss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.model.Users;
import com.ofss.services.UserService;

@RestController
public class HelloController {

	@Autowired
	UserService userservice;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestBody Users user) {
		System.out.println("login function called..");
		return userservice.login(user);
	}
}
