/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AModel.ComboBoxModels;


import AModel.DatabaseManager;
import AModel.Supplier;
import AModel.TableList;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Jaydon
 */
public class supplierCBModel extends myComboBoxModel implements ComboBoxModel{

    
    public supplierCBModel(DatabaseManager db){
        super.list = new ArrayList<>();
        TableList table = db.getTable(DatabaseManager.Tables.SUPPLIER);
        System.out.println("wow");
        for (Object supplier : table){
            System.out.println("wow");
            Supplier s = (Supplier)supplier;
            super.list.add(s.name);  
        }
       
        super.col = new String[super.list.size()];
        for (int i=0;i<list.size();i++){
            super.col[i]= list.get(i);
            System.out.println(col[i]);
        }
        System.out.println("CBMODEL, Supplier successfully pulled");
    }

}
