<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />

<h1>이벤트작성</h1>
<form class="write" method="post" id="event-write">
	<input type="text" name="evt_title" placeholder="이벤트명" />
	<div class="half-box">
		<select id="firstSelect" name="category">
			<option value="" selected disabled hidden>카테고리</option>
			<option value="big-event">대박이벤트</option>
			<option value="minor-event">소소한 이벤트</option>
			<option value="benefit">혜택</option>
			<option value="community">커뮤니티</option>
		</select> <select id="secondSelect" name="detailCategory">
			<option selected disabled hidden>세부 카테고리</option>
			<option value="quiz">퀴즈</option>
			<option value="comment">작문/댓글</option>
			<option value="follow">팔로우/구독</option>
			<option value="share">공유/초대</option>
			<option value="proof">인증샷</option>
			<option value="simple">단순응모</option>
			<option value="experience">체험단</option>
			<option value="survey">설문/투표</option>
			<option value="instant">즉석당첨</option>
			<option value="join">신규가입</option>
			<option value="buy">구매/샘플</option>
			<option value="certainty">100%당첨</option>
			<option value="first">선착순</option>
			<option value="check">출석체크</option>
			<option value="download">앱설치</option>
			<option value="contest">공모전</option>
			<option value="live">라이브방송</option>
			<option value="etc">기타</option>
		</select>
	</div>
	<div class="half-box">
		<input type="text" name="evt_host" placeholder="주최자" /> <input
			type="text" name="evt_link" placeholder="응모 링크" />
	</div>
	<textarea name="evt_body" id="editor" rows="10" cols="80"></textarea>
	<input type="text" name="evt_tags" placeholder="태그" />
	<div class="three-box">
		<div>시작 날짜</div>
		<div>마감 날짜</div>
		<div>당첨 날짜</div>
	</div>
	<div class="three-box">
		<input type="date" name="evt_start_time"> <input type="date"
			name="evt_end_time"> <input type="date"
			name="evt_winning_time">
	</div>
	<input type="number" name="evt_winner" placeholder="당첨자 수"> <input
		type="text" name="evt_reward" placeholder="보상 내용"> <input
		type="submit" value="작성" />
</form>