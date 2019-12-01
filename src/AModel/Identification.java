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
public class Identification{
    
    public String header;
    public int number;
    
    enum headerGroup{
        PM, //PRODUCT MANAGER
        AD, //ADMIN
        SP,//SUPPLIER
        PR //PRODUCT
    }

    public Identification(headerGroup h,int i){
       this.number = i;
       switch(h){
           case PM:
               this.header="PM";
               break;
           case AD:
               this.header="AD";
               break;
           case SP:
               this.header="SP";
               break;
           case PR:
               this.header="PR";
               break;
       }
       

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
