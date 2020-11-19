<%--
  Created by IntelliJ IDEA.
  User: maudg
  Date: 19/11/2020
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resolve Match</title>
    <jsp:include page="/style.jsp"/>
</head>
<body>
<jsp:include page="/navbar.jsp"/>
<div class="container h-100 d-flex justify-content-center align-items-center">

    <div class="col-md-5">
        <form method="post">

            <div class="form-group">
                <label for="team1score">Team 1 score :
                    <j:forEach items="${team1}" var="player">
                        <tr>
                            <td>${player.Name}</td>
                        </tr>
                    </j:forEach>
                </label>
                <input class="form-control" required step="1" type="number" id="team1score" name="team1score"/>
            </div>
            <div class="form-group">
                <label for="team2score">Team 2 score :
                    <j:forEach items="${team2}" var="player">
                        <tr>
                            <td>${player.Name}</td>
                        </tr>
                    </j:forEach></label>
                <input class="form-control" required step="1" type="number" id="team2score" name="team2score"/>
            </div>

            <j:if test="${not empty result}">
                <div class="p-3 mb-2 bg-danger text-white mt-3">
                    <j:out value="${ result }"></j:out>
                </div>
            </j:if>

            <div class="form-group">
                <label for="duration">Duration : </label>
                <input class="form-control" required type="time" id="duration" name="duration" step="1"/>
            </div>

            <input hidden type="text" id="matchId" name="matchId" value="<j:out value="${ matchId }"></j:out>">

            <j:out value="${ result }"></j:out>
            <br/>
            <button type="submit" class="btn btn-primary">Resolve</button>
        </form>
    </div>
</div>

</body>
</html>
