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
public class FreeUnit {
    public int UnitId;
    public int RealEstateId;
    public String UnitDesc;
    public String RealEstateDesc;
    public String RealEstateAddess;
    
    public Object[] GetObject(){
        return new   Object[]{this.RealEstateDesc,this.UnitDesc,this.RealEstateAddess};
    }
}
