<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<link rel="stylesheet" href="${rootPath }/static/css/user/join.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
<body class="user">

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
	<div class="speech-bubble">회원가입</div>
	<section>
		<form class="user join" method="post">
			<c:if test="${JOIN_MSG == 'FAIL' }">
				<h3>회원가입에 실패했습니다</h3>
			</c:if>
			<div>
				<input type="text" placeholder="아이디" name="user_id" id="user_id" autocomplete='off' />
				<span>*</span>
			</div>
			<div>
				<input type="password" placeholder="비밀번호" name="user_password" id="user_password"
					autocomplete='off' /> <span>*</span>
			</div>
			<div>
				<input type="text" placeholder="닉네임" name="user_nick" id="user_nick" autocomplete='off' />
				<span>*</span>
			</div>
			<div>
				<input type="text" placeholder="이메일" name="user_email" id="user_email" autocomplete='off' />
				<span>*</span>
			</div>
			<div>
				<input type="date" placeholder="생년월일 (6자리)" name="user_birth" id="user_birth"/> <span>*</span>
			</div>
			<div>
				<input type="text" placeholder="전화번호" name="user_tel" id="user_tel" autocomplete='off' />
				<span>*</span>
			</div>
			<div>
				<label for="male"><input type="radio" name="user_gender"
					value="male" id="male" checked /> 남성 </label> <label for="female"><input
					type="radio" name="user_gender" value="female" id="female" /> 여성 </label>
			</div>
			<div>
				<label for="enterprise"><input type="radio" name="user_role"
					value="enterprise" id="enterprise" /> 기업 </label> <label for="personal"><input
					type="radio" name="user_role" value="personal" id="personal" checked />
					개인 </label>
			</div>
			<div>
				<input type="button" value="회원가입" />
			</div>
			<!-- date 타입의 input 에 placeholder 넣는 방법 찾고, 라디오 버튼 input 박스 css 처리, join.js 에서 유효성 검사 처리 -->
		</form>
	</section>
</body>