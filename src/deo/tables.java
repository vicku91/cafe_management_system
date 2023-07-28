/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deo;

import javax.swing.JOptionPane;

public class tables {

    public static void main(String[] args) {
        try {
            String userTable = "create table user(Id int AUTO_INCREMENT Primary key , name varchar(200), email varchar(200), mobilenumber varchar(10), address varchar(300), password varchar(100), securityquestion varchar(200), answer varchar(200), status varchar(20), UNIQUE (email))";
//            String adminDetails = "insert into user(name,email,mobilenumber,address,password,securityquestion,answer,status) values('Admin','veni2201@gmail.com','7024282367','India','wify','what is nick name','RK','true')";
//            String categoryTable = "create table category(id int AUTO_INCREMENT primary key,name varchar(200))";
//            String productTable = "create table product(id int AUTO_INCREMENT primary key,name varchar(200),category varchar(200),price varchar(200))";
//            String billTable = "create table bill(id int primary key,name varchar(200),mobileNumber varchar(200),email varchar(200),date varchar(50),total varchar(200),createdBy varchar(200))";
            DbOperations.setDataOrDelete(userTable, "User Table Created Successfully");
//            DbOperations.setDataOrDelete(adminDetails, "Admin Details Added Successfully");
//            DbOperations.setDataOrDelete(categoryTable, "<html><b style=\"color:blue\">Category Table Created Successfully</b></html>");
//            DbOperations.setDataOrDelete(productTable, "<html><b style=\"color:blue\">Product Table Created Successfully</b></html>");
//            DbOperations.setDataOrDelete(billTable, "<html><b style=\"color:blue\">Bill Table Created Successfully</b></html>");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
