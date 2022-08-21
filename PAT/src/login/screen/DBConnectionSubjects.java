/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.screen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.sql.*;

/**
 *
 * @author xpeng
 */
//to add in assignments
public class DBConnectionSubjects {
    private Connection conn;
    public DBConnectionSubjects() {
        String databaseURL = "jdbc:ucanaccess://Learners' Subjects.accdb";
        try {
            conn = DriverManager.getConnection(databaseURL);
        } catch (SQLException ex) {
            System.out.println("Cannot connect to database" + ex);
        }
    }
    public boolean addSubject(String description, int grade, String set,String Name, String Surname,LocalDate d){
        boolean access= true;
        try{
            Statement stmt = conn.createStatement();
            stmt.executeQuery("INSERT INTO Subjects VALUES('"+Name+"', '"+Surname+"','"+grade+"','"+set+"','"+d+"','"+description+"')");
        }catch(SQLException ex){
            System.out.println("COULD NOT ADD");
            access=false;
        }
        return access;  
    }
    public ResultSet getResults(String query){
        ResultSet rs = null;
        try{
            Statement stmt = conn.createStatement();
            rs=stmt.executeQuery(query);
        }catch(SQLException ex){
            System.out.println("Could not execute query: "+ex);
            ex.printStackTrace();
        }
        return rs;
    }
    
    
}
