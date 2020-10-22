<%--
  Created by IntelliJ IDEA.
  User: Adel
  Date: 19.10.2020
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<H1>Login page</H1>

<form method="post" action="${pageContext.request.contextPath}/login">
    <label>Login
        <input name="login">
    </label>
    <br>
    <label>Password
        <input name="password" type="password">
    </label>
    <br>
    <button type="submit">Login</button>
</form>

</body>
</html>
