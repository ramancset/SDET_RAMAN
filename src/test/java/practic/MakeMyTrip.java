package practic;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip
{
	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable.popup.blocking"));
		
		
		
		WebDriver driver = new ChromeDriver(opt);
		
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().frame("notification-frame-~19713b227");
		driver.findElement(By.xpath("//a[@class='close']")).click();

		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//span[@class=\"langCardClose\"]")).click();
		Thread.sleep(2000);
		 WebElement city = driver.findElement(By.id("fromCity"));
		 city.click();
		 Thread.sleep(3000);
		 city.sendKeys("mumbai");
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("(.//div[@class=\"calc60\"])[1]")).click();
		 
		 WebElement cityTo = driver.findElement(By.id("toCity"));	
		 cityTo.click();
		 Thread.sleep(3000);
		 cityTo.sendKeys("bengaluru");
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("(.//div[@class=\"calc60\"])[1]")).click();
		 
		 WebElement Date = driver.findElement(By.xpath(".//p[@data-cy=\"departureDate\"]"));
		 Date.click();
		 String selecteddate = "Fri Jul 15 2022";
		 driver.findElement(By.xpath(".//div[@class=\"DayPicker-Months\"]/div[1]//div[@class=\"DayPicker-Body\"]/div[3]//div[@aria-label='"+selecteddate+"']")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath(".//a[text()='Search']")).click();
		
		
	}

}
