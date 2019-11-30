/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AController;
import AModel.User;
import AModel.DatabaseManager;
import AModel.FolderManager;
import java.awt.event.ActionEvent;
import java.nio.file.*;
import java.io.*;


/**
 *
 * @author Jaydon
 */
public class LoginController {
    AView.LoginView view;
    FolderManager fMan;
    DatabaseManager database;
    
    /**
     * Constructor for Login Controller (Basically the Login window)
     * @param view 
     * @throws java.io.IOException 
     */
    public LoginController() throws IOException {
        view = new AView.LoginView();
        if (view.getLocal().equals("local")){
        try{
            fMan = new AModel.FolderManager(false);
            view.setLocal(fMan.getLocalRoot().toString());

        }
        catch(FileNotFoundException e0){
         // Prompt for new file
            fMan = new AModel.FolderManager(true);
            view.rootPrompt();
            Path p = Paths.get(this.view.getLocal());
            this.fMan.setLocalRoot(p.toString());
            System.out.println(p.toString());
            System.out.println(fMan.writeLocal(p));
            fMan.setLocalRoot(this.view.getLocal());
                } 
        catch(IOException e1){
            // Cannot be thrown for some reason
            }
        
        database = new DatabaseManager(fMan);
        
           }
        
        
        /**
         * Event Listener
         */
        
        this.view.addEnterListener(new EnterListener());
        }
    
    
    public class EnterListener implements java.awt.event.ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (view.Authenticate()){
                //Authentication Process
                
                if (view.getUsername().equals("PM")){
                AView.MenuView menu = new AView.MenuView(User.Position.PRODUCT_MANAGER);
                }
                else{
                AView.MenuView menu = new AView.MenuView(User.Position.ADMIN);
                }
            }
            
        }
    
    
    }
}
    
    

