<#ftl encoding="UTF-8"/>
<html lang="ru">
<head>
    <title>Home</title>
</head>
<body>
<h1>Welcome home, ${login}!</h1>
<h2>You are : ${client}</h2>

<#if cookie_name??>
    <h2>Your cookie : ${cookie_name} - ${cookie_value}</h2>
<#else>
    <h2>You don't have</h2>
</#if>

<a href="/all">Go to all users</a>
</body>
</html>