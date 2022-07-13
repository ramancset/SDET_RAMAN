package practic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//button[@class=\"_2KpZ6l _2doB4z\"]")).click();
		//Thread.sleep(1000);
		driver.findElement(By.xpath(".//div[@class=\"xtXmba\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//input[@tabindex=\"01\"]")).sendKeys("Mumbai, BOM - Chatrapati Shivaji International Airport");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//input[@tabindex=\"02\"]")).sendKeys("Hyderabad, HYD - Rajiv Gandhi International Airport");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//input[@class=\"_1w3ZZo _2gKfhi _2mFmU7\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//div[@class=\"PgmDJX\"]/table[1]/tbody/tr[4]/td[4]")).click();
		
	}

}
