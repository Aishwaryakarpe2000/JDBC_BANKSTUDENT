package jdbc_preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class BankInsert {

	public static void main(String[] args) throws Exception 
    {
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Enter the id");
    	int id = scanner.nextInt();
    	
    	System.out.println("Enter the bname");
    	String bname = scanner.next();
    	
    	System.out.println("Enter the city");
    	String city = scanner.next();
    	
    	System.out.println("Enter the state");
    	 String state= scanner.next();
    	
    	System.out.println("Enter the Branch");
    	String branch = scanner.next();
    	
    	String url = "jdbc:mysql://localhost:3306/bankdb?user=root&password=root";
    	String query = "INSERT INTO BANK VALUES (?,?,?,?,?)";
    	
    	// place holder  --- ?
    	// to assign value to place holder use set() methods
		// 1.Load or Register the Driver
    	// Explicit registration of Driver Class
    	Driver driver = new Driver();    	
        DriverManager.registerDriver(driver);
        
        // 2. Establish connection
        Connection connection =DriverManager.getConnection(url);
        
        // 3. Create statements
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        
        //set() methods for place holder
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, bname);
        preparedStatement.setString(3, city);
        preparedStatement.setString(4, state);
        preparedStatement.setString(5, branch);
        
       
      // 4. Execute the statements or Process the result
        
      int result = preparedStatement.executeUpdate();
      
      if (result!=0)
      {
		System.out.println("Data Inserted Successfully...");
      } 
      else
      {
         System.out.println("Faild to insert Data. ");
	  }
    	
      // 5. Close the Connection
      scanner.close();
      connection.close();
    	
	}
}
