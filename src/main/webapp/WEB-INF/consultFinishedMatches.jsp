<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<j:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Consult finished matches</title>
    <link href="${contextPath}/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
    <table class="table">
        <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Team 1 Score</th>
                <th scope="col">Team 2 Score</th>
                <th scope="col">Date</th>
                <th scope="col">Court</th>
            </tr>
        </thead>
        <j:forEach items="${result}" var="match">
            <tr>
                <td>${match.id}</td>
                <td>${match.team1Score}</td>
                <td>${match.team2Score}</td>
                <td>${match.dateTime}</td>
                <td>${match.court}</td>
            </tr>
        </j:forEach>
    </table>


</body>
</html>
