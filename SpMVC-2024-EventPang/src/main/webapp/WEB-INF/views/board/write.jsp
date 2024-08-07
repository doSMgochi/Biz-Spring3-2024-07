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
			<li><a href="${rootPath }/user/login">로그인</a></li>
			<li><a href="${rootPath }/user/join">회원가입</a></li>
		</ul>
	</nav>
	<hr class="hr-1" />
	<h1>이벤트작성</h1>
	<form class="write">
		<input type="text" name="title" placeholder="이벤트명" />
		<div class="half-box">
			<select id="firstSelect" name="category">
				<option value="" selected disabled hidden>카테고리</option>
				<option value="big-event">대박이벤트</option>
				<option value="minor-event">소소한 이벤트</option>
				<option value="benefit">혜택</option>
				<option value="community">커뮤니티</option>
			</select> <select id="secondSelect" name="detailCategory">
				<option value="" selected disabled hidden>세부 카테고리</option>
			</select>
		</div>
		<div class="half-box">
			<input type="text" name="host" placeholder="주최자" /> <input
				type="text" name="link" placeholder="응모 링크" />
		</div>
		<textarea rows="" cols="" name="body"></textarea>
		<input type="text" name="tag" placeholder="태그" />
		<div class="three-box">
			<div>시작 날짜</div>
			<div>마감 날짜</div>
			<div>당첨 날짜</div>
		</div>
		<div class="three-box">
			<input type="date" name="startTime"> <input type="date"
				name="endTime"><input type="date" name="winningTime">

		</div>
		<input type="number" name="winner" placeholder="당첨자 수"> <input
			type="text" name="reward" placeholder="보상 내용"> <input
			type="submit" value="작성" />
		<!-- 첫 번째 select 에서 옵션을 선택하면 두 번째 select 옵션이 동적으로 변경되게 js 처리 (change) -->
		<!-- hidden 으로 유저 정보 보내기 (닉네임, 작성 시간) -->
		<!-- tag에서 입력하고 추가를 누르면 입력된 박스가 하나 생기고 x 버튼으로 삭제할 수 있게 하기 -->
	</form>
</body>