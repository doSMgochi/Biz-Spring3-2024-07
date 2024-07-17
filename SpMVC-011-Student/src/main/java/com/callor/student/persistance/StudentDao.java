package com.callor.student.persistance;

import org.apache.ibatis.annotations.Insert;

import com.callor.student.models.StudentVO;

public interface StudentDao {
	@Insert("")
	public int insert(StudentVO stVO);
}
