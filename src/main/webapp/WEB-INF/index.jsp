<%--
  Created by IntelliJ IDEA.
  User: JM
  Date: 20/11/2020
  Time: 00:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rolang Garros Planning</title>
    <jsp:include page="/style.jsp"/>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j" %>
</head>
<body>
<div class="grass">
    <div class="court-container">
        <div class="court-outline">
            <div class="court-aspect">
                <div class="court-boundaries">
                    <div class="singles-lines"></div>
                    <div class="service-lines"></div>
                    <div class="center-line"></div>
                    <div class="center-line end left"></div>
                    <div class="center-line end right"></div>
                    <div class="net">
                        <div class="post top"></div>
                        <div class="post bottom"></div>
                    </div>
                    <div class="net-shadow"></div>
                    <div class="ball"></div>

                    <div class="player left"></div>
                    <div class="player right"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<a href="<j:url value='/consultFinishedMatches'></j:url>" class="btn-lg btn btn-outline-dark center text-center">Enter</a>
</body>
<style>
    html, body{
        margin: 0;
        padding: 0;
    }
    html {
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
    }
    body {
    }
    .center {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        font-size: 2rem;
    }
    .grass {
        position: absolute;
        width: 100%;
        height: 100%;
        background: -webkit-gradient(
                linear,
                left top, left bottom,
                from(#c6bf40),
                color-stop(50%, #c6bf40),
                color-stop(50%, #aeb545),
                to(#aeb545)
        );
        background: linear-gradient(
                to bottom,
                #c6bf40,
                #c6bf40 50%,
                #aeb545 50%,
                #aeb545
        );
        background-size: 100% 6vw;
    }



    .court-container {
        position: absolute;
        top: 0px;
        left: 0px;
        right: 0px;
        bottom: 0px;
        display: -webkit-box;
        display: -ms-flexbox;
        display: flex;
        -webkit-box-align: center;
        -ms-flex-align: center;
        align-items: center;
        -webkit-box-pack: center;
        -ms-flex-pack: center;
        justify-content: center;
    }


    .container {
    }



    .court-outline {
        width: 76%;
        padding-top: 36%;
        position: relative;
        /*
        background: url(court-guide.png) no-repeat center center;
        background-size: contain;
        */
    }

    .court-aspect {
        position: absolute;
        top: 0;
        left: 0;
        bottom: 0;
        right: 0;
    }
    .court-boundaries {
        position: absolute;
        top: 0;
        left: 0;
        bottom: 0;
        right: 0;
        border: 0.7vw solid #edebc3;
    }

    .singles-lines {
        position: absolute;
        top: 10%;
        left: 0;
        bottom: 10%;
        right: 0;
        border-top: 0.7vw solid #edebc3;
        border-bottom: 0.7vw solid #edebc3;
    }
    .service-lines {
        position: absolute;
        top: 0%;
        left: 26%;
        bottom: 0%;
        right: 26%;
        border-left: 0.7vw solid #edebc3;
        border-right: 0.7vw solid #edebc3;
    }
    .center-line {
        position: absolute;
        height: 0.7vw;
        background: #edebc3;
        width: 48%;
        left: 50%;
        top: 50%;
        -webkit-transform: translate(-50%,-50%);
        transform: translate(-50%,-50%);
    }
    .center-line.end {
        background: #edebc3;
        width: 2%;
    }
    .center-line.end.left {
        left: 0%;
        top: 50%;
        -webkit-transform: translate(0%,-50%);
        transform: translate(0%,-50%);
    }
    .center-line.end.right {
        left: 100%;
        top: 50%;
        -webkit-transform: translate(-100%,-50%);
        transform: translate(-100%,-50%);
    }

    .net {
        position: absolute;
        background: #fff;
        width: 1.3vw;
        height: 100%;
        left: 50%;
        -webkit-transform: translate(-50%,0%);
        transform: translate(-50%,0%);
    }
    .net-shadow {
        position: absolute;
        background: rgba(0,0,0,0.15);
        width: 1.6vw;
        height: 100%;
        left: 48%;
        -webkit-transform: translate(-48%,0%);
        transform: translate(-48%,0%);
        opacity: 0.9;
    }
    .post {
        background: #684117;
        position: absolute;
        width: 2vw;
        border-radius: 500px;
        height: 1.2vw;
        left: -25%;
    }
    .post.top {
        top: -2.5%;
    }
    .post.bottom {
        bottom: -2.5%;
    }

    .player {
        background: #d3882d;
        width: 1.1vw;
        height: 12%;
        position: absolute;
        -webkit-animation-duration: 4s;
        animation-duration: 4s;
        -webkit-animation-iteration-count: infinite;
        animation-iteration-count: infinite;
    }

    .ball {
        position: absolute;
        width: 1.5vw;
        height: 1.5vw;
        background: #fff;
        border-radius: 100%;
        left: 12.5%;
        top: 20%;
        -webkit-animation-name: ball;
        animation-name: ball;
        -webkit-animation-duration: 4s;
        animation-duration: 4s;
        -webkit-animation-iteration-count: infinite;
        animation-iteration-count: infinite;
        -webkit-box-shadow: -0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
        box-shadow: -0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);

        background: #98ef3c;

    }

    .player.left {
        left: 11%;
        -webkit-box-shadow: -0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
        box-shadow: -0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
        top: 16%;
        -webkit-animation-name: player-1;
        animation-name: player-1;

    }

    .player.right {
        left: 89%;
        -webkit-box-shadow: 0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
        box-shadow: 0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
        bottom: 16%;
        -webkit-animation-name: player-2;
        animation-name: player-2;
        -webkit-animation-delay: 1s;
        animation-delay: 1s;

    }

    @-webkit-keyframes player-1 {
        0% {
            top: 16%;
            -webkit-box-shadow: -0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: -0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);

        }

        25% {
            top: 44%;
            -webkit-box-shadow: -0.5vw 0vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: -0.5vw 0vw 0px 0px rgba(0,0,0,0.15);


        }

        50% {
            top: 73%;
            -webkit-box-shadow: -0.5vw -0.5vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: -0.5vw -0.5vw 0px 0px rgba(0,0,0,0.15);


        }

        75% {
            top: 44%;
            -webkit-box-shadow: -0.5vw 0vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: -0.5vw 0vw 0px 0px rgba(0,0,0,0.15);

        }

        100% {
            top: 16%;
            -webkit-box-shadow: -0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: -0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);

        }

    }

    @keyframes player-1 {
        0% {
            top: 16%;
            -webkit-box-shadow: -0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: -0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);

        }

        25% {
            top: 44%;
            -webkit-box-shadow: -0.5vw 0vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: -0.5vw 0vw 0px 0px rgba(0,0,0,0.15);


        }

        50% {
            top: 73%;
            -webkit-box-shadow: -0.5vw -0.5vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: -0.5vw -0.5vw 0px 0px rgba(0,0,0,0.15);


        }

        75% {
            top: 44%;
            -webkit-box-shadow: -0.5vw 0vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: -0.5vw 0vw 0px 0px rgba(0,0,0,0.15);

        }

        100% {
            top: 16%;
            -webkit-box-shadow: -0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: -0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);

        }

    }

    @-webkit-keyframes player-2 {

        0% {
            bottom: 16%;
            -webkit-box-shadow: 0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: 0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);

        }

        25% {
            bottom: 44%;
            -webkit-box-shadow: 0.5vw 0vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: 0.5vw 0vw 0px 0px rgba(0,0,0,0.15);


        }

        50% {
            bottom: 73%;
            -webkit-box-shadow: 0.5vw -0.5vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: 0.5vw -0.5vw 0px 0px rgba(0,0,0,0.15);


        }

        75% {
            bottom: 44%;
            -webkit-box-shadow: 0.5vw 0vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: 0.5vw 0vw 0px 0px rgba(0,0,0,0.15);

        }

        100% {
            bottom: 16%;
            -webkit-box-shadow: 0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: 0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
        }

    }

    @keyframes player-2 {

        0% {
            bottom: 16%;
            -webkit-box-shadow: 0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: 0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);

        }

        25% {
            bottom: 44%;
            -webkit-box-shadow: 0.5vw 0vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: 0.5vw 0vw 0px 0px rgba(0,0,0,0.15);


        }

        50% {
            bottom: 73%;
            -webkit-box-shadow: 0.5vw -0.5vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: 0.5vw -0.5vw 0px 0px rgba(0,0,0,0.15);


        }

        75% {
            bottom: 44%;
            -webkit-box-shadow: 0.5vw 0vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: 0.5vw 0vw 0px 0px rgba(0,0,0,0.15);

        }

        100% {
            bottom: 16%;
            -webkit-box-shadow: 0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: 0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
        }

    }

    @-webkit-keyframes ball {
        0% {
            left: 12.5%;
            top: 20%;
            -webkit-box-shadow: -0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: -0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);

        }
        25% {
            left: 87.0%;
            top: 76%;
            -webkit-box-shadow: 0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: 0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);

        }

        50% {
            left: 12.5%;
            top: 76%;
            -webkit-box-shadow: -0.5vw -0.5vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: -0.5vw -0.5vw 0px 0px rgba(0,0,0,0.15);

        }

        75% {
            left: 87.0%;
            top: 20%;
            -webkit-box-shadow: 0.5vw -0.5vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: 0.5vw -0.5vw 0px 0px rgba(0,0,0,0.15);

        }
        100% {
            left: 12.5%;
            top: 20%;
            -webkit-box-shadow: -0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: -0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);

        }

    }

    @keyframes ball {
        0% {
            left: 12.5%;
            top: 20%;
            -webkit-box-shadow: -0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: -0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
            transform: rotate(0deg);

        }
        25% {
            left: 87.0%;
            top: 76%;
            -webkit-box-shadow: 0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: 0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
            transform: rotate(180deg);

        }

        50% {
            left: 12.5%;
            top: 76%;
            -webkit-box-shadow: -0.5vw -0.5vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: -0.5vw -0.5vw 0px 0px rgba(0,0,0,0.15);
            transform: rotate(0deg);

        }

        75% {
            left: 87.0%;
            top: 20%;
            -webkit-box-shadow: 0.5vw -0.5vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: 0.5vw -0.5vw 0px 0px rgba(0,0,0,0.15);
            transform: rotate(180deg);


        }
        100% {
            left: 12.5%;
            top: 20%;
            -webkit-box-shadow: -0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
            box-shadow: -0.5vw 0.5vw 0px 0px rgba(0,0,0,0.15);
            transform: rotate(0deg);

        }

    }
</style>
</html>
