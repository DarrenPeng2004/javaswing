/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.screen;
import java.sql.*;
import java.time.LocalDate;
/**
 *
 * @author xpeng
 */
public class DBConnection {
    private Connection conn;

    public DBConnection() {
        String databaseURL = "jdbc:ucanaccess://Login.accdb";
        try {
            conn = DriverManager.getConnection(databaseURL);
        } catch (SQLException ex) {
            System.out.println("Cannot connect to database" + ex);
        }
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
    
    
    
    public boolean addStudent(String username, String password){
        boolean access= true;
        try{
            Statement stmt = conn.createStatement();           
            stmt.executeUpdate("INSERT INTO Login(Username,Password) VALUES('"+username+"','"+password+"')");
        }catch(SQLException ex){
            System.out.println("COULD NOT ADD");
            access=false;
        }
        return access;
                
    }
    public ResultSet getDescription(String name,String surname,String set,int grade,LocalDate date){
        ResultSet rs = null;
        String query = "SELECT Assignment FROM Assignments";
        String query1="SELECT Assignment FROM Assignments,Login WHERE Login.Class=Assignments.Class AND Username='"+name+"' AND Surname='"+surname+"' AND Grade='"+grade+"' AND DateOf='"+date+"'";
        //System.out.println(query);
        try{
            Statement stmt = conn.createStatement();
            rs=stmt.executeQuery(query1);
        }catch(SQLException ex){
            System.out.println("Could not execute query: "+ex);
            ex.printStackTrace();
        }
         return rs;
    }
    

}

