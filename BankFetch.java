package jdbc_preparedstatement;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BankFetch {

	public static void main(String[] args) throws Exception 
	{
		  Scanner scanner = new Scanner(System.in);
		  
		  System.out.println("Enter the id:");
		  int id = scanner.nextInt();
		 
		   String url = "jdbc:mysql://localhost:3306/bankdb";
		   String user = "root";
		   String password = "root";
		   
		   // 1.Explicit registration of Driver class ( Driver class object up-cast into Driver interface)
		   Driver driver = new  com.mysql.cj.jdbc.Driver();
		   DriverManager.registerDriver(driver);
		
		   //2.Establish connection
		   Connection connection = DriverManager.getConnection(url, user, password);
		
		   // 3. Create statements
		   //PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM STUDENT"); // to all data
		
		   PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM BANK WHERE ID = ?");
		
		   preparedStatement.setInt(1, id);
		
		   // 4. Execute the statement
		   ResultSet resultSet= preparedStatement.executeQuery();
	     
		   while (resultSet.next())
		   {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString("bname"));
			System.out.println(resultSet.getString("city"));
			System.out.println(resultSet.getString("state"));
			System.out.println(resultSet.getString("branch"));
			System.out.println("----------------------------");
		   }
	     
		   // 5. Close the connection
		   scanner.close();
		   connection.close();
	  }
}
