/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;
import java.sql.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
/**
 *
 * @author vrush
 */
public class conn {
    Connection c;//resonsible for establishing connection with mysql database
    Statement s;//responsible for executing query

    public conn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");//driver load
            c=DriverManager.getConnection("jdbc:mysql:///clz_pro","root","root");
            s=c.createStatement();
            System.out.println("Successfull connection...!!!");
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }
    public static void main(String[] args) {
        conn obj=new conn();
    }
    
    
    
}
