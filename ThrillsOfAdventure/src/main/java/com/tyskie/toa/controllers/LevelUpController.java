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
 * Created by tyskie on 4/18/17.
 */
@WebServlet("/levelUp")
public class LevelUpController extends HttpServlet {

    private CharacterModel characterModel = new CharacterModel();
    private HttpSession session;
    private String username;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        username = (String) session.getAttribute("username");
        String characterName = request.getParameter("characterName");
        Character character = characterModel.getCharacter(username, characterName);
        List<Stat> stats = character.getStats();

        for (Stat stat : stats) {
            stat.levelUp(1);
        }

        characterModel.updateStats(characterName, stats);

        List<Stat> newStats = character.getStats();

        request.setAttribute("character", character);
        request.setAttribute("stats", newStats);
        request.getRequestDispatcher("views/CharacterStatsView.jsp").forward(request, response);
    }
}
