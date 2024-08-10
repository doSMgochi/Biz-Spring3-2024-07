<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />

<h1>${categoryTitle}</h1>

<div class="tag-library">
	<button class="btn tag">태그1</button>
	<button class="btn tag">태그2</button>
	<button class="btn tag">태그3</button>
	<button class="btn tag">태그4</button>
	<button class="btn tag">태그5</button>
	<button class="btn tag">태그6</button>
	<button class="btn tag">태그7</button>
</div>
<section class="items">
	<c:forEach var="event" items="${events}">
		<div class="item">
			<a href="${rootPath}/board/view/${event.evt_num}">
				${event.evt_title} </a>
		</div>
	</c:forEach>
</section>