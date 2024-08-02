<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<body class="info">
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
	<h1>커뮤니티</h1>
	<!-- 로그인이나 회원가입을 했을 때는, 내 응모함과 정보수정, 로그아웃 보여주기 -->
</body>