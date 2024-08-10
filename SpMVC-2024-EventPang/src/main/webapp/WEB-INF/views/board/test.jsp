<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="rootPath" />

<button class="btn-hover color-1 fireworkBtn" id="fireworkBtn">
    대박이벤트
    <span class="firework"></span>
    <span class="firework"></span>
    <span class="firework"></span>
    <span class="firework"></span>
    <span class="firework"></span>
</button>

<style>
.btn-hover {
    position: relative;
    cursor: pointer;
    color: #fff;
    background: #000;
    border: 0;
    padding: 5px 20px;
    border-radius: 2px;
    z-index: 5;
}

.firework {
    display: inline-block;
    width: 10px;
    height: 10px;
    border: 2px dotted rgb(255, 99, 71);
    border-radius: 50%;
    opacity: 0;
    position: absolute;
    z-index: 10;
}

@keyframes burst {
    0% {
        transform: scale(0);
        opacity: 1;
    }
    60%, 90% {
        transform: scale(1);
        opacity: 1; /* Ensure it's visible */
    }
    100% {
        transform: scale(1.2);
        opacity: 0;
    }
}

.btn-hover.on .firework {
    animation: burst 2s forwards;
    opacity: 1; /* Start the animation as visible */
}

.firework:nth-child(1) { 
    top: -20px; 
    left: 50%; 
    transform: translateX(-50%);
    animation-delay: 0s; 
}
.firework:nth-child(2) { 
    top: -10px; 
    left: 70%; 
    width: 10px; 
    height: 10px; 
    animation-delay: 0.3s;
    border-color: rgb(50, 205, 50);
}
.firework:nth-child(3) { 
    top: 0px; 
    left: 35px; 
    width: 14px; 
    height: 14px; 
    animation-delay: 0.6s; 
    border-color: rgb(135, 206, 235);
    border-width: 4px;
}
</style>

<script>
const fireworkBtn = document.getElementById('fireworkBtn');

fireworkBtn.addEventListener('click', () => {
    fireworkBtn.classList.add('on');
    setTimeout(() => {
        fireworkBtn.classList.remove('on');
    }, 3000);
});
</script>