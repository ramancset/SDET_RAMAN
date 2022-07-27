package JDBC.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(ListenerClass.class)
public class listenerMainClass 
{

	public static WebDriver driver;
	@BeforeMethod
	public void webClass()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	@AfterMethod
	public void closeTestMethod() throws Throwable
	{
		driver.close();
		Thread.sleep(5000);
	}
	@Test
	public void listenerTest1() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("http://localhost:8888");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//input[@name=\"user_name\"]")).sendKeys("admin");
		
		Thread.sleep(5000);
		WebElement password = driver.findElement(By.xpath(".//input[@name=\"user_password\"]"));
		//password.click();
		password.sendKeys("admin");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//input[@id=\"submitButton\"]")).click();
		String ActualURL = driver.getCurrentUrl();
		Thread.sleep(5000);
		String ExpectedURL="http://localhost:8888/index.php?action=index&module=Home";
		Assert.assertEquals(ActualURL, ExpectedURL);
		Thread.sleep(5000);
		
		
	}
	
	@Test
	public void listenerTest2() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.actitime.com/login.do");
		Thread.sleep(5000);
		driver.findElement(By.id("username")).sendKeys("admin");
		Thread.sleep(5000);
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath(".//a[@id=\"loginButton\"]")).click();
		Assert.assertTrue(false);
	}
	

}
