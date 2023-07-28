
package deo;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Category;
import java.sql.*;

/**
 *
 * @author Veni
 */
public class CategoryDao {
    public static void save(Category category){
    String query = "insert into category (name) values('"+category.getName()+"')";
    DbOperations.setDataOrDelete(query,"<html><b style =\"color:blue\">Category Added Successfully</b></html>");
            }
    
    public static ArrayList<Category> getAllRecords(){
        ArrayList<Category> arrayList = new ArrayList<>();
        try{
        ResultSet rs = DbOperations.getData("select *from category");
        while(rs.next()){
            Category category = new Category();
            category.setId(rs.getInt("Id"));
            category.setName(rs.getString("name"));
            arrayList.add(category);
        }
                }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static void delete(String id){
        String query = "delete from category where id='"+id+"'";
        DbOperations.setDataOrDelete(query, "<html><b style = \"color:blue\">Category Delete Successfully</b></html>");
    }
}
