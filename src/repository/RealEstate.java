/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.*;  
import java.util.*;

/**
 *
 * @author Sherif
 */
public class RealEstate {
    
    public static List<Models.RealEstate> GetAllRealEstates(){
        try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("select * from RealEstates");
            System.out.println(sql);
            ResultSet rs=st.executeQuery(sql); 
            List<Models.RealEstate> result=new ArrayList<Models.RealEstate>();
            while (rs.next()) {
               Models.RealEstate row=new  Models.RealEstate();
               row.RealEstateId=rs.getInt("RealEstateId");
               row.RealEstateDesc=rs.getString("RealEstateDesc");
               row.RealEstateAddess=rs.getString("RealEstateAddess");
               row.RealEstateOwnerName=rs.getString("RealEstateOwnerName");
               row.RealEstateOwnerMobile=rs.getString("RealEstateOwnerMobile");
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
    
     public static boolean AddRealEstates(Models.RealEstate data){
         try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("insert into RealEstates (RealEstateDesc,RealEstateAddess,RealEstateOwnerName,RealEstateOwnerMobile) values(\"%s\",\"%s\",\"%s\",\"%s\")",data.RealEstateDesc,data.RealEstateAddess,data.RealEstateOwnerName,data.RealEstateOwnerMobile);
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
     
     public static boolean DelRealEstate(String id){
         try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("delete from  RealEstates where RealEstateId=%d",Integer.parseInt(id));
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
     
   public static Models.RealEstate GetRealEstate(String id){
        try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("select * from RealEstates where RealEstateId=%d",Integer.parseInt(id));
            System.out.println(sql);
            ResultSet rs=st.executeQuery(sql); 
            if (rs.next()) {
               Models.RealEstate row=new  Models.RealEstate();
               row.RealEstateId=rs.getInt("RealEstateId");
               row.RealEstateDesc=rs.getString("RealEstateDesc");
               row.RealEstateAddess=rs.getString("RealEstateAddess");
               row.RealEstateOwnerName=rs.getString("RealEstateOwnerName");
               row.RealEstateOwnerMobile=rs.getString("RealEstateOwnerMobile");
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
   
   public static boolean UpdateRealEstates(Models.RealEstate data){
         try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("update RealEstates set RealEstateDesc=\"%s\",RealEstateAddess=\"%s\",RealEstateOwnerName=\"%s\",RealEstateOwnerMobile=\"%s\" where RealEstateId=%d",data.RealEstateDesc,data.RealEstateAddess,data.RealEstateOwnerName,data.RealEstateOwnerMobile,data.RealEstateId);
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
