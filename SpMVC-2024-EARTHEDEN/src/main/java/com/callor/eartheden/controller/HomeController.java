package com.callor.eartheden.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.eartheden.models.TrashCanVO;
import com.callor.eartheden.service.TrashCanService;

@Controller
public class HomeController {
	@Autowired
	private TrashCanService trashCanService;
    @Autowired
    private ServletContext servletContext;

	@RequestMapping("/")
	public String getTrashBinsByRegion(@RequestParam(value = "region", required = false) String region, Model model)
			throws IOException {
		if (region == null || region.isEmpty()) {
			region = "서울";
		}

		List<TrashCanVO> trashCans = trashCanService.getTrashCansByRegion(region, servletContext.getRealPath("/"));
		model.addAttribute("region", region);
		model.addAttribute("trashCans", trashCans);
		return "home";
	}
	
	
}
