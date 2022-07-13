package JDBC.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteQuerryTest 
{
	@Test
	public void executeQueryTest() throws SQLException
	{
		
		Connection con = null;
		try {
			//step=1 Register the Driver
			Driver dref = new Driver();
			DriverManager.registerDriver(dref);
			//step=2 Connect to Database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
			
			//step=3 Create Statement
			Statement stmt = con.createStatement();
			
			//step=4 Execute Query
			ResultSet result = stmt.executeQuery("select * from students_info where firstname='Raman';");
			while(result.next())
			{
				System.out.println(result.getString(1)+""+result.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			System.out.println("close connection");
			//Step=5 close connection with Database
			con.close();
			
		}
		
	}

}
