package JDBC.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdatedTest 
{
	@Test
	public void ExecuteUpdatTest() throws Throwable
	{
		
		Connection con = null;
		try 
		{
			//step=1 Register the Driver
			Driver dref = new Driver();
			DriverManager.registerDriver(dref);
			//step=2 Connect to Database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
			//step=3 Create Statement
			Statement stmt = con.createStatement();
			//step=4 Execute Query
			int result = stmt.executeUpdate("insert into students_info(regno,firstname,middlename,lastname) values('5','ranjan','jha','h');");
			System.out.println(result);
			if(result==1)
			{
				System.out.println("Data is added");
			}
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		finally 
		{
			System.out.println("close connection");
			//Step=5 close connection with Database
			con.close();	
		}
			
	}
}
