<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />

<h1>이벤트 상세보기</h1>
<div class="tag-library"></div>
<div class="view">
	<div>제목</div>
	<div>
		<span>작성시간</span> <span>조회수</span> <span>추천수</span> <span>작성자</span>
	</div>
	<div>
		<span>주최자</span> <span>응모기간</span> <span>발표일</span> <span>당첨자수</span>
	</div>
	<div>태그</div>
	<div>
		<span>북마크</span> <span>추천</span> <span>응모하기</span>
	</div>
	<div>내용</div>
	<div>댓글</div>
	<div>
		<span>이전글</span> <span>다음글</span> <span>목록</span> <span>(수정)</span> <span>(삭제)</span>
	</div>
</div>