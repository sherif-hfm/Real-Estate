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
public class Units {
    
    public static List<Models.Unit> GetAllUnits(int realEstateId){
        try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("select * from Units where RealEstateId=%d",realEstateId);
            System.out.println(sql);
            ResultSet rs=st.executeQuery(sql); 
            List<Models.Unit> result=new ArrayList<Models.Unit>();
            while (rs.next()) {
               Models.Unit row=new  Models.Unit();
               row.UnitId=rs.getInt("UnitId");
               row.RealEstateId=rs.getInt("RealEstateId");
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
        
    public static boolean AddUnit(Models.Unit data){
         try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("insert into Units (RealEstateId,UnitDesc) values(%d,\"%s\")",data.RealEstateId,data.UnitDesc);
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
        
    public static boolean DelUnit(String id){
         try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("delete from  Units where UnitId=%d",Integer.parseInt(id));
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
         
    public static Models.Unit GetUnit(String id){
        try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("select * from Units where UnitId=%d",Integer.parseInt(id));
            System.out.println(sql);
            ResultSet rs=st.executeQuery(sql); 
            if (rs.next()) {
               Models.Unit row=new  Models.Unit();
               row.UnitId=rs.getInt("UnitId");
               row.RealEstateId=rs.getInt("RealEstateId");               
               row.UnitDesc=rs.getString("UnitDesc");
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
   
    public static boolean UpdateUnit(Models.Unit data){
         try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("update Units set RealEstateId=%d,UnitDesc=\"%s\" where UnitId=%d",data.RealEstateId,data.UnitDesc,data.UnitId);
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
    
    public static List<Models.Unit> GetFreeUnitsByRealId(int realEstateId){
        try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("select * from FreeUnits where RealEstateId=%d",realEstateId);
            System.out.println(sql);
            ResultSet rs=st.executeQuery(sql); 
            List<Models.Unit> result=new ArrayList<Models.Unit>();
            while (rs.next()) {
               Models.Unit row=new  Models.Unit();
               row.UnitId=rs.getInt("UnitId");
               row.RealEstateId=rs.getInt("RealEstateId");
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
    
    public static List<Models.FreeUnit> GetAllFreeUnits(){
        try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("select * from FreeUnits order by RealEstateId");
            System.out.println(sql);
            ResultSet rs=st.executeQuery(sql); 
            List<Models.FreeUnit> result=new ArrayList<Models.FreeUnit>();
            while (rs.next()) {
               Models.FreeUnit row=new  Models.FreeUnit();
               row.UnitId=rs.getInt("UnitId");
               row.RealEstateId=rs.getInt("RealEstateId");
               row.UnitDesc=rs.getString("UnitDesc");
               row.RealEstateDesc=rs.getString("RealEstateDesc");
               row.RealEstateAddess=rs.getString("RealEstateAddess");
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
