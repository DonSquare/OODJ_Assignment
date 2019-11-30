/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AController;
import AModel.User;
import AModel.DatabaseManager;
import AModel.FolderManager;
import AModel.LoginInfo;
import AView.MenuView;

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
            User user=null;
            if (view.Authenticate()){
                //Authentication Process
                LoginInfo l;
                try{
                l = new LoginInfo(view.getUsername(),view.getPassword());
                user=l.Authenticate(database);
                
                }   
                catch(AModel.LoginInfo.FailedAuthenticationException e0){
                    view.setWarning("Incorrect Username or Password");
                }
                catch (Exception e1){
                    System.out.println("Login Exception: "+e1);
                }
            }
            MenuController menu = new MenuController(new MenuView(user.getPosition()));
            view.setVisible(false);
        }
    
    
    }
}
    
    

