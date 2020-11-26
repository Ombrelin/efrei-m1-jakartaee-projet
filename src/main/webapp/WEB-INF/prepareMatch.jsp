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
<jsp:include page="/navbar.jsp" />
<div class="container h-100 d-flex justify-content-center align-items-center">

    <div class="col-md-5">
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
                <select onchange="handleChangeType(this.value)" class="form-control" id="type">
                    <option selected value="simple">Simple</option>
                    <option value="double">Double</option>
                </select>
            </div>

            <h3 class="mt-4">Team 1 Players</h3>

            <div class="form-group">
                <label for="type">Player 1 : </label>
                <select class="form-control" id="team1player1" name="team1player1">
                    <j:forEach items="${ players }" var="player">
                        <option value="<j:out value='${player.id}'></j:out>"><j:out value='${player.name}'></j:out></option>
                    </j:forEach>
                </select>
            </div>

            <div id="team1player2form" class="form-group d-none">
                <label for="type">Player 2 : </label>
                <select class="form-control" id="team1player2" name="team1player2">
                    <j:forEach items="${ players }" var="player">
                        <option value="<j:out value='${player.id}'></j:out>"><j:out value='${player.name}'></j:out></option>
                    </j:forEach>
                </select>
            </div>

            <h3 class="mt-4">Team 2 Players</h3>

            <div  class="form-group">
                <label for="type">Player 1 : </label>
                <select class="form-control" id="team2player1" name="team2player1">
                    <j:forEach items="${ players }" var="player">
                        <option value="<j:out value='${player.id}'></j:out>"><j:out value='${player.name}'></j:out></option>
                    </j:forEach>
                </select>
            </div>

            <div class="form-group d-none" id="team2player2form">
                <label for="type">Player 2 : </label>
                    <select class="form-control" id="team2player2" name="team2player2">
                    <j:forEach items="${ players }" var="player">
                        <option value="<j:out value='${player.id}'></j:out>"><j:out value='${player.name}'></j:out></option>
                    </j:forEach>
                </select>
            </div>


            <button class="btn btn-primary" type="submit">Prepare</button>

            <j:if test="${not empty result and not result.successfull}">
                <div class="p-3 mb-2 bg-danger text-white mt-3">
                    <j:out value="${ result.message }"></j:out>
                </div>
            </j:if>

        </form>
    </div>
</div>
<script type="application/javascript">

        const handleChangeType = (value) => {
            const team1player2form = document.querySelector("#team1player2form");
            const team2player2form = document.querySelector("#team2player2form");
            const team2player1 = document.querySelector("#team2player1");
            const team2player2 = document.querySelector("#team2player2");
            if(value === "simple"){
                team1player2form.className = "d-none";
                team2player2form.className = "d-none";
                team2player1.required = false;
                team2player2.required = false;
            }
            else if(value === "double"){
                team1player2form.className = "form-group";
                team2player2form.className = "form-group";
                team2player1.required = true;
                team2player2.required = true;
            }

    }
</script>

</body>
</html>
