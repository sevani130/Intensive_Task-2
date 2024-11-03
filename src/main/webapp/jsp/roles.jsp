<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Roles</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<h1>Roles</h1>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Role Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="role" items="${roles}">
        <tr>
            <td>${role.id}</td>
            <td>${role.roleName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
