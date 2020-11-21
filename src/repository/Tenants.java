/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.*;  
import java.util.*;


public class Tenants {
      public static List<Models.Tenant> GetAllTenants(){
        try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("select * from Tenants");
            System.out.println(sql);
            ResultSet rs=st.executeQuery(sql); 
            List<Models.Tenant> result=new ArrayList<Models.Tenant>();
            while (rs.next()) {
               Models.Tenant row=new  Models.Tenant();
               row.TenantId=rs.getInt("TenantId");
               row.TenantName=rs.getString("TenantName");
               row.TenantIdNo=rs.getString("TenantIdNo");
               row.TenantMobile=rs.getString("TenantMobile");
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
    
     public static boolean AddTenant(Models.Tenant data){
         try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("insert into Tenants (TenantName,TenantIdNo,TenantMobile) values(\"%s\",\"%s\",\"%s\")",data.TenantName,data.TenantIdNo,data.TenantMobile);
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
     
     public static boolean DelTenant(String id){
         try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("delete from  Tenants where TenantId=%d",Integer.parseInt(id));
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
     
   public static Models.Tenant GetTenant(String id){
        try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("select * from Tenants where TenantId=%d",Integer.parseInt(id));
            System.out.println(sql);
            ResultSet rs=st.executeQuery(sql); 
            if (rs.next()) {
               Models.Tenant row=new  Models.Tenant();
               row.TenantId=rs.getInt("TenantId");
               row.TenantName=rs.getString("TenantName");
               row.TenantIdNo=rs.getString("TenantIdNo");
               row.TenantMobile=rs.getString("TenantMobile");
               return row;
            }
            else
            return null;
        }
        catch(Exception ex)
        {
            System.err.println(ex);
            return null;
        }  
    }
   
   public static boolean UpdateRealEstates(Models.Tenant data){
         try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("update Tenants set TenantName=\"%s\",TenantIdNo=\"%s\",TenantMobile=\"%s\" where TenantId=%d",data.TenantName,data.TenantIdNo,data.TenantMobile,data.TenantId);
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
}
