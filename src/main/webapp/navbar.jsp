<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
<j:set var="currentPage" value="${pageContext.request.requestURI}"/>
<j:set var="contextPath" value="${pageContext.request.contextPath}/WEB-INF/" />

<nav class="navbar navbar-expand-xl navbar-dark bg-dark">
    <a class="navbar-brand" href="#">Roland Garros Planning</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample06"
            aria-controls="navbarsExample06" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExample06">
        <ul class="navbar-nav mr-auto">
            <j:out value="${contextPath}"/>
            <j:if test="${sessionScope.isAdmin}">
                <li class="nav-item ${currentPage eq contextPath+='planMatch.jsp' ? ' active' : ''}">
                    <a class="nav-link" href="<j:url value='/admin/planMatch'></j:url>">Plan Match</a>
                </li>
                <li class="nav-item ${currentPage eq contextPath+='registerPlayer.jsp' ? ' active' : ''}">
                    <a class="nav-link" href="<j:url value='/admin/registerPlayer'></j:url>">Register Player</a>
                </li>
                <li class="nav-item ${currentPage eq contextPath+='registerReferee.jsp' ? ' active' : ''}">
                    <a class="nav-link" href="<j:url value='/admin/registerReferee'></j:url>">Register Referee</a>
                </li>

                <li class="nav-item ${currentPage eq contextPath+='consultMatches.jsp' ? ' active' : ''}">
                    <a class="nav-link" href="<j:url value='/admin/consultMatches'></j:url>">Consult Matches</a>
                </li>

            </j:if>

            <li class="nav-item ${currentPage eq contextPath+='consultFinishedMatches.jsp' ? ' active' : ''}">
                <a class="nav-link" href="<j:url value='/consultFinishedMatches'></j:url>">Consult Finished Matches</a>
            </li>
        </ul>
        <ul class="navbar-nav">
            <li class="nav-item">
                <j:choose>
                    <j:when test="${sessionScope.isAdmin}">
                        <a class="nav-link" href="<j:url value='/logout'></j:url>">Log out</a>
                    </j:when>
                    <j:otherwise>
                        <a class="nav-link" href="<j:url value='/login'></j:url>">Log in</a>
                    </j:otherwise>
                </j:choose>
            </li>
        </ul>
    </div>
</nav>