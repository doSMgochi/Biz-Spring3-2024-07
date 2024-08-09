package com.callor.eventpang.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.callor.eventpang.models.EventVO;
import com.callor.eventpang.models.UserVO;
import com.callor.eventpang.service.EventService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/board")
public class BoardController {

    private final EventService eventService;

    public BoardController(EventService eventService) {
        super();
        this.eventService = eventService;
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

    @RequestMapping(value = "/event-write", method = RequestMethod.GET)
    public String write(HttpSession session) {
        UserVO user = (UserVO)session.getAttribute("USER");

        if (user == null) {
            return "redirect:/user/login";
        }

        return "board/event-write";
    }

    @RequestMapping(value = "/event-write", method = RequestMethod.POST)
    public String create(EventVO event, HttpSession session, String category, String detailCategory) {
        eventService.saveEvent(event, session, category, detailCategory);
        return "home";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view() {
        return null;
    }

    @RequestMapping(value = "/upload-image", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> uploadImage(@RequestParam("upload") MultipartFile file, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();

        String uploadDir = request.getServletContext().getRealPath("/upload/");

        File uploadDirFile = new File(uploadDir);
        if (!uploadDirFile.exists()) {
            uploadDirFile.mkdirs();
        }

        String fileName = file.getOriginalFilename();
        File destinationFile = new File(uploadDir + fileName);
        try {
            file.transferTo(destinationFile);
            String imageUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/upload/" + fileName;
            result.put("uploaded", true); 
            result.put("url", imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
            result.put("uploaded", false);
            result.put("error", "File upload failed");
        }

        return result;
    }
}