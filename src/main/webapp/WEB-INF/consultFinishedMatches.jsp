<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Consult finished matches</title>
    <jsp:include page="/style.jsp"/>

</head>

<body>
<jsp:include page="/navbar.jsp"/>
<div class="container h-100 d-flex justify-content-center">
    <div class="mt-5">
        <h2 class="mt-3 mb-3">Finished Matches</h2>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Team 1 Players</th>
                <th scope="col">Team 2 Players</th>
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
                    <td>
                        <j:forEach items="${match.participants}" var="participant">
                            <j:if test="${participant.teamNumber == 1}">
                                <j:out value="${participant.player.name}"></j:out>
                                (<j:out value="${participant.player.nationality}"></j:out>)
                            </j:if>
                        </j:forEach>
                    </td>
                    <td>
                        <j:forEach items="${match.participants}" var="participant">
                            <j:if test="${participant.teamNumber == 2}">
                                <j:out value="${participant.player.name}"></j:out>
                                (<j:out value="${participant.player.nationality}"></j:out>)
                            </j:if>
                        </j:forEach>
                    </td>
                    <td>${match.team1Score}</td>
                    <td>${match.team2Score}</td>
                    <td>
                        <j:out value="${match.dateTime.dayOfMonth}"></j:out>
                        <span class="text-capitalize"> <j:out value="${fn:toLowerCase(match.dateTime.month)}"></j:out></span>
                        <j:out value="${match.dateTime.year}"></j:out>
                    </td>
                    <td>${match.court.number}</td>
                </tr>
            </j:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
