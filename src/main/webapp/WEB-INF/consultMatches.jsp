<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<html>
<head>
    <title>Consult all matches</title>
    <jsp:include page="/style.jsp"/>

</head>
<style>
    .table > tbody > tr > td {
        vertical-align: middle;
    }
</style>
<body>
<jsp:include page="/navbar.jsp"/>
<div class="container h-100 d-flex justify-content-center align-items-center">
    <div class="mt-5">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Team 1 Score</th>
                <th scope="col">Team 2 Score</th>
                <th scope="col">Date</th>
                <th scope="col">Court</th>
                <th scope="col">Status</th>
                <th scope="col">Action</th>
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
                    <j:choose>
                        <j:when test="${match.finished}">
                            <td>finished</td>
                        </j:when>
                        <j:when test="${not match.finished}">
                            <td>not finished</td>
                        </j:when>
                    </j:choose>
                    <td>
                        <j:if test="${not match.finished}">
                            <a class="btn btn-primary m-1"
                               href="<j:url value='/admin/prepareMatch?matchId=${match.id}'></j:url>">Prepare</a>
                            <a class="btn btn-primary m-1"
                               href="<j:url value='/admin/resolveMatch?matchId=${match.id}'></j:url>">Resolve</a>
                        </j:if>
                    </td>
                </tr>
            </j:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
