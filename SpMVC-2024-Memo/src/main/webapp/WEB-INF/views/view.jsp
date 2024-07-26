<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<section class="content">
	<div class="body">
	<ul data-m_seq="${MEMO.m_seq }">
		<c:forEach items="${MEMO_LIST }" var="MEMO">
			<li>작성자 : ${MEMO.m_author }</li>
			<li>작성일자 : ${MEMO.m_date } ${MEMO.m_time }</li>
			<li>${MEMO.m_memo }</li>
			<li><img src="${MEMO.m_image }" alt="이미지"/></li>
		</c:forEach>
	</ul>
	</div>
</section>