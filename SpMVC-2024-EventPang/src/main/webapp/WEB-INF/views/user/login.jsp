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
			<li>로그인</li>
			<li>회원가입</li>
		</ul>
	</nav>
	<hr class="hr-1" />
	<h1>로그인</h1>
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
	</section>
</body>