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
public class OverDueBatch {
    public String InstallmentDate;
    public double Amount;
    public String TenantName;
    public String TenantMobile;
    public String RealEstateDesc;
    public String UnitDesc;
    
     public Object[] GetObject(){
        return new   Object[]{this.InstallmentDate,this.Amount,this.TenantName,this.TenantMobile,this.RealEstateDesc,this.UnitDesc};
    }
}
