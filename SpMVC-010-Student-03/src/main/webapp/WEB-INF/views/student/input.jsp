<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<link rel="stylesheet" href="${rootPath }/static/css/student/input.css" />
	<section class="student input">
		<form method="post">
			<fieldset>
				<legend>
					<c:if test="${empty ST }">학생정보 입력</c:if>
					<c:if test="${not empty ST }">학생정보 수정</c:if>
				</legend>
				<div>
					<label for="st_num">학번</label><input type="text" name="st_num"
						id="st_num" value="${ST.st_num }">
						<input type="hidden" name="st_new" id="st_new"  value="${ST.st_num }">
				</div>
				<div>
					<label for="st_name">이름</label><input type="text" name="st_name"
						id="st_name" value="${ST.st_name }">
				</div>
				<div>
					<label for="st_dept">학과</label><input type="text" name="st_dept"
						id="st_dept" value="${ST.st_dept }">
				</div>
				<div>
					<label for="st_grade">학년</label><input type="text" name="st_grade"
						id="st_grade" value="${ST.st_grade }">
				</div>
				<div>
					<label for="st_tel">전화번호</label><input type="text" name="st_tel"
						id="st_tel" value="${ST.st_tel }">
				</div>
				<div>
					<label for="st_addr">주소</label><input type="text" name="st_addr"
						id="st_addr" value="${ST.st_addr }">
				</div>
				<div>
					<label></label>
					<button type="button" class="save">저장</button>
				</div>
			</fieldset>
		</form>
	</section>
