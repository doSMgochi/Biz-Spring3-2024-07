<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<div class="align-center">
		<table>
			<thead>
				<tr>
					<th colspan="6">학생정보</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>학번</td>
					<td>이름</td>
					<td>학과</td>
					<td>학년</td>
					<td>전화번호</td>
					<td>주소</td>
				</tr>
				<tr>
					<td>S0001</td>
					<td>홍길동</td>
					<td>디지털미디어학과</td>
					<td>3</td>
					<td>010-1111-2222</td>
					<td>경남 서산시 반야동 212-7</td>
				</tr>
				<c:forEach items="${ST_LIST }" var="ST">
					<tr data-st_num="${ST.st_num }">
						<td>${ST.st_num }</td>
						<td>${ST.st_name }</td>
						<td>${ST.st_dept }</td>
						<td>${ST.st_grade }</td>
						<td>${ST.st_tel }</td>
						<td>${ST.st_addr }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="align-center">
		<a href="${rootPath }/student/insert"><button>학생정보 등록</button></a>
	</div>
</body>