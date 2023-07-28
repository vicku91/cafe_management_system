
package deo;
import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
import java.util.ArrayList;
public class UserDao {
    public static void save(User user){
         JOptionPane.showMessageDialog(null, "live he");
        String Query ="insert into user(name,email, mobileNumber, address, password, securityQuestion, answer, status) values('"+user.getName()+"','"+user.getEmail()+"','"+user.getMobileNumber()+"','"+user.getAddress()+"','"+user.getPassword()+"','"+user.getSecurityQuestion()+"','"+user.getAnswer()+"','false')";
      DbOperations.setDataOrDelete(Query, "Registured Successfully wait for Admin Approval !");
    }  
    
    public static User login(String email, String password){
        User user = null;
        try{
           ResultSet rs = DbOperations.getData("Select *from user where email='"+email+"' and password='"+password+"';");
           while(rs.next()){
               user = new User();
               user.setStatus(rs.getString("status"));
           }
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
        return user;
    }
    
    public static User getSecurityQuestion(String email){
        User user = null;
        try{
            ResultSet rs = DbOperations.getData("select *from user where email = '"+email+"'");
            while(rs.next())
            {
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return user;
    }
    
    public static void update(String email,String newPassword){
        String query = "update user set password ='"+newPassword+"' where email = '"+email+"';";
        DbOperations.setDataOrDelete(query, "<html><b style=\" color:blue \">Password Changed Successfully</b></html>");
    }
    
    public static ArrayList<User> getAllRecorrds(String email){
        ArrayList<User> arrayList =new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select *from user where email like'%"+email+"%'");
            while (rs.next()){
                User user =new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setMobileNumber(rs.getString("mobileNumber"));
                user.setAddress(rs.getString("address"));
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setStatus(rs.getString("status"));
                arrayList.add(user);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static void changestatus(String email, String status){
        String query = "update user set status='"+status+"' where email='"+email+"'";
        DbOperations.setDataOrDelete(query, "<html><b style =\"color:green\">Status Change Successfully</b></html>");
    }
    
    public static void changePassword(String email,String oldPassword, String newPassword){
        try{
            ResultSet rs =DbOperations.getData("select *from user where email='"+email+"' and password='"+oldPassword+"'");
            if(rs.next()){
                update(email,newPassword);
            }
            else{
                    JOptionPane.showMessageDialog(null, "<html><b style=\" color:red \">Old password is wrong</b></html>");
                    }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void changeSecurityQuestion(String email, String password, String securityQuestion, String answer){
        try{
            ResultSet rs = DbOperations.getData("select *from user where email='"+email+"' and password='"+password+"'");
            if(rs.next()){
                update(email, securityQuestion, answer);
            }
            else{
                JOptionPane.showMessageDialog(null, "<html><b style=\" color:red \">Password is Wrong</b></html>");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void update(String email, String securityQuesttion, String answer){
        String query= "update user set securityQuestion='"+securityQuesttion+"',answer='"+answer+"' where email='"+email+"'";
        DbOperations.setDataOrDelete(query,"<html><b style =\"color:blue\">Security Question Change Successfully</b></html>");
    }
}
