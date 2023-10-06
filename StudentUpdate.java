package jdbc_preparedstatement;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentUpdate {

	public static void main(String[] args) throws Exception
    {
	   
	   Scanner scanner = new Scanner(System.in);
	   
	   System.out.println("Enter the id: ");
	   int id  = scanner.nextInt();
	   
	   System.out.println("Enter the NAME: ");
	   String name  = scanner.next();
	   
	   System.out.println("Enter the marks: ");
	   int marks  = scanner.nextInt();
	   
	   System.out.println("Enter the phone: ");
	   long phone  = scanner.nextLong();
	   
	   System.out.println("Enter the address: ");
	   String address  = scanner.next();
	   
	   String url ="jdbc:mysql://localhost:3306/studentdb?user=root&password=root";
	   String query = "UPDATE STUDENT SET NAME = ?, MARKS = ? , PHONE =?, ADDRESS = ?  WHERE ID =? ";
	  
	   //1.load and register the driver
	   Driver driver = new com.mysql.cj.jdbc.Driver();
	   DriverManager.registerDriver(driver);
	   
	   //2.establish the connection
	   Connection connection = DriverManager.getConnection(url);
	  
	   //3.create statement
	    PreparedStatement preparedStatement = connection.prepareStatement(query);
	    
	    preparedStatement.setString(1, name);
	    preparedStatement.setInt(2, marks);
	    preparedStatement.setLong(3, phone);
	    preparedStatement.setString(4, address);
	    preparedStatement.setInt(5, id);
	    
	    
	    int result = preparedStatement.executeUpdate();
	    
	    if (result!=0)
	    {
		   System.out.println("Data Updated...");	
		} 
	    else 
	    {
	    	System.out.println("Data Not Updated.");

		}
	    
	    scanner.close();
	    
	    connection.close();
	    
	    
    }
}
