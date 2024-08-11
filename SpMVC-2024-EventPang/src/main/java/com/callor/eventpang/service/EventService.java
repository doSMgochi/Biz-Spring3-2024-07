package com.callor.eventpang.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.callor.eventpang.models.EventVO;

public interface EventService {

	public int saveEvent(EventVO event);

	public List<EventVO> selectAll();

	public EventVO findByNum(int evt_num);

	public int updateEvent(EventVO event);

	public int deleteEvent(int evt_num);
	
	public List<EventVO> findEventsByCategory(String category);
	
	public Map<String, String> splitCategory(String category);
	public String formatDateTime(Date date);
}