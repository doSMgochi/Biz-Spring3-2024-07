<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />

<h1>${event.evt_title}</h1>
<p>주최자: ${event.evt_host}</p>
<p>카테고리: ${event.evt_category}</p>
<p>시작 날짜: ${event.evt_start_time}</p>
<p>마감 날짜: ${event.evt_end_time}</p>
<p>당첨 날짜: ${event.evt_winning_time}</p>
<p>보상 내용: ${event.evt_reward}</p>
<p>당첨자 수: ${event.evt_winner}</p>

<p>내용:</p>
<p>${event.evt_body}</p>
