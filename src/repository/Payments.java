/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.*;  
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javafx.util.*;

/**
 *
 * @author Sherif
 */
public class Payments {
    public static List<Pair<String,String>> GetUnpaidBatchs(int id){
        try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("select * from UnpaidBatchs where ContractId=%d",id);
            System.out.println(sql);
            ResultSet rs=st.executeQuery(sql); 
            List<Pair<String,String>> result=new ArrayList<Pair<String,String>>();
            while (rs.next()) {
               Pair<String,String> row=new Pair<>(rs.getString("InstallmentCode"),rs.getDate("InstallmentDate").toString());
               result.add(row);
            }
            return result;
        }
        catch(Exception ex)
        {
            System.err.println(ex);
            return null;
        }  
    }
    
    public static List<Models.Payment> GetPaidBatchs(int id){
        try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("select * from PaidBatchs where ContractId=%d",id);
            System.out.println(sql);
            ResultSet rs=st.executeQuery(sql); 
            List<Models.Payment> result=new ArrayList<Models.Payment>();
            while (rs.next()) {
                Models.Payment row=new Models.Payment();
                row.ContractId=rs.getInt("ContractId");
                row.InstallmentDate=rs.getDate("InstallmentDate").toString();
                row.InstallmentCode=rs.getString("InstallmentCode");
                row.Amount=rs.getDouble("Amount");
               result.add(row);
            }
            return result;
        }
        catch(Exception ex)
        {
            System.err.println(ex);
            return null;
        }  
    }
    
     public static boolean AddBatch(String data){
         try
        {   
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
            LocalDateTime now = LocalDateTime.now();  
            String crDate= dtf.format(now); 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("insert into Payments (InstallmentCode,PaymentDate) values(\"%s\",\"%s\")",data,crDate);
            System.out.println(sql);
            boolean rs=st.execute(sql); 
            return rs;
        }
        catch(Exception ex)
        {
            System.err.println(ex);
            return false;
        }  
     }
        
    public static boolean DelBatch(String id){
         try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("delete from  Payments where InstallmentCode=\"%s\"",id);
            System.out.println(sql);
            boolean rs=st.execute(sql); 
            return rs;
        }
        catch(Exception ex)
        {
            System.err.println(ex);
            return false;
        }  
     }
    
    public static List<Models.OverDueBatch> GetOverDueBatchs(){
        try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("select * from OverDueBatchs");
            System.out.println(sql);
            ResultSet rs=st.executeQuery(sql); 
            List<Models.OverDueBatch> result=new ArrayList<Models.OverDueBatch>();
            while (rs.next()) {
                Models.OverDueBatch row=new Models.OverDueBatch();
                row.InstallmentDate=rs.getDate("InstallmentDate").toString();
                row.Amount=rs.getDouble("Amount");
                row.TenantName=rs.getString("TenantName").toString();
                row.TenantMobile=rs.getString("TenantMobile");
                row.RealEstateDesc=rs.getString("RealEstateDesc");
                row.UnitDesc=rs.getString("UnitDesc");
               result.add(row);
            }
            return result;
        }
        catch(Exception ex)
        {
            System.err.println(ex);
            return null;
        }  
    }
}
