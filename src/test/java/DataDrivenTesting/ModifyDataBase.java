package DataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifyDataBase
{

	public static void main(String[] args) throws SQLException
	{
		//Step 1:Create an instance of JDBC Driver
				Driver dbDriver=new Driver();
				//Step 2:Register Driver
				DriverManager.registerDriver(dbDriver);
				//Step 3:Establish database connection
				Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3307/advsel","root","root");
				//Step 4:Create statement
				Statement statement=connection.createStatement();
				//Step 5:Execute query to update database
				int result=statement.executeUpdate("insert into employee(id, name, salary, phone)"+ " values(105,'HIJ',60000,'9876545678');");
				if(result==1)
				{
					System.out.println("Database updated successfully");
				}
				else
				{
					System.out.println("Database modification failed");
				}
				//Step 6:Close database connection
				connection.close();
	}

}
