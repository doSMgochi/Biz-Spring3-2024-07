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

	@RequestMapping(value = "/input", method = RequestMethod.GET)
	public String input(Model model) {
		return "student/input";
	}
	
	@RequestMapping(value = "/input", method = RequestMethod.POST)
	public String input(StudentVO studentVO) {
		return "student/input";
	}
}
