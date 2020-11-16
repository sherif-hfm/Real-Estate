/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.*;  


/**
 *
 * @author Sherif
 */
public class Users {
    
    public static boolean GetUser(String user,String pass) {
        try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("select * from Users where UserLogin=\"%s\" and UserPassword=\"%s\"",user,pass);
            System.out.println(sql);
            ResultSet rs=st.executeQuery(sql);  
            if(rs.next()){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception ex)
        {
            System.err.println(ex);
            return false;
        }  
    }
}
