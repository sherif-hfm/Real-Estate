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
public class Payment {
    public int ContractId;
    public String InstallmentDate;
    public String InstallmentCode;
    public double Amount;
    
    public Object[] GetObject(){
        return new   Object[]{this.InstallmentCode,this.InstallmentDate,this.Amount};
    }
}
