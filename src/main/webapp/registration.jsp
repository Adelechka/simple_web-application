<%--
  Created by IntelliJ IDEA.
  User: Adel
  Date: 19.10.2020
  Time: 0:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<H1>Registration page</H1>

<form method="post" action="${pageContext.request.contextPath}/registration">
    <label>Login
        <input name="login">
    </label>
    <br>
    <label>Password
        <input name="password" type="password">
    </label>
    <br>
    <button type="submit">Register</button>
</form>
</body>
</html>
