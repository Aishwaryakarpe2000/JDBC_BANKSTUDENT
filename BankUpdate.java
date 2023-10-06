package jdbc_preparedstatement;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BankUpdate {

	public static void main(String[] args) throws Exception
    {
	   
	   Scanner scanner = new Scanner(System.in);
	   
	   System.out.println("Enter the id: ");
	   int id  = scanner.nextInt();
	   
	   System.out.println("Enter the BNAME: ");
	   String bname  = scanner.next();
	   
	   System.out.println("Enter the city: ");
	   String city  = scanner.next();
	   
	   System.out.println("Enter the state: ");
	   String state = scanner.next();
	   
	   System.out.println("Enter the Branch: ");
	   String branch = scanner.next();
	   
	   String url ="jdbc:mysql://localhost:3306/bankdb?user=root&password=root";
	   String query = "UPDATE BANK SET BNAME = ?, city = ? , state =?, branch = ?  WHERE ID =? ";
	  
	   //1.load and register the driver
	   Driver driver = new com.mysql.cj.jdbc.Driver();
	   DriverManager.registerDriver(driver);
	   
	   //2.establish the connection
	   Connection connection = DriverManager.getConnection(url);
	  
	   //3.create statement
	    PreparedStatement preparedStatement = connection.prepareStatement(query);
	    
	    preparedStatement.setString(1, bname);
	    preparedStatement.setString(2, city);
	    preparedStatement.setString(3, state);
	    preparedStatement.setString(4, branch);
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
