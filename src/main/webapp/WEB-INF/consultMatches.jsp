<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>

<head>
    <title>Consult all matches</title>
    <jsp:include page="/style.jsp" />

</head>
<style>
    .table>tbody>tr>td {
        vertical-align: middle;
    }
</style>

<body>
    <jsp:include page="/navbar.jsp" />
    <div class="container h-100 d-flex justify-content-center">
        <div class="mt-5">
            <h2 class="mt-3 mb-3">Matches</h2>
            <table class="table mt-3">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Team 1 Score</th>
                        <th scope="col">Team 2 Score</th>
                        <th scope="col">Date</th>
                        <th scope="col">Court</th>
                        <th scope="col">Prepare</th>
                        <th scope="col">Finish</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>

                    <j:forEach items="${result}" var="match">
                        <tr>
                            <td>${match.id}</td>
                            <td>${match.team1Score}</td>
                            <td>${match.team2Score}</td>
                            <td>
                                <j:out value="${match.dateTime.dayOfMonth}"></j:out>
                                <span class="text-capitalize"> <j:out value="${fn:toLowerCase(match.dateTime.month)}"></j:out></span>
                                <j:out value="${match.dateTime.year}"></j:out>
                            </td>
                            <td>${match.court}</td>
                            <j:choose>
                                <j:when test="${match.prepared}">
                                    <td><i class="fa fa-check" aria-hidden="true"></i></td>
                                </j:when>
                                <j:when test="${not match.prepared}">
                                    <td><i class="fa fa-times" aria-hidden="true"></i></td>
                                </j:when>
                            </j:choose>
                            <j:choose>
                                <j:when test="${match.finished}">
                                    <td><i class="fa fa-check" aria-hidden="true"></i></td>
                                </j:when>
                                <j:when test="${not match.finished}">
                                    <td><i class="fa fa-times" aria-hidden="true"></i></td>
                                </j:when>
                            </j:choose>
                            <td>
                                <j:choose>
                                    <j:when test="${not match.finished && not match.prepared}">
                                        <a class="btn btn-primary m-1"
                                            href="<j:url value='/admin/prepareMatch?matchId=${match.id}'></j:url>">Prepare</a>
                                    </j:when>
                                    <j:when test="${not match.finished}">
                                        <a class="btn btn-primary m-1"
                                            href="<j:url value='/admin/resolveMatch?matchId=${match.id}'></j:url>">Resolve</a>
                                    </j:when>
                                </j:choose>
                            </td>

                        </tr>
                    </j:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>

</html>