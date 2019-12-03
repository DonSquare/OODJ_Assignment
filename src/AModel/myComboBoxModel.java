/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AModel;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Jaydon
 */
public class myComboBoxModel extends AbstractListModel implements ComboBoxModel {
    
    String[] col;
    String selection;
    ArrayList<String> list;
    
    public String getElementAt(int index){
        return (String)col[index];
    }
    
    public int getSize(){
        return col.length;
    }
    
    public void setSelectedItem(Object item){
        selection = (String)item;
    }
    
    public Object getSelectedItem(){
        return selection;
    }
}
