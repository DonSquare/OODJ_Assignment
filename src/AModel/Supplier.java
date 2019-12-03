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
public class Supplier implements java.io.Serializable{
    private Identification ID;
    public String name,address,contact,email;
    public static final long serialVersionUID=2L;

    public Supplier(){};

    public Supplier(String name, String address, String contact, String email) {
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.email = email;
    }
  

    /*
    Getter and Setter
     */

    public Identification getID() {
        return ID ;
    }

    @Override
    public String toString() {
        return "ID:" + ID + ", name:" + name + ", address:" + address + ", contact:" + contact + ", email:" + email + '}';
    }
    

    
}
