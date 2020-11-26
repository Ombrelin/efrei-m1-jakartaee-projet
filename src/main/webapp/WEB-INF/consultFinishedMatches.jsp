<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<html>
<head>
    <title>Consult finished matches</title>
    <jsp:include page="/style.jsp"/>

</head>

<body>
<jsp:include page="/navbar.jsp"/>
<div class="container h-100 d-flex justify-content-center align-items-center">
    <div class="mt-5">
        <h2>Finished Matches</h2>
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
            <tbody>
            <j:forEach items="${result}" var="match">
                <tr>
                    <td>${match.id}</td>
                    <td>${match.team1Score}</td>
                    <td>${match.team2Score}</td>
                    <td>${match.dateTime}</td>
                    <td>${match.court}</td>
                </tr>
            </j:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
