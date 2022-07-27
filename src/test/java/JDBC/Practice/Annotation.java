package JDBC.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Annotation
{
	
	@BeforeSuite(groups = {"regration","smoke"})
	public void suite()
	{
		System.out.println("Before sute will execute");
	}
	
	@BeforeTest(groups = {"regration","smoke"})
	public void test()
	{
		System.out.println("Before test will execute");
	}
	@Parameters("username")
	@BeforeClass(groups = {"regration","smoke"})
	public void class1(String username)
	{
		System.out.println(username);
		System.out.println("Before class will execute");
	}
	
	@BeforeMethod(groups = {"regration","smoke"})
	public void method1()
	{
		System.out.println("Before method will execute");
	}
	@AfterMethod(groups = {"regration","smoke"})
	public void method2()
	{
		System.out.println("After method will execute");
	}
	
	@AfterClass(groups = {"regration","smoke"})
	public void class2()
	{
		System.out.println("After class will execute");
	}
	
	@AfterTest(groups = {"regration","smoke"})
	public void test2()
	{
		System.out.println("After test will execute");
	}
	
	@AfterSuite(groups = {"regration","smoke"})
	public void suite2()
	{
		System.out.println("After suite will execute");
	}
	

}
