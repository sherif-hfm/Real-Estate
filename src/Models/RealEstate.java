/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.rmi.server.ObjID;

/**
 *
 * @author Sherif
 */
public class RealEstate {
    public int RealEstateId;
    public String RealEstateDesc;
    public String RealEstateAddess;
    public String RealEstateOwnerName;
    public String RealEstateOwnerMobile;
    
    public Object[] GetObject(){
        return new   Object[]{this.RealEstateId,this.RealEstateDesc,this.RealEstateAddess,this.RealEstateOwnerName,this.RealEstateOwnerMobile};
    }
}
