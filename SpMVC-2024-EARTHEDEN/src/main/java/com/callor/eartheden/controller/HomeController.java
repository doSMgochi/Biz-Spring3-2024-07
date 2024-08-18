package com.callor.eartheden.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.eartheden.models.TrashCanVO;
import com.callor.eartheden.service.TrashCanService;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    private final TrashCanService trashCanService;
    private final ServletContext servletContext;

    public HomeController(TrashCanService trashCanService, ServletContext servletContext) {
        this.trashCanService = trashCanService;
        this.servletContext = servletContext;
    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("region", "서울");
        model.addAttribute("rootPath", servletContext.getContextPath());
        return "home";
    }

    @RequestMapping("/search")
    public String search(@RequestParam(value = "region", required = false) String region,
                         @RequestParam(value = "search", required = false) String search, Model model) {

        logger.info("Received search request - Region: {}, Search: {}", region, search);

        List<TrashCanVO> trashCans = Collections.emptyList();

        try {
            if (search != null && !search.isEmpty()) {
                // 검색어가 입력된 경우
                trashCans = trashCanService.searchTrashCans(search, servletContext.getContextPath());
                logger.info("Search results found: {}", trashCans.size());
            } else if (region != null && !region.isEmpty()) {
                // 지역명이 입력된 경우
                String decodedRegion = URLDecoder.decode(region, StandardCharsets.UTF_8.toString());
                trashCans = trashCanService.getTrashCansByRegion(decodedRegion, servletContext.getContextPath());
                logger.info("Region results found: {}", trashCans.size());
            } else {
                logger.warn("No search or region specified, returning empty list.");
            }
        } catch (IOException e) {
            logger.error("I/O error during search operation", e);
            model.addAttribute("errorMessage", "데이터를 불러오는 중 오류가 발생했습니다. 다시 시도해 주세요.");
            return "fragments/trashcans";
        } catch (Exception e) {
            logger.error("Unexpected error during search operation", e);
            model.addAttribute("errorMessage", "알 수 없는 오류가 발생했습니다. 다시 시도해 주세요.");
            return "fragments/trashcans";
        }

        if (trashCans.isEmpty()) {
            model.addAttribute("noResults", true); // 검색 결과가 없는 경우
            logger.info("No results found for the given search criteria.");
        } else {
            model.addAttribute("noResults", false); // 검색 결과가 있는 경우
            model.addAttribute("trashCans", trashCans);
            logger.info("Returning {} search results.", trashCans.size());
        }
// 코드가 상경하는 문제 해결해야함
        return "fragments/trashcans"; 
    }
}
