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
@RequestMapping(value = "/user")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "user/join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVO userVO, Model model) {

		log.debug("폼에서 전달받은 데이터 : {}", userVO.toString());

		int ret = userService.join(userVO);
		if (ret < 1) {
			model.addAttribute("JOIN_MSG", "FAIL");
			return "user/join";
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@RequestParam(required = false, defaultValue = "") String err, Model model) {
		if (err.equalsIgnoreCase("NEED")) {
			model.addAttribute("MSG", "* 로그인이 필요합니다");
		}
		return null;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserVO userVO, HttpSession httpSession, Model model) {
		   UserVO user = userService.findById(userVO.getUser_id());
	        if (user == null || !user.getUser_password().equals(userVO.getUser_password())) {
	            model.addAttribute("MSG", "* 아이디 또는 비밀번호가 잘못되었습니다.");
	            return "user/login";
	        }
	        
	        httpSession.setAttribute("USER", user);
		return "redirect:/";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		return null;
	}
}
