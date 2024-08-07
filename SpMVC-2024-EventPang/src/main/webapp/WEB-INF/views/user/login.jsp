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
				<h4>${MSG }</h4>
			</c:if>
			<div>
				<input type="text" name="userId" placeholder="아이디"
					autocomplete="off" /> <span style="display: none;"></span>
			</div>
			<div>
				<input type="password" name="userPassword" placeholder="비밀번호"
					autocomplete="off" /> <span style="display: none;"></span>
			</div>
			<input type="button" value="로그인" />
		</form>
	</section>
	<script src="${rootPath}/static/js/login.js"></script>
</body>