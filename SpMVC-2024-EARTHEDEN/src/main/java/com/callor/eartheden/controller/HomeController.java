package com.callor.eartheden.controller;

import java.io.IOException;
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
        logger.info("Home page requested");
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
                logger.info("Performing search with query: {}", search);
                trashCans = trashCanService.searchTrashCans(search, servletContext.getContextPath());
                logger.info("Search returned {} results", trashCans.size());
            } else if (region != null && !region.isEmpty()) {
                logger.info("Filtering by region: {}", region);
                trashCans = trashCanService.getTrashCansByRegion(region, servletContext.getContextPath());
                logger.info("Filtering by region returned {} results", trashCans.size());
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
            logger.info("No results found for the given criteria.");
            model.addAttribute("noResults", true);
        } else {
            model.addAttribute("noResults", false);
            model.addAttribute("trashCans", trashCans);
        }

        return "fragments/trashcans";
    }
}