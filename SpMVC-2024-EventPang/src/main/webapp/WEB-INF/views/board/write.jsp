<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<form>
	<input type="text" name="title" placeholder="이벤트명"/>
	<label for="firstSelect">카테고리</label>
	<select id="firstSelect" name="category">
		<option value="" selected disabled hidden>카테고리 선택</option>
		<option value="big-event">대박이벤트</option>
		<option value="minor-event">소소한 이벤트</option>
		<option value="benefit">혜택</option>
		<option value="community">커뮤니티</option>
	</select>
	<label for="secondSelect">세부 카테고리</label>
    <select id="secondSelect" name="detailCategory">
  
    </select>
	<input type="text" name="host" placeholder="주최자"/>
	<input type="text" name="link" placeholder="응모 링크"/>
	<textarea rows="" cols="" name="body">내용을 입력하세요</textarea>
	<input type="text" name="tag" placeholder="태그"/>
	시작 시간 <input type="date" name="startTime">
	종료 시간 <input type="date" name="endTime">
	당첨일 <input type="date" name="winningTime">
	<input type="number" name="winner" placeholder="당첨자 수">
	<input type="text" name="reward" placeholder="보상 내용">
	<!-- 첫 번째 select 에서 옵션을 선택하면 두 번째 select 옵션이 동적으로 변경되게 js 처리 (change) -->
	<!-- hidden 으로 유저 정보 보내기 (닉네임, 작성 시간) -->
	<!-- tag에서 입력하고 추가를 누르면 입력된 박스가 하나 생기고 x 버튼으로 삭제할 수 있게 하기 -->
</form>