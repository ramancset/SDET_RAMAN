package Vtiger;

import java.io.File;



import java.io.IOException;
import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.PageObjectMode.HomePage;
import com.PageObjectMode.LoginPage;
import com.google.common.io.Files;
import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
	public static WebDriver sdriver;
	public WebDriver driver;
	PropertyFile prop = PropertyFile.getObjectPropfile();
	Connection con=null;
	WebDriverUtil util;
	@BeforeSuite
	public void dataBaseConnection() throws Throwable
	{
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		Statement stmt = con.createStatement();
		ResultSet result = stmt.executeQuery("select * from students_info;");
		while(result.next())
		{
			System.out.println("data base connected");
		}


	}
	@BeforeClass
	public void beforeClass() throws Throwable
	{
		String BROWSER = prop.readDatafromPropfile("browser");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid input");
		}
		sdriver=driver;
		util = new WebDriverUtil(driver);
	}
	@BeforeMethod
	public void beforeMethod() throws Throwable
	{

		driver.get(prop.readDatafromPropfile("url"));
		Thread.sleep(2000);

		LoginPage loginpage= new LoginPage(driver);
		loginpage.getUsernametextbox().sendKeys(prop.readDatafromPropfile("username"));
		Thread.sleep(5000);
		loginpage.getPasswordtextbox().sendKeys(prop.readDatafromPropfile("password"));
		loginpage.getLoginbutton().click();

	}

	@AfterMethod
	public void afterMethod() throws Throwable
	{	
		util = new WebDriverUtil(driver);
		HomePage page = new HomePage(driver);
		Thread.sleep(3000);
		util.movelement(page.getSignoutimg());
		Thread.sleep(2000);
		util.movelement(page.getSignoutlink());

	}

	@AfterClass
	public void closeBrowser() throws InterruptedException{
				Thread.sleep(3000);
			    driver.quit();
	}
	@AfterSuite
	public void afterSute()
	{		
		System.out.println("close connection");	

	}
	public static String takeScreenshot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = IAutoconsts.screenshotpath+name+".png";
		File dest = new File(path);
		Files.copy(src, dest);
		return path;
	}


	//	public static String takeScreenShot(String name) throws IOException
	//	{
	//		TakesScreenshot shot =(TakesScreenshot)BaseClass.sdriver;
	//		File file = shot.getScreenshotAs(OutputType.FILE);
	//		String screenshot = "../SDET_RAM/screnshot/"+name+".png";
	//		File f1= new File(screenshot);
	//		FileUtils.copyFile(file, f1);
	//		
	//		return screenshot;
	//	}
}
