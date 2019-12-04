/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AModel.ComboBoxModels;

import AModel.User;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Jaydon
 */
public class genderComboBoxModel extends myComboBoxModel implements ComboBoxModel{
     
    public genderComboBoxModel(){
        super.col= new String[]{"Male","Female","Unspecified"};
    }
    
    public static User.Gender getGender(String s){
        User.Gender gender=null;
        switch(s){
            case "Male":
                gender = User.Gender.MALE;
                break;
            case "Female":
                gender = User.Gender.FEMALE;
                break;
            case "Unspecified":
                gender = User.Gender.UNSPECIFIED;
                break;
        }
        return gender;
    }
}
