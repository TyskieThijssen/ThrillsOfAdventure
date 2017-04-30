package com.tyskie.toa.controllers;

import com.tyskie.toa.domain.Character;
import com.tyskie.toa.domain.CharacterModel;
import com.tyskie.toa.domain.Stat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by tyskie on 4/1/17.
 */
@WebServlet("/selectCharacter")
public class SelectCharacterController extends HttpServlet {
    private CharacterModel characterModel = new CharacterModel();
    private HttpSession session;
    private String username;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        username = (String) session.getAttribute("username");
        request.setAttribute("username", username);
        List<Character> characters = characterModel.getCharacters(username);
        request.setAttribute("characters", characters);
        request.getRequestDispatcher("views/SelectCharacterView.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        username = (String) session.getAttribute("username");
        String characterName = request.getParameter("characterName");
        Character character = characterModel.getCharacter(username, characterName);
        List<Stat> stats = character.getStats();
        request.setAttribute("character", character);
        request.setAttribute("stats", stats);
        request.getRequestDispatcher("views/CharacterStatsView.jsp").forward(request, response);
    }
}
