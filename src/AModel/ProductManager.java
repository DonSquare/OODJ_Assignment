/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AModel;

import java.io.*;
import java.nio.file.*;

/**
 *
 * @author Jaydon
 */
public class ProductManager extends User{
   
   private boolean active;
   public static final long serialVersionUID=2L;
   
    public ProductManager(){};
   
    public ProductManager(Identification id,String name, String email, String contact, Gender gender,LoginInfo login) {
        super(id,name, email, contact, Position.PRODUCT_MANAGER, gender,login);
        this.active=true;
    }
    
  
    public void setActive(boolean active){
        this.active = active;
    }
    
 
    public String getActive(){
        if(this.active==true){
            return "Active";
        }
        else{
            return "inActive";
        }
    }

    
    
}
