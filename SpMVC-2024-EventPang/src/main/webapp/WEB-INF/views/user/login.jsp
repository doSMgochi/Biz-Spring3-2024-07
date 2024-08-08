<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />


<div class="speech-bubble">로그인</div>
<section>
	<form class="user join" method="post">
		<c:if test="${not empty MSG}">
			<h4>${MSG }</h4>
		</c:if>
		<div>
			<input type="text" name="user_id" placeholder="아이디"
				autocomplete="off" /> <span style="display: none;"></span>
		</div>
		<div>
			<input type="password" name="user_password" placeholder="비밀번호"
				autocomplete="off" /> <span style="display: none;"></span>
		</div>
		<input type="button" value="로그인" />
	</form>
</section>