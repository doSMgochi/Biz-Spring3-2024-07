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
	<h1>소소한 이벤트</h1>
	<div class="tag-library">
		<button class="btn tag">태그1</button>
		<button class="btn tag">태그2</button>
		<button class="btn tag">태그3</button>
		<button class="btn tag">태그4</button>
		<button class="btn tag">태그5</button>
		<button class="btn tag">태그6</button>
		<button class="btn tag">태그7</button>
	</div>
	<!-- 로그인이나 회원가입을 했을 때는, 내 응모함과 정보수정, 로그아웃 보여주기 -->
	<section>
		<div class="item">1</div>
		<div class="item">2</div>
		<div class="item">3</div>
		<div class="item">4</div>
		<div class="item">5</div>
		<div class="item">6</div>
		<div class="item">7</div>
		<div class="item">8</div>
		<div class="item">9</div>
		<div class="item">10</div>
		<div class="item">11</div>
		<div class="item">12</div>
	</section>
</body>