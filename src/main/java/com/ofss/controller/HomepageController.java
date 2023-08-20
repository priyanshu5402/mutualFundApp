package com.ofss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomepageController {

	@GetMapping("/dashboard")
    public String showDashboard() {
		System.out.println("inside the showDashboard function");
        return "dashboard"; // Return the name of the HTML file (without extension)
    }	
	@RequestMapping(value ="/login",method=RequestMethod.GET)
    public String showLogin() {
        return "login"; // Return the name of the HTML file (without extension)
    }	
	@GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login"; // Redirect to login page
    }
}
