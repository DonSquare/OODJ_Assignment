/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AModel;

/**
 *
 * @author Jaydon
 */
public class Admin extends User{
      public static final long serialVersionUID=2L;
      
      
    public Admin(Identification id,String name, String email, String contact, Gender gender,LoginInfo login){
        super(id,name, email, contact, Position.ADMIN, gender,login);
    }

}
