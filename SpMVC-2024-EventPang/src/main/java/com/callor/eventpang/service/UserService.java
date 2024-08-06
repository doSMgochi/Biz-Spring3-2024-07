package com.callor.eventpang.service;

import com.callor.eventpang.models.UserVO;

public interface UserService {
	
	public int join(UserVO userVO);
	public UserVO findById(String id);
}
