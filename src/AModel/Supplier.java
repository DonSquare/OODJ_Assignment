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

    

    /*
    Getter and Setter
     */

    public String getID() {
        return ID.toString() ;
    }
    

    
}
