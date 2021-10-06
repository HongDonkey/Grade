package com.kopo.grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.sqlite.SQLiteConfig;

public class DB {

    private Connection conn = null;
    private void open() {
        try {
            Class.forName("org.sqlite.JDBC");
            SQLiteConfig config = new SQLiteConfig();
            this.conn = DriverManager.getConnection("jdbc:sqlite:/c:/tomcat/grade.db", config.toProperties());
        } catch (Exception e){
            e.printStackTrace();
            //오류가 났을 때 해당 부분을 알려줌
        }
    }

    private void close() {
        if(this.conn != null) {
            try{
                this.conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public String excuteQuery(String query) {
        this.open();
        String message = "success";
        try { 
            Statement statement = this.conn.createStatement();
            int r = statement.executeUpdate(query);
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
            message = "fail";

        }
        
	this.close();
    return message;
	}

    public String insertQuery(Item item) {
        this.open();
        String message = "success";
        String query = "INSERT INTO grade (name, score, created, updated) VALUES(?, ?, ?, ?)";
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String nowString = sdf.format(now);

        try { 
            PreparedStatement statement = this.conn.prepareStatement(query);
            statement.setString(1, item.name);
            statement.setInt(2, item.score);
            statement.setString(3, nowString);
            statement.setString(4, nowString);
            int r = statement.executeUpdate();
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
            message = "fail";

        }
        
	this.close();
    return message;
	}

    public ArrayList<Item> selectQuery() {
        this.open();

        ArrayList<Item> results = new ArrayList<Item>();
        String query = "SELECT * FROM grade";
    

        try { 
            PreparedStatement statement = this.conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                int idx = resultSet.getInt("idx");
                String name = resultSet.getString("name");
                int score = resultSet.getInt("score");
                String created = resultSet.getString("created");
                String updated = resultSet.getString("updated");
                results.add(new Item(idx, name, score, created, updated));
            }
            statement.close();

        } catch (Exception e){
            e.printStackTrace();

        }
        
	this.close();
    return results;
	}
    }

