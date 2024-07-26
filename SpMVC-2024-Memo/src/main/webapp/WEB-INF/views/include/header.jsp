<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />

<head>
    <script type="text/javascript">
        function btnClick() {
            const dateInput = document.getElementById("date-input");
            const timeInput = document.getElementById("time-input");

            var today = new Date();
            var year = today.getFullYear();
            var month = ("0" + (today.getMonth() + 1)).slice(-2);
            var day = ("0" + today.getDate()).slice(-2);

            var hours = ("0" + today.getHours()).slice(-2);
            var minutes = ("0" + today.getMinutes()).slice(-2);

            var dateString = year + "-" + month + "-" + day;
            var timeString = hours + ":" + minutes;

            dateInput.value = dateString;
            timeInput.value = timeString;
        }
    </script>
</head>
<header>
    <h1>오늘은 내 생의 가장 젊은 날</h1>
</header>
<hr class="hr-16" />
<section class="main">
    <div class="body">
        <form onsubmit="return false;">
            <input id="date-input" type="date" /> 
            <input id="time-input" type="time" />
            <button type="button" onclick="btnClick()">새로작성</button>
        </form>
        <ul data-m_seq="${MEMO.m_seq }">
            <c:forEach items="${MEMO_LIST }" var="MEMO">
                <li><a href="${rootPath }/view?num=${MEMO.m_seq}">${MEMO.m_memo }</a></li>
            </c:forEach>
        </ul>
    </div>
</section>
</body>
</html>