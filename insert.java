package jdbcdemo;

import java.sql.*;
import java.util.*;
import java.io.*;
 
public class insert {
 
    public static void main(String[] args) throws IOException {
 
        String url = "jdbc:mysql://localhost:3306/demo";
        String user = "root";
        String password = "rootroot";
 
        Connection myConn = null;
        Statement myStmt = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter UserID:");
        int id=Integer.parseInt(in.readLine());
        System.out.println("Enter First Name:");
        String first=in.readLine();
        System.out.println("Enter LastName:");
        String last=in.readLine();
        System.out.println("Enter Age:");
        int age=Integer.parseInt(in.readLine());

 
        try {
            // 1. Get a connection to database
            //myConn = DriverManager.getConnection(url, user, password);
 
        	Properties props = new Properties();
			//props.load(new FileInputStream("demo.properties"));
		    props.load(new FileInputStream("/Users/amizhthan/Downloads/jdbc-properties-file/demo.properties"));

			// 2. Read the props
			String theUser = props.getProperty("user");
			String thePassword = props.getProperty("password");
			String theDburl = props.getProperty("dburl");
			
			System.out.println("Connecting to database...");
			System.out.println("Database URL: " + theDburl);
			System.out.println("User: " + theUser);
			
			// 3. Get a connection to database
			myConn = DriverManager.getConnection(theDburl, theUser, thePassword);

			System.out.println("\nConnection successful!\n");
            // 2. Create a statement
            myStmt = myConn.createStatement();
 
            // 3. Execute SQL query
            String sql = "insert into REGISTRATION1 Values ('"+id+"', '"+first+"','"+last+"','"+age+"' )";
 
            myStmt.executeUpdate(sql);
 
            System.out.println("Insert complete.");
        } catch (Exception exc) {
            exc.printStackTrace();
        } /*finally {
            if (myStmt != null) {
                myStmt.close();
            }
 
            if (myConn != null) {
                myConn.close();
            }
        }*/
    }
}