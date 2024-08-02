<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<link rel="stylesheet" href="${rootPath }/static/css/user/join.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">

<form class="user join" method="post">
	<fieldset>
		<legend>회원가입</legend>
		<c:if test="${JOIN_MSG == 'FAIL' }">
			<h3>회원가입에 실패했습니다</h3>
		</c:if>
		<div>
			<input type="text" placeholder="USER NAME" name="username"
				autocomplete='off' /> <span>*</span>
		</div>
		<div>
			<input type="password" placeholder="PASSWORD" name="password"
				autocomplete='off' /> <span>*</span>
		</div>
		<div>
			<input type="text" placeholder="본명" name="name" autocomplete='off' />
			<span>*</span>
		</div>
		<div>
			<input type="text" placeholder="별명" name="nick" autocomplete='off' />
			<span>*</span>
		</div>
		<div>
			<input type="button" value="회원가입" />
		</div>
	</fieldset>
</form>