<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<j:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Rolang Garros Planning</title>
    <jsp:include page="/style.jsp"/>
    <link href="${contextPath}/css/index.css" rel="stylesheet">
</head>
<body>
<div class="grass">
    <div class="court-container">
        <div class="court-outline">
            <div class="court-aspect">
                <div class="court-boundaries">
                    <div class="singles-lines"></div>
                    <div class="service-lines"></div>
                    <div class="center-line"></div>
                    <div class="center-line end left"></div>
                    <div class="center-line end right"></div>
                    <div class="net">
                        <div class="post top"></div>
                        <div class="post bottom"></div>
                    </div>
                    <div class="net-shadow"></div>
                    <div class="ball"></div>

                    <div class="player left"></div>
                    <div class="player right"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="filter-bg">

</div>
<h1 class="title m-4 text-dark">Rolland Garros Planning</h1>
<a href="<j:url value='/consultFinishedMatches'></j:url>" class="btn-lg btn btn-outline-light enter text-center">Enter</a>
<a href="<j:url value='/login'></j:url>" class="m-4 btn-lg btn btn-outline-dark log-in text-center">Log in</a>
</body>
</html>
