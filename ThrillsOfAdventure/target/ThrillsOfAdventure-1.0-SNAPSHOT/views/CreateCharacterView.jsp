<%--
  Created by IntelliJ IDEA.
  User: tyskie
  Date: 4/2/17
  Time: 5:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thrills Of Adventure</title>
</head>
<body>
    <h1>Hi there, ${username}. Create a character!</h1>
    <form action="createCharacter" method="POST">
        <table>
            <thead>
                <th></th>
                <th></th>
            </thead>
            <tbody>
                <tr>
                    <td>Character Name: </td>
                    <td><input type="text" name="characterName"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Create Character" name="createCharacter"></td>
                </tr>
            </tbody>
        </table>
    </form>
</body>
</html>
