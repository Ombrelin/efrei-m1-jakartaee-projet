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
</head>
<body>
    <form method="post">

        <label for="team1score">Team 1 score :
            <j:forEach items="${team1}" var="player">
                <tr>
                    <td>${player.Name}</td>
                </tr>
            </j:forEach>
        </label>
        <input required step="1" type="number" id="team1score" name="team1score"/>

        <label for="team2score">Team 2 score :
            <j:forEach items="${team2}" var="player">
                <tr>
                    <td>${player.Name}</td>
                </tr>
            </j:forEach></label>
        <input required step="1" type="number" id="team2score" name="team2score"/>

        <label for="duration">Duration : </label>
        <input required type="time" id="duration" name="duration" step="1"/>

        <input hidden type="text" id="matchId" name="matchId" value="<j:out value="${ matchId }"></j:out>">

        <j:out value="${ result }"></j:out>
        <br/>
        <button type="submit">Resolve</button>
    </form>
</body>
</html>
