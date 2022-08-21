/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login.screen;

import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextArea;

/**
 *
 * @author xpeng
 */
public class DBDiscussion {
    private Connection conn;
    static discussion[] d = new discussion[100];
    static int size=0;
    
    public DBDiscussion(){
        String databaseURL = "jdbc:ucanaccess://Discussion.accdb";
        try{
            conn = DriverManager.getConnection(databaseURL);
        }catch (SQLException ex) {
            System.out.println("Cannot connect to database" + ex);
        }
    }
     public boolean addDiscussion(String text, String subject,int indentation){
        boolean access= true;
        try{
            Statement stmt = conn.createStatement();
            stmt.executeQuery("INSERT INTO tblDiscussion(Indentation,Subject,Comment) VALUES('"+indentation+"', '"+subject+"','"+text+"')");
        }catch(SQLException ex){
            System.out.println("COULD NOT ADD");
            access=false;
        }
        return access;        
    }
    public void addArrayDiscussion(int indentation,JTextArea jta,int id){
        d[size] = new discussion(indentation,jta,id);size++;
    }
    public void shiftdown(int id){
        int index=0;
        for (int i = 0; i < size; i++) {
            if (d[i].id==id) {
                index=i;break;
            }
        }
        //d[index].jta.setLocation(d[index].jta.getX(), d[index].jta.getY()+10);   
        d[index].jta.setSize(500, d[index].jta.getSize().height+10);
        for (int i = index+1; i < size; i++) {
            Point p = d[i].jta.getLocation();
            int row = p.y;
            int col=p.x;
            d[i].jta.setLocation(new Point(col,row+20));
        }
    }
    
    
}
class discussion{
    JTextArea jta;
    int indentation,id;
    discussion(int indentation,JTextArea jta,int id){
        this.indentation=indentation;this.jta=jta;this.id=id;
    }
}
