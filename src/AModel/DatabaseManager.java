/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AModel;

import java.io.File;
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;



/**
 *
 * @author Jaydon
 */
public class DatabaseManager  {   
    
    public static void main(String[] args) throws IOException{
        DatabaseManager dm =new DatabaseManager(new FolderManager(false));
        TableList user = dm.getTable(Tables.USER);
        User admin = new Admin();
        User productManager = new ProductManager();
        try{
        admin.setLogin(new LoginInfo("admin","password")); //Login as Admin
        productManager.setLogin(new LoginInfo("pm","password")); //Login as PM
        }
        catch(Exception e){
            System.out.println(e);
        }
        user.add(admin);
        user.add(productManager);
        System.out.println(user.toString());
        dm.serialize(user);
    }
    
    ArrayList<TableList> database = new ArrayList<TableList>();
    FolderManager databaseDirectory;

        enum Tables{
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
    
    
    
    
    /**
     * Specific Table Methods
     * @param tableName
     * @return 
     */
   public TableList getTable(Tables T){
       TableList table=null;
       for (TableList tables : this.database){
           if (tables.getType() == T){
               table = tables;
           }
       }
       return table;
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
        System.out.println(obj.toString());
    }
    catch(Exception e)
    {
        System.out.println("deserialize"+e);
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

    
    
    

