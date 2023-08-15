package com.ofss.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.model.Users;
import com.ofss.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userservice;
	
	@RequestMapping(value="/userlogin", method=RequestMethod.POST)
	public String login(@RequestBody Users user) {
		System.out.println("login function called..");
		return userservice.login(user);
	}
	
	@RequestMapping(value="/Managerlogin", method=RequestMethod.POST)
	public String login(@RequestBody Manager manager) {
		System.out.println("login function called..");
		return userservice.login(manager);
	}
	
	@RequestMapping(value="/stocks",method=RequestMethod.GET, produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ArrayList<Stocks> getAllStocks(@RequestBody Stocks stock) {
		System.out.println("login function called..");
		return userservice.login(stock);
	}
}
