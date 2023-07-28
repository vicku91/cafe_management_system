/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Veni
 */
public class openPDF {
    public static void openById(String id){
        try{
            if((new File("D:\\"+id+".pdf")).exists()){
                String cmdarray = null;
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler D:\\"+id+".pdf");
            }
            else
                JOptionPane.showMessageDialog(null,"<html><b style =\"color:red\">Fill is not Exists</b></html>");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
