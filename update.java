package jdbcdemo;

import java.io.*;
import java.sql.*;
import java.util.*;
public class update {
 
    public static void main(String[] args) throws IOException {
 
        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String password = "rootroot";
 
        Connection myConn = null;
        Statement myStmt = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Id no to be update:");
        int uid=Integer.parseInt(in.readLine());
        System.out.println("Enter updated email Id");
        String str=in.readLine();
  
 
        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection(url, user, password);
 
        
            myStmt = myConn.createStatement();
            String sql = "update employees set email='"+str+"' where id='"+uid+"'";
 
            int rowsAffected = myStmt.executeUpdate(sql);
 
            System.out.println("Rows affected: " + rowsAffected);
            System.out.println("Update complete.");
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
       /* finally {
            if (myStmt != null) {
                myStmt.close();
            }
 
            if (myConn != null) {
                myConn.close();
            }
        }*/
    }
}