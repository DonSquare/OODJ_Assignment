/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AModel;
import java.io.Serializable;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Jaydon
 */
public class Log implements Serializable {
 
    
/*
    Testing
    */  
//    public static void main(String[] args){
//        try{
//        Log l = new Log(new ProductManager());
//            System.out.println("user: "+l.user.getName());
//            System.out.println("start: "+Log.dtf.format(l.start));
//            System.out.println("test 2");
//            Thread.sleep(5000);
//            l.endLog();
//       System.out.println(l.toString());
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }
//    }
    
    private User user;
    private Duration duration = null;
    private LocalDateTime start, end = null;
    public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    public static final DateTimeFormatter durationf =DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final long serialVersionUID=2L;
    
    /*
    Getter and Setter
    */

    public String getUser() {
        return user.getName();
    }

    public String getDuration() {
        return String.format("%d:%02d%n", duration.toMinutes(), duration.minusMinutes(duration.toMinutes()).getSeconds());
    }

    public String getStart() {
        return dtf.format(start);
    }

    public String getEnd() {
        return dtf.format(end);
    }
    
    
    /**
     * CodeSnippet from Mkyong(2019)
     * https://www.mkyong.com/java/java-how-to-get-current-date-time-date-and-calender/
     * @param user 
     */
    public Log(User user){
    this.user= user;
    this.start = LocalDateTime.now();
    }
    
    public void endLog(){
    this.end=LocalDateTime.now();
    this.duration=Duration.between(start,end);
    }
    
    @Override
    public String toString(){
        /*
        to format duration: https://stackoverflow.com/questions/28675095/how-do-i-format-a-java-time-duration-mmss
        */
      String s = String.format("%d:%02d%n", duration.toMinutes(), duration.minusMinutes(duration.toMinutes()).getSeconds());
     return ("user: "+this.user.getName()+
                "\nstart: "+dtf.format(start)+
                "\nend: "+dtf.format(end))+
                "\nduration: "+s;
    }
}
