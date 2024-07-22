<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<nav class="main">
	<ul>
		<li>Home</li>
		<li>공지사항</li>
		<li><a href="${rootPath }/user/login">로그인</a></li>
		<li><a href="${rootPath }/user/join">회원가입</a></li>
	</ul>
</nav>