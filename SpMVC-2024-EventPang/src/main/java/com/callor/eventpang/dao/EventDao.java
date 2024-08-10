package com.callor.eventpang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.callor.eventpang.models.EventVO;
import com.callor.eventpang.models.UserVO;

public interface EventDao {
	@Select("SELECT * FROM tbl_event ORDER BY evt_num")
	public List<EventVO> selectAll();
	
	@Select("SELECT * FROM tbl_event WHERE evt_num = #{evt_num}")
	public EventVO findByNum(int num);
	
	@Delete("DELETE FROM tbl_event WHERE evt_num = #{evt_num}")
	public int deleteByNum(int num);
	
	public int update(int num);
	
	public int insert(EventVO eventVO);
}
