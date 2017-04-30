package com.tyskie.toa.controllers;

import com.tyskie.toa.domain.AccountModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tyskie on 4/2/17.
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
    private AccountModel accountModel = new AccountModel();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/RegisterView.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        if(password.equals(confirmPassword)){
            accountModel.registerAccount(username, password);
            String message = "Succesfully registered your account! ";
            request.setAttribute("message", message);
            request.getRequestDispatcher("views/index.jsp").forward(request, response);
        } else {
            String error = "Passwords are not the same!";
            request.setAttribute("error", error);
            request.getRequestDispatcher("views/RegisterView.jsp").forward(request, response);
        }
    }
}
