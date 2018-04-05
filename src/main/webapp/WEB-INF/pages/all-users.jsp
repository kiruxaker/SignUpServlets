<%@ page import="java.util.List" %>
<%@include file="include.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All users</title>
</head>
<h1>Users list</h1>
<body>

<div>
    <% ApplicationContext context = ((ApplicationContext) request.getServletContext().getAttribute("spring-context")); %>
    <% List<User> users = ((UserService) context.getBean("service")).allUsers(); %>

    <ul>
        <% for (User user : users) { %>
        <li><%= user %></li>
        <% } %>
    </ul>

</div>
</body>
</html>
