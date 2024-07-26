package com.callor.memo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.memo.dao.MemoDao;
import com.callor.memo.model.MemoVO;
import com.callor.memo.service.MemoService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private final MemoDao memoDao;
	private final MemoService memoService;

	public HomeController(MemoDao memoDao, MemoService memoService) {
		super();
		this.memoDao = memoDao;
		this.memoService = memoService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpSession httpSession, Model model) {

		MemoVO memoVO = (MemoVO) httpSession.getAttribute("MEMO");
		List<MemoVO> memoList = memoDao.selectAll();
		model.addAttribute("MEMO_LIST", memoList);
		return "home";
	}

	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write(HttpSession httpSession, Model model) {
		MemoVO memoVO = (MemoVO) httpSession.getAttribute("MEMO");
		List<MemoVO> memoList = memoDao.selectAll();
		model.addAttribute("MEMO_LIST", memoList);
		return "write";
	}

	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String view(HttpSession httpSession, Model model) {
		MemoVO memoVO = (MemoVO) httpSession.getAttribute("MEMO");
		List<MemoVO> memoList = memoDao.selectAll();
		model.addAttribute("MEMO_LIST", memoList);

		model.getAttribute("num");
		return "view";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(MemoVO memoVO, Model model) {
		model.addAttribute("MV", memoVO);

		int result = memoDao.insert(memoVO);
		return "redirect:/";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(int m_seq, Model model) {
		MemoVO memoVO = memoDao.findBySeq(m_seq);
		model.addAttribute("MV", memoVO);
		return "write";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(MemoVO memoVO) {
		memoVO.setM_memo(memoVO.getM_memo());
		memoVO.setM_image(memoVO.getM_image());
		int result = memoDao.update(memoVO);
		return "redirect:/view?num=" + memoVO.getM_seq();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(int m_seq) {
		int result = memoDao.delete(m_seq);
		return "redirect:/";
	}

}
