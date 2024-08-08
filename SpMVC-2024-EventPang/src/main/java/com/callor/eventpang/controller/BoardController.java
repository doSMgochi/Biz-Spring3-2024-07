package com.callor.eventpang.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.eventpang.models.UserVO;
import com.callor.eventpang.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/board")
public class BoardController {

	private final UserService userService;

	public BoardController(UserService userService) {
		super();
		this.userService = userService;
	}

	@RequestMapping(value = "/big-event", method = RequestMethod.GET)
	public String bigEvent(HttpSession httpSession, Model model) {
	    UserVO userVO = (UserVO) httpSession.getAttribute("USER");
	    model.addAttribute("logon", userVO);
	    return null;
	}

	@RequestMapping(value = "/minor-event", method = RequestMethod.GET)
	public String minorEvent() {

		return null;
	}

	@RequestMapping(value = "/benefit", method = RequestMethod.GET)
	public String benefit() {

		return null;
	}

	@RequestMapping(value = "/community", method = RequestMethod.GET)
	public String community() {

		return null;
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write() {
		
		return null;
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search() {
		
		return null;
	}
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String view() {
		
		return null;
	}
}
