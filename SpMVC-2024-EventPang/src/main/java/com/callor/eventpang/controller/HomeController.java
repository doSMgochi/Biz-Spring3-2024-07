package com.callor.eventpang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "home";
	}

	@RequestMapping(value = "/big-event", method = RequestMethod.GET)
	public String bigEvent() {

		return "big-event";
	}

	@RequestMapping(value = "/minor-event", method = RequestMethod.GET)
	public String minorEvent() {

		return "minor-event";
	}

	@RequestMapping(value = "/benefit", method = RequestMethod.GET)
	public String benefit() {

		return "benefit";
	}

	@RequestMapping(value = "/community", method = RequestMethod.GET)
	public String community() {

		return "community";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {
		
		return "write";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search() {
		
		return "search";
	}
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view() {
		
		return "view";
	}
	
	
}
