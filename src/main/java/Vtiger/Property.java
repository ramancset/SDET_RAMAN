package Vtiger;

import java.io.FileInputStream;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Property {
	public static WebDriver driver;
	
	

	public static void fileinput() throws Throwable 
	{
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("../SDET_RAM/src/test/java/text1.txt");
		Properties p= new Properties();
		p.load(fis);
		String url1=p.getProperty("url");
		String browser1=p.getProperty("browser");
		
		if(browser1.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
			 
		}
		else if (browser1.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get(url1);
		String userName1= p.getProperty("username");
		driver.findElement(By.xpath(".//input[@name=\"user_name\"]")).sendKeys(userName1);
		
		Thread.sleep(5000);
		WebElement password = driver.findElement(By.xpath(".//input[@name=\"user_password\"]"));
		//password.click();
		String password1= p.getProperty("password");
		password.sendKeys(password1);
		driver.findElement(By.xpath(".//input[@id=\"submitButton\"]")).click();

	}

}
