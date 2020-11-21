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
public class Contract {
    public int ContractId;
    public int TenantId;
    public int UnitId;
    public int RealEstateId;
    public int ContractTypeCode;
    
    public String UnitDesc;
    public String RealEstateDesc;
    public String TenantName;
    public String ContractTypeDesc;
    public String StartDate;
    public String EndDate;
    public double Amount;
    
    public Object[] GetObject(){
        return new   Object[]{
            this.ContractId,
            this.UnitDesc,
            this.RealEstateDesc,
            this.TenantName,
            this.ContractTypeDesc,
            this.StartDate,
            this.EndDate,
            this.Amount,
        };
    }
}
