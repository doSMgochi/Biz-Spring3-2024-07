package com.callor.eventpang.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.callor.eventpang.dao.EventDao;
import com.callor.eventpang.models.EventVO;
import com.callor.eventpang.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	protected final EventDao eventDao;

	public EventServiceImpl(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	@Override
	public int saveEvent(EventVO event) {
		// HttpSession과 category는 이미 컨트롤러에서 처리되므로 이곳에서는 필요 없음
		return eventDao.insert(event); // 데이터베이스에 event 저장 로직
	}

	@Override
	public List<EventVO> selectAll() {
		return eventDao.selectAll();
	}

	@Override
	public EventVO findByNum(int evt_num) {
		return eventDao.findByNum(evt_num);
	}

	@Override
	public int updateEvent(EventVO event) {
		return 0;
	}

	@Override
	public int deleteEvent(int evt_num) {
		return 0;
	}

	@Override
	public List<EventVO> findEventsByCategory(String category) {
		List<EventVO> allEvents = eventDao.selectAll(); // 전체 이벤트 목록 가져오기
		return allEvents.stream().filter(event -> {
			String[] categories = event.getEvt_category().split(",");
			return categories[0].equals(category);
		}).collect(Collectors.toList());
	}

}
