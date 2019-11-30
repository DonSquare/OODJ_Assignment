/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AModel;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;


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
    private String hashedPW;
    

    /**
     * Constructor, Getter and Setter
     * @return 
     */
    
    public LoginInfo(String username, String password) 
                throws NoSuchAlgorithmException, InvalidKeySpecException{
        this.username = username;
        this.password = password.toCharArray();
        this.hashedPW = toHashString(username,password.toCharArray());
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
   
    public User Authenticate(DatabaseManager dm) throws FailedAuthenticationException{
        TableList userTable = dm.getTable(DatabaseManager.Tables.USER);
        User output=null;
        for (Object obj : userTable){
            User user = (User)obj;
            if(this.hashedPW.equals(user.getLogin().password))
                    {output = user;}
        }
        if (output==null)
        {
            throw new FailedAuthenticationException();
        }
        return output;  
        }
        
    public static String toHashString(String username, char[] password) throws NoSuchAlgorithmException, InvalidKeySpecException{
        String output="";
        final int iteration =1000;
        final int keyLength = 128;
        byte[] salt = username.getBytes();
        KeySpec spec = new PBEKeySpec(password,salt,iteration,keyLength);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return Arrays.toString(hash);
           
    }  
    
    
    
    public class FailedAuthenticationException extends Exception{};
    
    /**
     * Password Hashing
     * @return 
     */

    @Override
    public String toString(){
    return this.username + "," + this.hashedPW;
    
    }
    
}
