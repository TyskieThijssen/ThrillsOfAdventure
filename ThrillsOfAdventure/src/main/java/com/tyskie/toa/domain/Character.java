package com.tyskie.toa.domain;

import java.util.List;

/**
 * Created by tyskie on 4/2/17.
 */
public class Character {
    private String characterName;
    private int characterLevel;
    private int totalExperience;
    private int experienceTillNextLevel;
    private List<Stat> stats;

    CharacterModel characterModel = new CharacterModel();

    public Character(String characterName, int characterLevel, int totalExperience){
        this.characterName = characterName;
        this.characterLevel = characterLevel;
        this.totalExperience = totalExperience;
        experienceTillNextLevel = getExperienceTillNextLevel(characterLevel, totalExperience);
        stats = getStats(characterName);
    }

    private List<Stat> getStats(String characterName) {
        return characterModel.getStats(characterName);
    }

    private int getExperienceTillNextLevel(int level, int totalExperience) {
        return characterModel.getExperienceTillNextLevel(level, totalExperience);
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getCharacterLevel() {
        return characterLevel;
    }

    public void setCharacterLevel(int characterLevel) {
        this.characterLevel = characterLevel;
    }

    public int getTotalExperience() {
        return totalExperience;
    }

    public void setTotalExperience(int totalExperience) {
        this.totalExperience = totalExperience;
    }

    public int getExperienceTillNextLevel() {
        return experienceTillNextLevel;
    }

    public void setExperienceTillNextLevel(int experienceTillNextLevel) {
        this.experienceTillNextLevel = experienceTillNextLevel;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }
}
