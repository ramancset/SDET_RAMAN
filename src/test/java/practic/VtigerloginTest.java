package practic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerloginTest 
{
	@Test
	public void login() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		driver.findElement(By.xpath(".//input[@name=\"user_name\"]")).sendKeys("admin");
		driver.findElement(By.xpath(".//input[@name=\"user_password\"]")).sendKeys("admin");
		driver.findElement(By.xpath(".//input[@id=\"submitButton\"]")).click();
		Thread.sleep(5000);
		driver.quit();
		driver.get("http://localhost:8888");
		
	}

}
