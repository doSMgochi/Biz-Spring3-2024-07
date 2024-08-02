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

	// http://localhost:8080/student/user/join 까지의 요청을 처리할 부분
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "user/join";
	}

	// 회원가입 화면에 입력 후 회원가입 신청을 했을 때
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(UserVO userVO, Model model) {

		// console 에 디버그 메시지를 표시하는 method
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
			model.addAttribute("MSG", "로그인이 필요합니다");
		}
		return null;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserVO userVO, HttpSession httpSession) {
		httpSession.setAttribute("USER", userVO);
		return "redirect:/";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		return null;
	}
}
