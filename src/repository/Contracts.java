/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import java.sql.*;  
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Contracts {
     public static List<Models.Contract> GetAllContracts(){
        try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("select * from ContractsAllData order by ContractId");
            System.out.println(sql);
            ResultSet rs=st.executeQuery(sql); 
            List<Models.Contract> result=new ArrayList<Models.Contract>();
            while (rs.next()) {
               Models.Contract row=new  Models.Contract();
               row.ContractId=rs.getInt("ContractId");
               row.TenantId=rs.getInt("TenantId");
               row.UnitId=rs.getInt("UnitId");
               row.RealEstateId=rs.getInt("RealEstateId");
               row.ContractTypeCode=rs.getInt("ContractTypeCode");
               row.UnitDesc=rs.getString("UnitDesc");
               row.RealEstateDesc=rs.getString("RealEstateDesc");
               row.TenantName=rs.getString("TenantName");
               row.ContractTypeDesc=rs.getString("ContractTypeDesc");
               row.StartDate=rs.getString("StartDate");
               row.EndDate=rs.getString("EndDate");
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
    
    public static boolean AddContract(Models.Contract data){
         try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("insert into Contracts (UnitId,TenantId,StartDate,EndDate,ContractTypeCode,Amount) values(%d,%d,\"%s\",\"%s\",%d,%f)",data.UnitId,data.TenantId,data.StartDate,data.EndDate,data.ContractTypeCode,data.Amount);
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
     
    public static boolean DelContract(String id){
         try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("delete from  Contracts where ContractId=%d",Integer.parseInt(id));
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
     
    public static Models.Contract GetContract(String id){
        try
        {   
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("select * from ContractsAllData where ContractId=%d",Integer.parseInt(id));
            System.out.println(sql);
            ResultSet rs=st.executeQuery(sql); 
            if (rs.next()) {
               Models.Contract row=new  Models.Contract();
               row.ContractId=rs.getInt("ContractId");
               row.TenantId=rs.getInt("TenantId");
               row.UnitId=rs.getInt("UnitId");
               row.RealEstateId=rs.getInt("RealEstateId");
               row.ContractTypeCode=rs.getInt("ContractTypeCode");
               row.UnitDesc=rs.getString("UnitDesc");
               row.RealEstateDesc=rs.getString("RealEstateDesc");
               row.TenantName=rs.getString("TenantName");
               row.ContractTypeDesc=rs.getString("ContractTypeDesc");
               row.StartDate=rs.getDate("StartDate").toString();
               row.EndDate=rs.getDate("EndDate").toString();
               row.Amount=rs.getDouble("Amount");
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
   
    public static boolean UpdateContract(Models.Contract data){
         try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("update Contracts set UnitId=%d,TenantId=%d,StartDate=\"%s\",EndDate=\"%s\",ContractTypeCode=%d,Amount=%f where ContractId=%d",data.UnitId,data.TenantId,data.StartDate,data.EndDate,data.ContractTypeCode,data.Amount,data.ContractId);
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
    
    public static List<Models.ContractType> GetContractType(){
        try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("select * from ContractTypes");
            System.out.println(sql);
            ResultSet rs=st.executeQuery(sql); 
            List<Models.ContractType> result=new ArrayList<Models.ContractType>();
            while (rs.next()) {
               Models.ContractType row=new  Models.ContractType();
               row.ContractTypeCode=rs.getInt("ContractTypeCode");
               row.ContractTypeDesc=rs.getString("ContractTypeDesc");
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
    
    public static List<Models.Contract> GetContractByTenant(int id){
       try
        {         
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
            Connection c=DriverManager.getConnection(Settings.url);  
            Statement st=c.createStatement();
            String sql=String.format("select * from ContractsAllData where TenantId=%d order by ContractId",id);
            System.out.println(sql);
            ResultSet rs=st.executeQuery(sql); 
            List<Models.Contract> result=new ArrayList<Models.Contract>();
            while (rs.next()) {
               Models.Contract row=new  Models.Contract();
               row.ContractId=rs.getInt("ContractId");
               row.TenantId=rs.getInt("TenantId");
               row.UnitId=rs.getInt("UnitId");
               row.RealEstateId=rs.getInt("RealEstateId");
               row.ContractTypeCode=rs.getInt("ContractTypeCode");
               row.UnitDesc=rs.getString("UnitDesc");
               row.RealEstateDesc=rs.getString("RealEstateDesc");
               row.TenantName=rs.getString("TenantName");
               row.ContractTypeDesc=rs.getString("ContractTypeDesc");
               row.StartDate=rs.getString("StartDate");
               row.EndDate=rs.getString("EndDate");
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
    
}
