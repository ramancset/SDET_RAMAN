package JDBC.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Annotation3 extends Annotation
{
	public static WebDriver driver;
	@Parameters("browser")
	@Test(groups = "regration")
	public void mainMethod5(String browser)
	{
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid input");
		}
		
		System.out.println("Main one method will execute");
	}
	
	@Test(groups = "regration")
	public void mainMethod6()
	{
		System.out.println("Main two method will execute");
	}

}
