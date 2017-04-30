<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thrills Of Adventure</title>
    </head>
    <body>
        <h1>Welcome to Thrills Of Adventure!</h1>
        <p>This is a small adventure game where you can create a character and fight evil!</p>
        <hr>
        <p>${message}Please login to continue.</p>
        <form action="login" method="POST">
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
                        <td><input type="submit" formaction="login" value="Login" name="login"></td>
                    </tr>
                </tbody>
            </table>
            ${error}
        </form>
        <p>Are you a new player? <a href="register">Register here!</a></p>
    </body>
</html>
