/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AModel;


import java.io.*;
import java.nio.file.Path;

/**
 *
 * @author Jaydon
 */
public class UserFactory implements Serializable{
    User user;
    
    
    
    public static void main(String[] args) throws IOException {
//        User beta = new ProductManager();
//        FolderManager fm = new FolderManager(false);
//        beta.Serialize(fm.getLocalRoot(), beta);
//        System.out.println(beta);
        UserFactory test = new UserFactory();
        test.createUser(User.Position.PRODUCT_MANAGER);
        System.out.println(test.user.toString());
        
    }
    
    public void createUser(User.Position position) throws IOException{
        
        FolderManager fm = new FolderManager(false);
        
    
        switch (position){
            case PRODUCT_MANAGER:
                user = new ProductManager();
                break;
            case ADMIN:
                user = new Admin();
                break;
        }
        
 
        
    }
   

    
}
