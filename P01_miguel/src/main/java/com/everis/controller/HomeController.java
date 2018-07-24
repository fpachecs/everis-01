package com.everis.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@SuppressWarnings("unused")
@Controller
public class HomeController {
	
	@RequestMapping("/")
	public ModelAndView login() throws Exception {
		
		ModelAndView model = new ModelAndView("Login");
		
		return model;
	}
	@RequestMapping(value="/Principal", method = RequestMethod.GET)
	public ModelAndView principal() throws Exception {
		
		ModelAndView model = new ModelAndView("Principal");
		
		return model;
	}
	
	
}
