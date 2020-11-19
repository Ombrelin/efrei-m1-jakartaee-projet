<%--
  Created by IntelliJ IDEA.
  User: arsen
  Date: 19/11/2020
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<html>
<head>
    <title>Prepare Match</title>
    <jsp:include page="/style.jsp" />

</head>
<body>

<j:out value="${match.dateTime}"/>
<j:out value="${match.court}"/>

<form method="post">

    <input name="matchId" hidden value="<j:out value='${match.id}'></j:out>"/>

    <div class="form-group">
        <label for="referee">Referee :</label>
        <select required class="form-control" id="referee" name="referee">
            <j:forEach items="${ referees }" var="referee">
                <option value="<j:out value='${referee.id}'></j:out>"><j:out value='${referee.name}'></j:out></option>
            </j:forEach>
        </select>
    </div>

    <div class="form-group">
        <label for="type">Match type : </label>
        <select class="form-control" id="type">
            <option selected value="simple">Simple</option>
            <option value="simple">Double</option>
        </select>
    </div>

    <h3>Team 1 Players</h3>

    <div class="form-group">
        <label for="type">Player 1 : </label>
        <select class="form-control" id="team1player1" name="team1player1">
            <j:forEach items="${ players }" var="player">
                <option value="<j:out value='${player.id}'></j:out>"><j:out value='${player.name}'></j:out></option>
            </j:forEach>
        </select>
    </div>

    <div id="team2player1form" class="form-group d-none">
        <label for="type">Player 2 : </label>
        <select class="form-control" id="team1player2" name="team1player2">
            <j:forEach items="${ players }" var="player">
                <option value="<j:out value='${player.id}'></j:out>"><j:out value='${player.name}'></j:out></option>
            </j:forEach>
        </select>
    </div>

    <h3>Team 2 Players</h3>

    <div id="team2player2form" class="form-group">
        <label for="type">Player 1 : </label>
        <select class="form-control" id="team2player1" name="team2player1">
            <j:forEach items="${ players }" var="player">
                <option value="<j:out value='${player.id}'></j:out>"><j:out value='${player.name}'></j:out></option>
            </j:forEach>
        </select>
    </div>

    <div class="form-group d-none">
        <label for="type">Player 2 : </label>
            <select class="form-control" id="team2player2" name="team2player2">
            <j:forEach items="${ players }" var="player">
                <option value="<j:out value='${player.id}'></j:out>"><j:out value='${player.name}'></j:out></option>
            </j:forEach>
        </select>
    </div>


    <button type="submit">Prepare</button>

</form>

<script type="application/javascript">
    window.onload = () => {
        console.log("init");

        const type = document.querySelector("#type");
        const team2player1form = document.querySelector("#team2");
        const team2player2form = document.querySelector("#team2");
        const team2player1 = document.querySelector("#team2player1");
        const team2player2 = document.querySelector("#team2player2");

        type.addEventListener("change", () => {
            if(type.value === "simple"){
                team2player1form.className = "d-none";
                team2player1form.className = "d-none";
                team2player1.required = false;
                team2player2.required = false;
            }
            else if(type.value === "double"){
                team2player2form.className = "form-group";
                team2player2form.className = "form-group";
                team2player1.required = true;
                team2player2.required = true;
            }
        });
    }
</script>

</body>
</html>
