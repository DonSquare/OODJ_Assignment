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
   public static final long serialVersionUID=2L;

    public ProductManager(Identification id,String name, String email, String contact, Gender gender,LoginInfo login) {
        super(id,name, email, contact, Position.PRODUCT_MANAGER, gender,login);
      
        
    }
    
   
    
   public ProductManager(String name, String email, String contact, Gender gender, LoginInfo login) {
        super(name, email, contact, Position.PRODUCT_MANAGER, Gender.MALE);
        this.setLogin(login);
    }
    
    public ProductManager(){
        super("name", "email", "contact", Position.PRODUCT_MANAGER, Gender.MALE);
    }
    
    //Start of Main
    public static void main(String[] args){

    
    }
    
    //End of main
    
    
}
