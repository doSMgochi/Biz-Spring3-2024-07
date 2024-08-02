package com.callor.eventpang.service;

import com.callor.eventpang.models.UserVO;

public interface UserService {
	
	// 회원 가입을 실행하기 위한 method
	public int join(UserVO userVO);
	// username 의 회원정보를 return method
	public UserVO findByUserName(String username);
}
