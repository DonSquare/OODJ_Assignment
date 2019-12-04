/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AModel;

import java.util.ArrayList;

/**
 *
 * @author Jaydon
 */
public class Identification implements java.io.Serializable{
    
    
    public String header;
    public int number;
    public static final long serialVersionUID=2L;
    
    public enum headerGroup{
        PM, //PRODUCT MANAGER
        AD, //ADMIN
        SP,//SUPPLIER
        PR //PRODUCT
    }
    

    public Identification(headerGroup h,int i){
       this.number = i;
       switch(h){
           case AD:
               this.header="AD";
               break;
           case PM:
               this.header = "PM";
               break;
           case SP:
               this.header="SP";
               break;
           case PR:
               this.header="PR";
               break;
       }
       

    }
    
    public static int returnLastID(ArrayList<Identification> a){
        int num1 =0;
            for (Identification i:a){
             try{
                 if(num1<=i.number)
                 {
                     num1=i.number+1;
                 }
             }
             catch(Exception e){
            }
        }
        return num1;
    }
    
    

    
    public boolean IDisExist(Identification id)
    {
        if (this.toString().equals(id.toString()))
        {return true;}
        else{return false;}
    }

    
    @Override
    public String toString(){
    return header + Integer.toString(number);
    }      
}
