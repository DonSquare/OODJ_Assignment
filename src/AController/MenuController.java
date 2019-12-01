/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AController;
import AModel.User;
import AView.MenuView;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 *
 * @author Jaydon
 */
public class MenuController {
    
   MenuView view;
    

    public MenuController(MenuView view,User user){
        
//        view.addNavibarListener(new NavibarListener(user),user); //Constructor
        
    }
    
    
    
//    public class NavibarListener implements java.awt.event.ActionListener{
//        public User user;
//        public NavibarListener(User u){
//        this.user = u;
//        };
//        JButton button= null;
//    
//    @Override
//    public void actionPerformed(ActionEvent e){
//        button=(JButton) e.getSource();
//        String s =(button).getText();
//            if (s.equals("Manage Personal Profile")){
//                System.out.println("profile");
//                view.setContentPane(user.getPosition(),MenuView.panelchoice.PROFILEAD);
//                System.out.println("profile test");
//            }
//            else if (s.equals("Manage Manager")){
//                System.out.println("manager");
//                view.setContentPane(user.getPosition(),MenuView.panelchoice.MANAGERAD);
//                System.out.println("manager test");
//            
//            }
//            
//        }
//        
//    
//    }
}
    
