package com.tyskie.toa.domain;

/**
 * Created by tyskie on 4/2/17.
 */
public class Stat {
    private String statName;
    private int level;

    public Stat(String statName, int level){
        this.statName = statName;
        this.level = level;
    }

    public String getStatName() {
        return statName;
    }

    public void setStatName(String statName) {
        this.statName = statName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void levelUp(int levels) {
        this.level += levels;
    }
}
