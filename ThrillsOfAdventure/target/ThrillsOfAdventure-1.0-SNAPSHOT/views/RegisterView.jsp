<%--
  Created by IntelliJ IDEA.
  User: tyskie
  Date: 4/2/17
  Time: 11:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thrills Of Adventure</title>
</head>
<body>
    <h1>Register your account!</h1>
    <hr>
    <form action="register" method="POST">
        <table>
            <thead>
                <th></th>
                <th></th>
            </thead>
            <tbody>
                <tr>
                    <td>Username: </td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td>Repeat Password: </td>
                    <td><input type="password" name="confirmPassword"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Register" name="register"></td>
                </tr>
            </tbody>
        </table>
        ${error}
    </form>
</body>
</html>
