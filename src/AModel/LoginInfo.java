/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AModel;

import java.io.Serializable;

/**
 *
 * @author Jaydon
 */
public class LoginInfo implements Serializable{
    /**
     * Variable Declaration
     */
    private String username;
    private char[] password;
    
    /**
     * Getter and Setter
     * @return 
     */
    
    public LoginInfo(String username, String password){
        this.username = username;
        this.password = password.toCharArray();
    }

    public String getUsername() {
        return username;
    }

    public char[] getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
    
    public User Authenticate(DatabaseManager dm) throws FailedAuthenticationException{
        for (User user:userTable){
        
        }
        
        
    
    }
    
    public class FailedAuthenticationException extends Exception{};
    
    /**
     * Password Hashing
     * @return 
     */
    public void encryptPassword(){};
    public void decryptPassword(){};
    
    
    @Override
    public String toString(){
    return this.username + "," + this.password;
    
    }
    
}
