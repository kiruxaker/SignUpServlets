<%@include file="include.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>

    <link rel="stylesheet" href="../css/all-users.css">
</head>
<body>
 <c:set var="transfered" value="${user}"/>
    <div>
        <ul>
            <li class="text"><div>
                userName : <c:out value="${transfered.name}"/>
            </div></li>

            <li class="text"><div>
                userEmail : <c:out value="${transfered.email}"/>
            </div></li>

            <li class="text"><div>
                userId : <c:out value="${transfered.id}"/>
            </div></li>
        </ul>
    </div>
</body>
</html>
