/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AModel;

import java.io.File;
import java.io.*;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;



/**
 *
 * @author Jaydon
 */
public class DatabaseManager  {   
    
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException{

    }

    
    ArrayList<TableList> database = new ArrayList<TableList>();
    FolderManager databaseDirectory;

        public enum Tables{
        PRODUCT,
        SUPPLIER,
        USER,
        CATALOGUE
         //Using enum here for better control of what tables 
        //can be made
    }
    /*
    Constructor
    */
    
    public DatabaseManager(FolderManager fm){

        this.databaseDirectory=fm;
        try{
        this.pullTables();
        this.databaseListCheck();
        this.serializeAll();
        }
        catch (Exception e){
            System.out.println("DM instantiation error"+e);
        }


    }
   
    /*
    After pulling all table, checks if there are any missing table
    Allows for Control of what tables should exists
    */
    
    public boolean isTableExist(Tables T){
    
        boolean flag=false;
        for (TableList table : this.database){
            if (table.getType()== T){
                flag = true;
            }
        }
        return flag;
    }
    

    
    
    public void databaseListCheck(){
            for (Tables type : Tables.values()){
            if(!this.isTableExist(type)){
            this.database.add(new TableList(type));
            }
        }
        
    }
    
    public void databaseAddMasters() throws IOException{
        User user1 = new Admin();
        User user2 = new ProductManager();
        user1.setName("masterAdmin");
        try{
        user1.setLogin(new LoginInfo ("admin","password"));
        user2.setName("masterProductManager");
        user2.setLogin(new LoginInfo ("pm","password"));
        }
        catch(Exception e){
            System.out.println("master creation error");
        }
//        System.out.println("user1: "+user1);
//        System.out.println("user2: "+user2);
//        System.out.println("========================================");
//        System.out.println("Pulled tables \n"+ dm.getTable(Tables.USER));
        TableList table = this.getTable(Tables.USER);
        table.add(user1);
        table.add(user2);
//        System.out.println("==================================");
//        System.out.println("pre serialization: \n"+ table);
        this.serialize(table);
 
        }
//        System.out.println("Testing 2 "+dm.toString());
    
    
    
    
    
    /**
     * Specific Table Methods
     * @param tableName
     * @return 
     */
   public TableList getTable(Tables T){
       System.out.println("test");
       TableList table=null;
       for (TableList tables : this.database){
           if (tables.getType() == T){
               table = tables;
           }
       }
       return table;
   }
   
   public void addUser(User user) throws IOException{
       TableList table = this.getTable(Tables.USER);
       table.add(user);
       serialize(table);
   }
   

  /*
   Serialize
   */ 
  public void serialize(TableList table) throws IOException{
      String fileName = table.getTableFileName();
      Path tableFile =  this.databaseDirectory.getLocalRoot().resolve(fileName);
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(tableFile.toString())));
      out.writeObject(table);
      out.close(); 
  } 
 
  public void serializeAll() throws IOException{
      for (TableList table : this.database){
        this.serialize(table);
      }

  }
   
   /*
  DeSerialize
  */
  
  public Object deserialize(File tableFileName) throws IOException {
    ObjectInputStream in = new ObjectInputStream(new FileInputStream(tableFileName));
    Object obj = null;
    try{
    obj = in.readObject();
    }
    catch(Exception e)
    {
        System.out.println("deserialize "+e);
    }
    in.close();
    
    return obj;
  }
  
//  public void objConverter(TableList preConvert,TableList postConvert,Tables tableType){
//      for (Object elements: preConvert){
//          switch (tableType){
//            case PRODUCT:
//                postConvert.add((Product)elements);
//                break;
//            case SUPPLIER:
//                postConvert.add((Supplier)elements);
//                break;
//            case USER:
//                postConvert.add((User)elements);
//                break;
//            case CATALOGUE:
//                postConvert.add((Catalogue)elements);
//                break;
//    }
//          
//      
//      }
//  }
 
    public void pullTables() throws IOException{
       
        File dir = new File(this.databaseDirectory.getLocalRoot().toString());
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null){
            for (File tables : directoryListing){
                    
                    TableList deserializedList = (TableList)this.deserialize(tables);
                    this.database.add(deserializedList);
                }
        }
    }
    
    @Override
    public String toString(){
        String output ="Location: "+this.databaseDirectory.toString() + "\n";
        int index = 0;
        for (TableList table: this.database){
            if (index==1){
            output += table.getTableName();
            index+=1;
            }
            else{
            output += (","+ table.getTableName());
            }
        }
        return output;
    }
   
}

    
    
    

