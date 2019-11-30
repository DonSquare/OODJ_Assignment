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
    

    public ProductManager(String name, String email, String contact, Position position, Gender gender, LoginInfo login) {
        super(name, email, contact, position, gender, login);
    }
    
    public ProductManager(){
        super("name", "email", "contact", Position.PRODUCT_MANAGER, Gender.MALE, new LoginInfo());
    }
    
    //Start of Main
    public static void main(String[] args){
        UserFactory uFac = new UserFactory();
        try{
//            uFac.createUser(Position.PRODUCT_MANAGER);
            FolderManager fm = new FolderManager(false);
            System.out.println("test1");
//            test.deSerialize(fm.getLocalRoot(), test);
//            System.out.println(test);
        }
        catch (Exception e){
            System.out.println(e);
        
        }
    
    }
    
    //End of main
    
    
}
