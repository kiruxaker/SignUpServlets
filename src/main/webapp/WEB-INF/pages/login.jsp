<%@include file="include.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Main</title>

    <link rel="stylesheet" type="text/css" href="../css/login.css">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/vue"></script>
<c:if test="${!inSystem}">
    <div id="loginApp">
        <form action="login" method="post">
            <ul>
                <li class="text"> Input email:
                    <input name="email" type="text">
                </li>
                <li class="text"> Input password:
                    <input name="password" type="password">
                </li>
                <li class="text">
                    <input type="submit" name="Click" v-on:click="hideFrame()">
                </li>
            </ul>
        </form>
    </div>
</c:if>
<c:if test="${inSystem}">
    <ul>
        <li class="text">Hello <c:out value="${currentUserName}"/></li>
    </ul>
</c:if>
<script type="text/javascript" src="../../vue.js"></script>
</body>
</html>