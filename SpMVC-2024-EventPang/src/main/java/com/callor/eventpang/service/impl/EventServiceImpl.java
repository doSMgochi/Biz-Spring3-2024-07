package com.callor.eventpang.service.impl;

import com.callor.eventpang.dao.EventDao;
import com.callor.eventpang.models.EventVO;
import com.callor.eventpang.models.UserVO;
import com.callor.eventpang.service.EventService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

	protected final EventDao eventDao;

	public EventServiceImpl(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	@Override
	public int saveEvent(EventVO event, HttpSession session, String category, String detailCategory) {
		UserVO user = (UserVO) session.getAttribute("USER");

		String combinedCategory = category + "," + detailCategory;
		event.setEvt_category(combinedCategory);

		event.setEvt_userid(user.getUser_id());
		event.setEvt_writed_time(new Date());
		event.setEvt_recommend(0);
		event.setEvt_views(0);

		return eventDao.insert(event);
	}

	@Override
	public List<EventVO> selectAll() {
		return eventDao.selectAll();
	}

	@Override
	public EventVO findByNum(int evt_num) {
		return null;
	}

	@Override
	public int updateEvent(EventVO event) {
		return 0;
	}

	@Override
	public int deleteEvent(int evt_num) {
		return 0;
	}

}
