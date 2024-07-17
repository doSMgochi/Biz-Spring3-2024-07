package com.callor.student.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.student.models.StudentVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	// http://localhost:8080/student/ 로 request 가 오면
	// http://localhost:8080/student 로 request 가 오면
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}
	// 학생정보를 입력받기 위한 화면을 보여주는 Method
	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input() {
		return "student/input";
	}
	// 학생정보 입력화면에서 데이터를 입력한 후 전송(저장) 을 클릭했을 때
	// 데이터를 전달받는 method
	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String input(StudentVO studentVO, Model model) {
		model.addAttribute("STD", studentVO);
		return "student/view";
	}
}
