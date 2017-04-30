package com.tyskie.toa.controllers;

import com.tyskie.toa.domain.AccountModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by tyskie on 4/1/17.
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
    private AccountModel accountModel = new AccountModel();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean isCorrect = accountModel.checkIfAccountExists(username, password);

        if(isCorrect){
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("selectCharacter");
        } else {
            String error = "Username and/or Password is incorrect!";
            request.setAttribute("error", error);
            request.getRequestDispatcher("views/index.jsp").forward(request, response);
        }
    }
}
