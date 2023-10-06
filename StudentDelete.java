package jdbc_preparedstatement;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class StudentDelete {

	public static void main(String[] args) throws Exception
    {
	   
	   Scanner scanner = new Scanner(System.in);
	   
	   System.out.println("Enter the id: ");
	   int id  = scanner.nextInt();
	   
	   
	   String url ="jdbc:mysql://localhost:3306/studentdb?user=root&password=root";
	   String query = "DELETE FROM STUDENT WHERE ID =?";
	   Driver driver = new com.mysql.cj.jdbc.Driver();
	   DriverManager.registerDriver(driver);
	   
	   Connection connection = DriverManager.getConnection(url);
	  
	   PreparedStatement preparedStatement = connection.prepareStatement(query);
	    
	    preparedStatement.setInt(1, id);
	    
	    int result = preparedStatement.executeUpdate();
	    
	    if (result!=0)
	    {
		   System.out.println("Data deleted...");	
		} 
	    else 
	    {
	    	System.out.println("Data Not deleted.");

		}
	    
	    scanner.close();
	    
	    connection.close();
	    
	    
    }
}
