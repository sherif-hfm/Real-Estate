/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Sherif
 */
public class Tenant {
     public int TenantId;
    public String TenantName;
    public String TenantIdNo;
    public String TenantMobile;
    
    public Object[] GetObject(){
        return new   Object[]{this.TenantId,this.TenantName,this.TenantIdNo,this.TenantMobile};
    }
}
