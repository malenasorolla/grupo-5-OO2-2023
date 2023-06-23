package com.unla.grupo5OO22023.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.unla.grupo5OO22023.helpers.ViewRouteHelper;

@Controller
public class HomeController {
	
	  @GetMapping("/")
	    public String redirectToHome() {
	        return "redirect:/home";
	    }
	  
	@GetMapping({"/home"})
	public String index()  {
		return ViewRouteHelper.INDEX;
	}
	
}
