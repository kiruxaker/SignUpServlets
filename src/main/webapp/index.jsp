<%@include file="WEB-INF/pages/include.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Main</title>

    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/vue"></script>
<div id="app">

        <div id="left"><h3 class="text" v-on:click="changeLoginLink()">Login</h3></div>
        <div id="center"><h3 class="text" v-on:click="changeRegisterLink()">Register</h3></div>
        <div id="right"><h3 class="text" v-on:click="changeAllUsersLink()">All-Users</h3></div>

    <div id="doublepage" v-show="show">
        <iframe v-bind:src="link" frameborder="0" width="320px">{{show}}</iframe>
        <div v-if="/login">
            <login></login>
        </div>
    </div>
</div>
<script type="text/javascript" src="vue.js"></script>
<%--<script>--%>
    <%--new Vue({--%>
        <%--el: "#app",--%>
        <%--data: {--%>
            <%--link: "",--%>
            <%--show: false--%>
        <%--},--%>
        <%--methods: {--%>
            <%--changeLoginLink:function() {--%>
                <%--this.show = true;--%>
                <%--this.link = "/login"--%>
            <%--},--%>
            <%--changeRegisterLink:function () {--%>
                <%--this.show = true;--%>
                <%--this.link = "/register"--%>
            <%--},--%>
            <%--changeAllUsersLink:function () {--%>
                <%--this.show = true;--%>
                <%--this.link = "/all-users"--%>
            <%--}--%>
        <%--}--%>
    <%--});--%>
<%--</script>--%>
</body>
</html>
