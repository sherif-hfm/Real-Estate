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
public class Unit {
     public int UnitId;
    public int RealEstateId;
    public String UnitDesc;
    
    public Object[] GetObject(){
        return new   Object[]{this.UnitId,this.UnitDesc};
    }
}

