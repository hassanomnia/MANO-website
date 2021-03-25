/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.shopping;

/**
 *
 * @author Nihal
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseManagement {
    static PreparedStatement preparedStatment = null;
    static ResultSet result = null;
    static PreparedStatement pstat;
    static String sqlCommand;
    static String sqlCommand1;
    static char[] ch = null;
    static Statement state;
    static String nme = "";
    static boolean checkname = true;
    static public ResultSet selectAllProducts(Connection connection) {
        try {
            state =connection.createStatement();
            sqlCommand = "SELECT * from product";
            result = state.executeQuery(sqlCommand);
        } 
        catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    static public ResultSet selectSingleProduct(Connection connection, int id) {
        try {
            state =connection.createStatement();
            sqlCommand = "SELECT * from product WHERE product_id ="+id;
            result = state.executeQuery(sqlCommand);
        } 
        catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    // This function return admin if user in admin table, 
    // return customer if user in customer table and 
    // return false if not exist
    static public String checkSiginIn(Connection connection, String name , String password) {
        String checkFlag = "";
        if(!(name.equals(null)) && !(password.equals(null)))
        {
        try {
            state =connection.createStatement();
            sqlCommand = "SELECT * from admin";
            result = state.executeQuery(sqlCommand);
            while (result.next()) {
                if (result.getString(2).equals(name) && result.getString(3).equals(password) ) 
                    checkFlag = "admin";   
            }
            state =connection.createStatement();
            sqlCommand = "SELECT * from customer";
            result = state.executeQuery(sqlCommand);
            while (result.next()) {
                if (result.getString(7).equals(name) && result.getString(9).equals(password)) 
                    checkFlag = "customer";   
            }
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(!(checkFlag.equals("customer")) && !(checkFlag.equals("admin")))
                checkFlag = "false";
        }
            
        return checkFlag;  
    }  
     // This function return true if username is not exist, 
     // else return false 
     static public String checkSiginUp(Connection connection, String name) {
        String checkFlag = "true";
        if(name != null )
        {
        try {
            state =connection.createStatement();
            sqlCommand = "SELECT * from admin";
            result = state.executeQuery(sqlCommand);
            while (result.next()) {
                if (result.getString(2).equals(name)) 
                    checkFlag = "false";   
            }
            state =connection.createStatement();
            sqlCommand = "SELECT * from customer";
            result = state.executeQuery(sqlCommand);
            while (result.next()) {
                if (result.getString(7).equals(name)) 
                    checkFlag = "false";   
            }
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
         return checkFlag;  
    }  
        return "false";  
} 
      static public void insertUser(Connection connection, int cart_id,String credit_info, String birthday, String username, String email, String password, String job) {
        try {
                
                pstat = connection.prepareStatement("INSERT INTO customer(customer_id,cart_id, credit_info,birthday,username,email,password,job)VALUES (?,?,?,?,?,?,?)");
                pstat.setString(1, "DEFAULT");
                pstat.setInt(2, cart_id);
                pstat.setString(3, credit_info);
                pstat.setString(4, birthday);
                pstat.setString(4, username);
                pstat.setString(4, email);
                pstat.setString(4, password);
                pstat.setString(4, job);
                int rows = pstat.executeUpdate(); 
            }
        catch (SQLException ex) {
            Logger.getLogger(DataBaseManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }  
       
}


