package com.ofss.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.model.Manager;
import com.ofss.services.ManagerService;

@RestController
public class ManagerController {

	@Autowired
	ManagerService managerservice;
	
	@RequestMapping(value="/Managerlogin", method=RequestMethod.POST)
	public String login(@RequestBody Manager manager) {
		System.out.println("login function called..");
		return managerservice.login(manager);
	}
	
}
