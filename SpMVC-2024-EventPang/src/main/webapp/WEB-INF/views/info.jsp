<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<body>
	<header>
		<nav>
			<ul>
				<li><a href="${rootPath }/write">(임시) 이벤트 작성</a></li>
				<li>메뉴 2</li>
				<li>메뉴 3</li>
				<!-- 누르면 화이트로 된 그림자 진 박스 나오고 opacity 조절 -->
			</ul>
		</nav>
		<a href=""><img src="${rootPath }/static/images/logo.png"
			alt="logo" /></a>
		<form action="${rootPath }/search">
			<div>
				<input type="text" placeholder="검색어를 입력하세요" name="search"/>
			</div>
		</form>
	</header>
	<section class="main">
		<div class="button-container">
			<a href="${rootPath }/big-event"><button class="btn-hover color-1">대박이벤트</button></a>
			<img class="tales-1"
				src="${rootPath }/static/images/balloon_tales.png" alt="tales" />
		</div>
		<div class="button-container">
			<a href="${rootPath }/minor-event"><button class="btn-hover color-2">소소한 이벤트</button></a>
			<img class="tales-2"
				src="${rootPath }/static/images/balloon_tales.png" alt="tales" />
		</div>
		<div class="button-container">
			<a href="${rootPath }/benefit">	<button class="btn-hover color-3">혜택</button></a>
			<img class="tales-3"
				src="${rootPath }/static/images/balloon_tales.png" alt="tales" />
		</div>
		<div class="button-container">
			<a href="${rootPath }/community">	<button class="btn-hover color-4">커뮤니티</button></a>
			<img class="tales-4"
				src="${rootPath }/static/images/balloon_tales.png" alt="tales" />
		</div>
		<div class="button-container">
			<button class="btn-hover color-5"></button>
			<img class="tales-5"
				src="${rootPath }/static/images/balloon_tales.png" alt="tales" />
		</div>
		<div class="button-container">
			<button class="btn-hover color-6">★</button>
			<img class="tales-6"
				src="${rootPath }/static/images/balloon_tales.png" alt="tales" />
		</div>
		<div class="button-container">
			<button class="btn-hover color-7">♥</button>
			<img class="tales-7"
				src="${rootPath }/static/images/balloon_tales.png" alt="tales" />
		</div>
		<div class="cloud type-1"></div>
		<div class="cloud type-2"></div>
		<div class="cloud type-3"></div>
		<div class="cloud type-4"></div>
		<div class="cloud type-5"></div>
		<!-- png 투명 부분은 커서가 안 올라오게 할 수 있으려나? -->
	</section>
</body>