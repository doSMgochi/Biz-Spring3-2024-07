<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />

<body class="user">
	<nav>
		<ul class="top-nav">
			<li></li>
			<li><a href="${rootPath }/"><img
					src="${rootPath }/static/images/logo.png" alt="logo" /></a></li>
			<li><a href="${rootPath }/user/login">로그인</a></li>
			<li><a href="${rootPath }/user/join">회원가입</a></li>
		</ul>
	</nav>
	<hr class="hr-1" />
	<div class="speech-bubble">로그인</div>
	<section>
		<form class="user join" method="post">
			<c:if test="${not empty MSG}">
				<h3>${MSG }</h3>
			</c:if>
			<input type="text" name="user_id" placeholder="아이디"
				autocomplete="off" /><span>*</span> <input type="password"
				name="user_password" placeholder="비밀번호" autocomplete="off" /><span>*</span>
			<input type="submit" value="로그인" />
		</form>
		<!-- 로그인 유효성 검사 처리 (js로 해보자) 하고, 로그인 세션 처리 -->
		<!-- input relative 해서 absolute로 왼쪽 부분에 칸 먹이자 -->
	</section>
</body>