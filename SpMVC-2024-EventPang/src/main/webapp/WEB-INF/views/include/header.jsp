<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<header>
<nav>
	<ul>
		<li>메뉴 1</li>
		<li>메뉴 2</li>
		<li>메뉴 3</li>
		<!-- 누르면 화이트로 된 그림자 진 박스 나오고 opacity 조절 -->
	</ul>
</nav>
	<a href=""><img src="${rootPath }/static/images/logo.png" alt="logo"/></a>
	<form>
	<div><input type="text" placeholder="검색어를 입력하세요"/></div>
	</form>
</header>
<section class="main">
	<button class="btn-hover color-1">BUTTON</button>
	<button class="btn-hover color-2">BUTTON</button>
	<button class="btn-hover color-3">BUTTON</button>
	<button class="btn-hover color-4">BUTTON</button>
	<button class="btn-hover color-5"></button>
	<button class="btn-hover color-6">★</button>
	<button class="btn-hover color-7">♥</button>
	<div class="cloud type-1"></div>
	<div class="cloud type-2"></div>
	<div class="cloud type-3"></div>
	<div class="cloud type-4"></div>
	<div class="cloud type-5"></div>
	<!-- 미디어 쿼리로 반응형 셋팅 -->
	<!-- 구름도 늘리면 ... 좋은데 이렇게 코드가 많이 들어가고 결과물도 별로 안 예쁠 바에야 이미지로 하는 것도 고려해야할 듯. -->
	<!-- 배경 자체를 하늘 그라데이션 + 구름이 포함 된 일러스트로 교체 그러면 반응형으로 고생할 필요도 없고 오브젝트를 넣기도 더 편해질 듯? -->
</section>