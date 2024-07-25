<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<link rel="stylesheet" href="${rootPath }/static/css/user/join.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
<form class="user join" method="post">
	<fieldset>
		<legend>로그인</legend>
		<c:if test="${not empty MSG}">
			<h3>${MSG }</h3>
		</c:if>
		<div>
			<i class="fa-solid fa-user"></i><input type="text" placeholder="USER NAME" name="username" autocomplete='off'/> <span>*</span>
		</div>
		<div>
			<i class="fa-solid fa-key"></i><input type="password" placeholder="PASSWORD" name="password" autocomplete='off'/> <span>*</span>
		</div>
		<div>
		<i class="fa-solid fa-right-to-bracket"></i><input type="submit" value="로그인" />
		</div>
	</fieldset>
</form>