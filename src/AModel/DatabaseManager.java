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
    

    
    public ArrayList<TableList> database = new ArrayList<TableList>();
    public FolderManager databaseDirectory;

        public enum Tables{
        PRODUCT,
        SUPPLIER,
        USER,
        CATALOGUE,
        LOG
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
            System.out.println("test 3");
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
   
   /*
   get LastID
   */
   public int getNewIdentification(TableList t,boolean last){
       ArrayList<Identification> i = new ArrayList<>();
       int output=0;
       for (Object o:t){
       switch (t.getType()){
           case SUPPLIER:
               Supplier s = (Supplier)o;
               i.add(s.getID());
               break;
           case USER:
               User u = (User)o;
               i.add(u.getID());
               break;
           case PRODUCT:
               Product p = (Product)o;
               i.add(p.getID());
               break; 
       }}
       if (last==true){
       output=Identification.returnLastID(i);
       }
       else if (last==false){
       output=Identification.returnLastID(i)+1;
       }
       return output;
   }
   
   /*
         CRUD
   */
   
   public void addElements(Tables T,Object obj){
       TableList table;
       switch (T){
           
           case USER:
              table = this.getTable(T);
                table.add((User)obj);
               break;
           case LOG:
              table = this.getTable(T);
               table.add((Log)obj);
               break;
           case SUPPLIER:
              table = this.getTable(T);
            table.add((Supplier)obj);
               break;
           case PRODUCT:
                table = this.getTable(T);
                table.add((Product)obj);
               break;
       }
   }

   public void deleteElements(Tables T,Object obj){
       TableList table=null;
       switch (T){
           case USER:
              table = this.getTable(T);
               break;
           case LOG:
              table = this.getTable(T);
               break;
           case SUPPLIER:
              table = this.getTable(T);
               break;
           case PRODUCT:
                table = this.getTable(T);
               break;
       }
       for(Object element: table){
           if(obj.equals(element)){
               table.remove(obj);
               System.out.println("object removed");
           }
       }
   }
   
   public void updateElements(Tables T,Object preObj,Object postObj){
        TableList table=null;
        switch (T){
           case USER:
              table = this.getTable(T);
               break;
           case LOG:
              table = this.getTable(T);
               break;
           case SUPPLIER:
              table = this.getTable(T);
               break;
           case PRODUCT:
                table = this.getTable(T);
               break;
       }
        for(Object element: table){
           if(preObj.equals(element)){
               int i = table.indexOf(element);
               table.set(i, postObj);
           }
   }
   }
   
  /*
   Serialize
   */ 
  public void serialize(TableList table) throws IOException{
      System.out.println("2");
      System.out.println(table);
      String fileName = table.getTableFileName();
      Path tableFile =  this.databaseDirectory.getLocalRoot().resolve(fileName);
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(tableFile.toString())));
      out.writeObject(table);
      out.close(); 
  } 
 
  public void serializeAll() throws IOException{
      System.out.println("1");
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

    
    
    

