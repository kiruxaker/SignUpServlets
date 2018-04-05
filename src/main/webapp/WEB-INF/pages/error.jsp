<%@include file="include.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h1><c:out value="${errorTitle}"/></h1>
<p><c:out value="Error: {errorMassege}"/></p>
</body>
</html>
