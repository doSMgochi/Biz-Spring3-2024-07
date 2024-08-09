<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>이벤트팡!</title>
<link href="${rootPath }/static/css/main.css" rel="stylesheet" />
<link href="${rootPath }/static/css/board.css" rel="stylesheet" />
<link href="${rootPath }/static/css/user.css" rel="stylesheet" />
<script src="https://cdn.ckeditor.com/4.22.1/standard/ckeditor.js"></script>
<script>
	document.addEventListener("DOMContentLoaded", function() {
		CKEDITOR.replace('editor', {
		    filebrowserUploadUrl: '${rootPath}/board/upload-image',  // 수정된 경로
		    filebrowserUploadMethod: 'form'
		});
	});
</script>

<script>
	const rootPath = "${rootPath}";
</script>
<script src="${rootPath }/static/js/main.js"></script>
<script src="${rootPath }/static/js/user/join.js"></script>
<script src="${rootPath }/static/js/user/login.js"></script>
<script src="${rootPath }/static/js/board/board.js"></script>
</head>
