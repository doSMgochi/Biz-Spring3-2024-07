package com.callor.memo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.memo.models.Memo;
@Service
public interface MemoService {
	public List<Memo> selectAll();
	public Memo findById(String m_seq);
	
	public int insert(Memo memo);
	public int update(Memo memo);
	public int delete(String m_seq);
}
