package com.tyskie.toa.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatabaseConnection {

    public Connection getConnection(){
        Connection conn = null;
        try {
            String connectionString = "jdbc:mysql://localhost/ThrillsOfAdventure";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connectionString, "root", "root");
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) throws ParseException {
//        DatabaseConnection connection = new DatabaseConnection();
//        if(connection.getConnection() == null){
//            System.out.println("no connection");
//        } else {
//            System.out.println("Connected");
//        }

        DatabaseConnection db = new DatabaseConnection();

        Date date = db.getDateFromString("18:34:35");
        int minutes = 86399;

        String waitForTime = db.addMinutesToDate(date, minutes);
        String currentTime = db.getCurrentTime();

        if(waitForTime.equals(currentTime)){
            System.out.println("You've successfully leveled up your skill!");
        } else {
            String timeLeft = db.getDifferenceBetweenTime(waitForTime, currentTime);

            System.out.println("You are not ready to level up your skill! Time remaining: " + timeLeft);
        }

    }

    public String addMinutesToDate(Date date, int minutes) throws ParseException{
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
        String dt = time.format(date);
        Calendar c = Calendar.getInstance();
        c.setTime(time.parse(dt));
        c.add(Calendar.MINUTE, minutes);
        dt = time.format(c.getTime());
        return dt;
    }

    public String getCurrentTime(){
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
        String dt = time.format(new Date());
        return dt;
    }

    public String getDifferenceBetweenTime(String waitForTime, String currentTime) throws ParseException {
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
        Date waitForTimeDate = time.parse(waitForTime);
        Date currentTimeDate = time.parse(currentTime);

        long diff = waitForTimeDate.getTime() - currentTimeDate.getTime();

        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffDays = diff / (24 * 60 * 60 * 1000);

        String days = "Days";
        if(diffDays == 1){
            days = "Day";
        }

        return diffDays + " " + days + ", " + diffHours + " Hours, " + diffMinutes + " Minutes, " + diffSeconds + " Seconds.";
    }

    public Date getDateFromString(String date) throws ParseException {
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
        return time.parse(date);
    }
}