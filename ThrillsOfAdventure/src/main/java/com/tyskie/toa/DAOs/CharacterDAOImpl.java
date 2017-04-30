package com.tyskie.toa.DAOs;

import com.tyskie.toa.database.DatabaseConnection;
import com.tyskie.toa.domain.Character;
import com.tyskie.toa.domain.Stat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tyskie on 4/2/17.
 */
public class CharacterDAOImpl implements CharacterDAO {
    DatabaseConnection connection = new DatabaseConnection();
    Connection conn = connection.getConnection();

    PreparedStatement preparedStatement;
    String query;

    @Override
    public int getExperienceTillNextLevel(int level, int totalExperience) {
        int experienceTillNextLevel = 0;
        try{
            query = "SELECT experience FROM Levels WHERE level = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, level + 1);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int requiredExperience = rs.getInt("experience");
                experienceTillNextLevel = requiredExperience - totalExperience;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return experienceTillNextLevel;
    }

    @Override
    public List<Character> getCharacters(String username) {
        List<Character> characters = new ArrayList<Character>();
        try{
            query = "SELECT *\n" +
                    "FROM Characters\n" +
                    "WHERE characterName IN (SELECT characterName\n" +
                    "FROM CharacterOfAccount\n" +
                    "WHERE username = ?)\n" +
                    "ORDER BY characterLevel DESC";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String characterName = rs.getString("characterName");
                int characterLevel = rs.getInt("characterLevel");
                int totalExperience = rs.getInt("totalExperience");
                characters.add(new Character(characterName, characterLevel, totalExperience));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return characters;
    }

    @Override
    public void createCharacter(String username, String characterName) {
        try{
            query = "CALL CreateCharacter(?,?)";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, characterName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCharacter(String username, String characterName) {
        try{
            query = "CALL DeleteCharacter(?,?)";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, characterName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Stat> getStats(String characterName) {
        List<Stat> stats = new ArrayList<Stat>();
        try{
            query = "SELECT * FROM CharacterStatistic WHERE characterName = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, characterName);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String statName = rs.getString("statName");
                int level = rs.getInt("statLevel");
                stats.add(new Stat(statName, level));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stats;
    }

    @Override
    public Character getCharacter(String username, String characterName) {
        Character character = null;
        try{
            query = "SELECT *\n" +
                    "FROM Characters\n" +
                    "WHERE characterName IN (SELECT characterName\n" +
                    "FROM CharacterOfAccount\n" +
                    "WHERE username = ?)\n" +
                    "AND characterName = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, characterName);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int characterLevel = rs.getInt("characterLevel");
                int totalExperience = rs.getInt("totalExperience");
                character = new Character(characterName, characterLevel, totalExperience);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return character;
    }

    @Override
    public void updateStats(String characterName, List<Stat> stats) {
        for (Stat stat : stats) {
            try{
                query = "UPDATE CharacterStatistic SET statLevel = ? WHERE CharacterName = ? AND statName = ?";
                preparedStatement = conn.prepareStatement(query);
                int statLevel = stat.getLevel();
                preparedStatement.setInt(1, statLevel);
                preparedStatement.setString(2, characterName);
                String statName = stat.getStatName();
                preparedStatement.setString(3, statName);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
