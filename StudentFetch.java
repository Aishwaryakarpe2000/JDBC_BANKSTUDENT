package jdbc_preparedstatement;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentFetch {

	public static void main(String[] args) throws Exception 
	{
		  Scanner scanner = new Scanner(System.in);
		  
		  System.out.println("Enter the id:");
		  int id = scanner.nextInt();
		 
		   String url = "jdbc:mysql://localhost:3306/studentdb";
		   String user = "root";
		   String password = "root";
		   
		   // 1.Explicit registration of Driver class ( Driver class object up-cast into Driver interface)
		   Driver driver = new  com.mysql.cj.jdbc.Driver();
		   DriverManager.registerDriver(driver);
		
		   //2.Establish connection
		   Connection connection = DriverManager.getConnection(url, user, password);
		
		   // 3. Create statements
		   //PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM STUDENT"); // to all data
		
		   PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM STUDENT WHERE ID = ?");
		
		   preparedStatement.setInt(1, id);
		
		   // 4. Execute the statement
		   ResultSet resultSet= preparedStatement.executeQuery();
	     
		   while (resultSet.next())
		   {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString("name"));
			System.out.println(resultSet.getInt("marks"));
			System.out.println(resultSet.getLong("phone"));
			System.out.println(resultSet.getString("address"));
			System.out.println("----------------------------");
		   }
	     
		   // 5. Close the connection
		   scanner.close();
		   connection.close();
	  }
}
