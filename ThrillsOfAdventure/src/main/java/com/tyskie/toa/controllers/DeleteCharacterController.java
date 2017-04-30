package com.tyskie.toa.controllers;

import com.tyskie.toa.domain.Character;
import com.tyskie.toa.domain.CharacterModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by tyskie on 4/2/17.
 */
@WebServlet("/deleteCharacter")
public class DeleteCharacterController extends HttpServlet {
    private CharacterModel characterModel = new CharacterModel();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String characterName = request.getParameter("characterName");
        characterModel.deleteCharacter(username, characterName);
        List<Character> characters = characterModel.getCharacters(username);
        request.setAttribute("characters", characters);
        response.sendRedirect("selectCharacter");
    }
}
