<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<!DOCTYPE html>

<div class="speech-bubble">회원정보수정</div>
<section>
	<form class="user join" method="post">
		<c:if test="${JOIN_MSG == 'FAIL' }">
			<h3>정보수정에 실패했습니다</h3>
		</c:if>
		<div>
			<input type="text" placeholder="아이디" name="user_id" id="user_id"
				value="${USER.user_id }" readonly /> <span>*</span>
		</div>
		<div>
			<input type="password" placeholder="비밀번호" name="user_password"
				id="user_password" autocomplete='off' /> <span>*</span>
		</div>
		<div>
			<input type="text" placeholder="닉네임" name="user_nick" id="user_nick"
				autocomplete='off' value="${USER.user_nick }" /> <span>*</span>
		</div>
		<div>
			<input type="text" placeholder="이메일" name="user_email"
				id="user_email" autocomplete='off' value="${USER.user_email }" /> <span>*</span>
		</div>
		<div>
			<input type="date" placeholder="생년월일 (6자리)" name="user_birth"
				id="user_birth" value="${USER.user_birth }" /> <span>*</span>
		</div>
		<div>
			<input type="text" placeholder="전화번호" name="user_tel" id="user_tel"
				autocomplete='off' value="${USER.user_tel }" /> <span>*</span>
		</div>
		<div>
			<c:choose>
				<c:when test="${not empty USER && USER.user_gender eq 'male'}">
					<label for="male"><input type="radio" name="user_gender"
						value="male" id="male" checked /> 남성 </label>
					<label for="female"><input type="radio" name="user_gender"
						value="female" id="female" /> 여성 </label>
				</c:when>
				<c:otherwise>
					<label for="male"><input type="radio" name="user_gender"
						value="male" id="male" /> 남성 </label>
					<label for="female"><input type="radio" name="user_gender"
						value="female" id="female" checked /> 여성 </label>
				</c:otherwise>
			</c:choose>
		</div>
		<div>
			<c:choose>
				<c:when test="${not empty USER && USER.user_role eq 'enterprise'}">
					<label for="enterprise"><input type="radio"
						name="user_role" value="enterprise" id="enterprise" checked /> 기업
					</label>
					<label for="personal"><input type="radio" name="user_role"
						value="personal" id="personal" /> 개인 </label>
				</c:when>
				<c:otherwise>
					<label for="enterprise"><input type="radio"
						name="user_role" value="enterprise" id="enterprise" /> 기업 </label>
					<label for="personal"><input type="radio" name="user_role"
						value="personal" id="personal" checked /> 개인 </label>
				</c:otherwise>
			</c:choose>
		</div>
		<div>
			<input type="button" value="정보수정" />
		</div>
		<!-- date 타입의 input 에 placeholder 넣는 방법 찾고, 라디오 버튼 input 박스 css 처리, join.js 에서 유효성 검사 처리 -->
	</form>
</section>