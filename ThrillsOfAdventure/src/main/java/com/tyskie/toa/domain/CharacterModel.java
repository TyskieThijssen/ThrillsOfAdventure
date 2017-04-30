package com.tyskie.toa.domain;

import com.tyskie.toa.services.CharacterService;

import java.util.List;

/**
 * Created by tyskie on 4/2/17.
 */
public class CharacterModel {
    CharacterService characterService = new CharacterService();

    public int getExperienceTillNextLevel(int level, int totalExperience) {
        return characterService.getExperienceTillNextLevel(level, totalExperience);
    }

    public List<Character> getCharacters(String username) {
        return characterService.getCharacters(username);
    }

    public void createCharacter(String username, String characterName) {
        characterService.createCharacter(username, characterName);
    }

    public void deleteCharacter(String username, String characterName) {
        characterService.deleteCharacter(username, characterName);
    }

    public List<Stat> getStats(String characterName) {
        return characterService.getStats(characterName);
    }

    public Character getCharacter(String username, String characterName) {
        return characterService.getCharacter(username, characterName);
    }

    public void updateStats(String characterName, List<Stat> stats) {
        characterService.updateStats(characterName, stats);
    }
}
