package com.tyskie.toa.services;

import com.tyskie.toa.DAOs.CharacterDAOImpl;
import com.tyskie.toa.domain.Character;
import com.tyskie.toa.domain.Stat;

import java.util.List;

/**
 * Created by tyskie on 4/2/17.
 */
public class CharacterService {
    CharacterDAOImpl characterDAO = new CharacterDAOImpl();

    public int getExperienceTillNextLevel(int level, int totalExperience) {
        return characterDAO.getExperienceTillNextLevel(level, totalExperience);
    }

    public List<Character> getCharacters(String username) {
        return characterDAO.getCharacters(username);
    }

    public void createCharacter(String username, String characterName) {
        characterDAO.createCharacter(username, characterName);
    }

    public void deleteCharacter(String username, String characterName) {
        characterDAO.deleteCharacter(username, characterName);
    }

    public List<Stat> getStats(String characterName) {
        return characterDAO.getStats(characterName);
    }

    public Character getCharacter(String username, String characterName) {
        return characterDAO.getCharacter(username, characterName);
    }

    public void updateStats(String characterName, List<Stat> stats) {
        characterDAO.updateStats(characterName, stats);
    }
}
