/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AModel;
import java.nio.file.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Jaydon
 */
public class FolderManager  {
    
    /*
    Local Root 
    */
    //<editor-fold defaultstate="collapsed" desc="Variable declaration, Getter and Setter">
    private Path localroot;
    
    public Path getLocalRoot(){
        return localroot;
    }
    
    public void setLocalRoot(String s){
        this.localroot = Paths.get(s);
    }
//</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="Constructor">
    public FolderManager(boolean firstStart)throws IOException{
        if (firstStart == false){
            try{
                this.readLocal();
            }
            catch (Exception e){
                throw e;
            }
        }
        else{
        }
    }
//</editor-fold>
    
    
    
    //<editor-fold defaultstate="collapsed" desc="Read Localroot and Write Local ">
    public String writeLocal(Path p) {
        System.out.println("pass 2");
        try{
            FileWriter fw = new FileWriter ("defaultInfo.txt",true);
            System.out.println("pass 0");
            fw.write("Root Path: " + p.toString());
            System.out.println("pass 1");
            fw.close();
        }
        catch (IOException e){
            //Unable to write (?)
            System.out.println(e);
        }
        return "done";
    }
    
    public void readLocal()throws IOException{
        FileReader fr = new FileReader("defaultInfo.txt");
        BufferedReader bReader = new BufferedReader(fr);
        for(String line; (line = bReader.readLine())!= null;){
            if (line.startsWith("Root Path: ")){
                line=line.replace("\\","\\\\");
                this.localroot = Paths.get(line.replace("Root Path: ",""));
            }
        }
        fr.close();
        bReader.close();
    }

    @Override
    public String toString() {
        return localroot.toString();
    }
    
    


    }

