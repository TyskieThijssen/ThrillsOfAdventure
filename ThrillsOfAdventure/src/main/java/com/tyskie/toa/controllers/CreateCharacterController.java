package com.tyskie.toa.controllers;

import com.tyskie.toa.domain.CharacterModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by tyskie on 4/2/17.
 */
@WebServlet("/createCharacter")
public class CreateCharacterController extends HttpServlet {
    private CharacterModel characterModel = new CharacterModel();
    HttpSession session;
    String username;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        username = (String) session.getAttribute("username");
        request.setAttribute("username", username);
        request.getRequestDispatcher("views/CreateCharacterView.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        username = (String) session.getAttribute("username");
        String characterName = request.getParameter("characterName");
        characterModel.createCharacter(username, characterName);
        response.sendRedirect("selectCharacter");
    }
}
