<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tyskie
  Date: 4/2/17
  Time: 9:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thrills Of Adventure</title>
</head>
<body>
    <h1>Character stats of: ${character.getCharacterName()}</h1>
    <hr>
    <form action="levelUp" method="post">
        <table>
            <tbody>
                <tr>
                    <td>Character Level: </td>
                    <td>${character.getCharacterLevel()}</td>
                </tr>
                <tr>
                    <td>Total Experience: </td>
                    <td>${character.getTotalExperience()}</td>
                </tr>
                <tr>
                    <td>Exp till next level: </td>
                    <td>${character.getExperienceTillNextLevel()}</td>
                </tr>
                <c:forEach items="${stats}" var="current">
                    <tr>
                        <td><c:out value="${current.getStatName()}"/> level</td>
                        <td><c:out value="${current.getLevel()}"/></td>
                    </tr>
                </c:forEach>
                <tr>
                    <input type="hidden" value="${character.getCharacterName()}" name="characterName">
                    <td><input type="submit" value="Level up" name="levelUp"></td>
                </tr>
            </tbody>
        </table>
    </form>
</body>
</html>
