<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <title>jsp</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
</head>
<body>
<table border="1" align="center">
    <tr>
        <th>名字</th>
        <th>年龄</th>
    </tr>
    <#list users as item>
        <tr>
            <td>${item.username}</td>
            <td>${item.age}</td>
        </tr>
    </#list>
</table>
</body>
</html>

