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
public abstract class User implements java.io.Serializable {
    private Identification ID;
    private String name,email,contact;
    private Position position;
    private Gender gender;
    private LoginInfo login;
    private boolean active=true;
    public static final long serialVersionUID=2L;
    
   /**
     * Constructor
     */
    public User(){};
    
    public User(String name, String email, String contact, Position position, Gender gender) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.position = position;
        this.gender = gender;
        
    }

    public User(Identification ID, String name, String email, String contact, Position position, Gender gender,LoginInfo login) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.position = position;
        this.gender = gender;
        this.login = login;
    }
    
    

 
    
      /**
     * Getter and Setter
     */
    
    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getContact() {
        return contact;
    }
    
    public Position getPosition() {
        return position;
    }
    
    public Gender getGender() {
        return gender;
    }
    
    public LoginInfo getLogin() {
        return login;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }
    
    public void setPosition(Position position) {
        this.position = position;
    }
    
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
    public void setLogin(LoginInfo login) {
        this.login = login;
    }
    
    public Identification getID(){
        return this.ID;
    }
    public void setID(Identification id){
        this.ID = id;
    }
    
    public String getActive(){
        String s;
        if (this.active == true){
            s = "Active";
        }
        else{
            s="Inactive";
        }
        return s;
}
//</editor-fold>
  
 
    
    @Override
    public String toString(){
        String s = this.name+","+this.email+","+this.contact+","+this.gender+","+this.position+","+this.login.toString();
        return s;
    }
    
    
    
    public enum Position{
        PRODUCT_MANAGER,
        ADMIN
    }
    
    public enum Gender{
        MALE,
        FEMALE,
        UNSPECIFIED
    }
    
}
