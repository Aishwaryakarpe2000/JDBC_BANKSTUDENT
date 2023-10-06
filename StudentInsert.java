package jdbc_preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import com.mysql.cj.jdbc.Driver;

public class StudentInsert {

	public static void main(String[] args) throws Exception 
    {
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Enter the id");
    	int id = scanner.nextInt();
    	
    	System.out.println("Enter the sname");
    	String name = scanner.next();
    	
    	System.out.println("Enter the marks");
    	int marks = scanner.nextInt();
    	
    	System.out.println("Enter the phone");
    	long phone = scanner.nextLong();
    	
    	System.out.println("Enter the Address");
    	String address = scanner.next();
    	
    	String url = "jdbc:mysql://localhost:3306/studentdb?user=root&password=root";
    	String query = "INSERT INTO STUDENT VALUES (?,?,?,?,?)";
    	
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
        preparedStatement.setString(2, name);
        preparedStatement.setInt(3, marks);
        preparedStatement.setLong(4, phone);
        preparedStatement.setString(5, address);
        
       
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
