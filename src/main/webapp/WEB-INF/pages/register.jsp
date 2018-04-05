<%@include file="include.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <div>
        <h1>Input register info:</h1>

        <form method="post" action="register">
            <ul>
                <li class="text"> User's name:
                    <input name="name" type="text">
                </li>
                <li class="text"> User's email:
                    <input name="email" type="text">
                </li>
                <li class="text"> User's password:
                    <input name="password" type="password">
                </li>
                <li class="text">
                    <input type="submit">
                </li>
            </ul>
        </form>
    </div>

</body>
</html>