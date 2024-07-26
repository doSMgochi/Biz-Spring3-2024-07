<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section class="content">
	<form class="no-flex" action="">
		<textarea placeholder="내용을 입력하세요" name="m_memo"></textarea>
		<input type="text" placeholder="이미지 URL을 입력하세요" />
		<button type="submit">저장</button>
		<!-- 가장 큰 숫자 조회해서 seq 올리고 author는 고정, date는
		클릭 한 순간 넘어가게 하든지 (한다면 input은 모두 JS 로 처리)
		아니면 스프링에서 처리할 때 currentTime 잡아서 보내기-->
	</form>
</section>