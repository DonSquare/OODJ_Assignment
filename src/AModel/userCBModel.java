/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AModel;

import javax.swing.ComboBoxModel;

/**
 *
 * @author Jaydon
 */
public class userCBModel extends myComboBoxModel implements ComboBoxModel {
    
    public userCBModel(boolean isGeneralExist){
        if(!isGeneralExist){
        super.col= new String[]{"Product Manager","Admin"};
        }
        else{
        super.col=new String[]{"Product Manager","Admin","General"};
        }
    }
   
    
}
