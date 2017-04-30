<%--
  Created by IntelliJ IDEA.
  User: tyskie
  Date: 4/1/17
  Time: 11:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Thrills Of Adventure</title>
</head>
<body>
    <h1>Welcome to Thrills Of Adventure, ${username}!</h1>
    <p>Please select a character!</p>
    <hr>
    <c:forEach items="${characters}" var="current">
        <form action="selectCharacter" method="POST">
            <table>
                <thead>
                    <th></th>
                    <th></th>
                </thead>
                <tbody>
                    <tr>
                        <td>Character Name: </td>
                        <td><c:out value="${current.getCharacterName()}"/></td>
                    </tr>
                    <tr>
                        <td>Character Level: </td>
                        <td><c:out value="${current.getCharacterLevel()}"/></td>
                    </tr>
                    <tr>
                        <input type="hidden" value="${current.getCharacterName()}" name="characterName">
                        <td><input type="submit" value="Select" name="selectCharacter"></td>
                        <td><input type="submit" formaction="deleteCharacter" value="Delete" name="deleteCharacter"></td>
                    </tr>
                </tbody>
            </table>
            <hr>
        </form>
    </c:forEach>
    <p>No characters yet? <a href="createCharacter">Create a character!</a></p>
    <a href="home">Logout</a>
</body>
</html>
