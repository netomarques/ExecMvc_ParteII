/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;





/**
 *
 * @author Wilson
 */
public class ConnectionFactory {
    
    public static Connection getConnection(){
        
        try{
            
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Class.forName("com.mysql.jdbc.Driver");
            String host = "jdbc:mysql://localhost:3306/mycosmetic";
            String user= "root";
            String password = "root";
            return DriverManager.getConnection(host, user, password);
            
        } catch(SQLException | ClassNotFoundException e){
            System.out.println("EXCEÇÃO CONNECTION " + e.getMessage());
            throw new RuntimeException(e);
            
        }
        
    }
    
}
