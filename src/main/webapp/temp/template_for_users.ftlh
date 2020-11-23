<#ftl encoding="UTF-8"/>
<html lang="en">
<body>

<table>
    <tr>
        <th>Login</th>
    </tr>
    <#list users as listUser>
        <tr>
            <td>${listUser.login}</td>
        </tr>
    </#list>
</table>


</body>
</html>
