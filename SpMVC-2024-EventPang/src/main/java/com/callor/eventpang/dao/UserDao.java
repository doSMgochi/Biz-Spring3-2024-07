package com.callor.eventpang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.eventpang.models.UserVO;

public interface UserDao {
	
	@Select("SELECT * FROM tbl_user")
	public List<UserVO> selectAll();
	
	@Select("SELECT * FROM tbl_user WHERE USER_ID = #{user_id}")
	public UserVO findById(String id);
	
	public int insert(UserVO userVO);
}
