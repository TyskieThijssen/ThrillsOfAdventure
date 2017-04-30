package com.tyskie.toa.DAOs;

import com.tyskie.toa.domain.Character;
import com.tyskie.toa.domain.Stat;

import java.util.List;

/**
 * Created by tyskie on 4/2/17.
 */
public interface CharacterDAO {
    int getExperienceTillNextLevel(int level, int totalExperience);

    List<Character> getCharacters(String username);

    void createCharacter(String username, String characterName);

    void deleteCharacter(String username, String characterName);

    List<Stat> getStats(String characterName);

    Character getCharacter(String username, String characterName);

    void updateStats(String characterName, List<Stat> stats);
}
