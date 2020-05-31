package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping(value = "/home")
	public void home() {

		System.out.println("home called..");

		// return "home1";
	}

	@RequestMapping(value = "/insertuser1")
	public String insertUser(@RequestParam("txtFirstName") String fname, 
			@RequestParam("txtLastName") String lname) {

		// req.getpa
		System.out.println(fname.concat(lname));

		return "home";
	}

}
