package com.callor.eventpang.service;

import com.callor.eventpang.models.EventVO;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface EventService {

	public int saveEvent(EventVO event, HttpSession session, String category, String detailCategory);

	public List<EventVO> selectAll();

	public EventVO findByNum(int evt_num);

	public int updateEvent(EventVO event);

	public int deleteEvent(int evt_num);
}