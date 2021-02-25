package nw.proj;
import java.sql.*;
import java.io.*;
import org.ini4j.*;


public class App 
{
    public static void main( String[] args ) throws IOException
    {
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


    	
    	try{
            Wini ini = new Wini(new File("/Users/amizhthan/Desktop/myinifile.ini"));
            String uname = ini.get("owner", "username");
            String pass = ini.get("owner", "password");
            String url = ini.get("database", "url");
            
            myConn = DriverManager.getConnection(url, uname, pass);

			System.out.println("\nConnection successful!\n");
			myStmt = myConn.createStatement();
			 
        
            String sql = "insert into REGISTRATION1 Values ('"+id+"', '"+first+"','"+last+"','"+age+"' )";
 
            myStmt.executeUpdate(sql);
 
            System.out.println("Insert complete.");


 
        }catch (Exception exc) {
            exc.printStackTrace();

        }


    }
}
