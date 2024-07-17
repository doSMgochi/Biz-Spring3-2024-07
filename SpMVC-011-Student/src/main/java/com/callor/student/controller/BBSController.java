package com.callor.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/bbs")
public class BBSController {
	// localhost:8080/student/bbs/
	// localhost:8080/student/bbs
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String bbs(Model model) {

		return "bbs/list";
	}

	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String notice(Model model) {
		// return /WEB-INF/views/bbs/notice.jsp 파일을 찾아라
		return null;
	}
}
