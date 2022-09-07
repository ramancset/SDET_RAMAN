package practic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CricketBug 
{
	  WebDriver driver;
	@Test
	public  void DynamicXpath()
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cricbuzz.com/");
		driver.findElement(By.xpath(".//ul[@class=\"cb-col cb-col-100 videos-carousal-wrapper\"]/li[1]/a/div/div//div[@class=\" cb-ovr-flo cb-text-complete\"]")).click();
		driver.findElement(By.xpath(".//a[text()='Scorecard']")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
		
	}
	@Test
	public  void getliveScore()
	{
		int rowCount = driver.findElements(By.xpath(".//div[@id=\"innings_1\"]/div[1]/div")).size();
		System.out.println(rowCount);
		int colCount = driver.findElements(By.xpath(".//div[@id=\"innings_1\"]/div[1]/div[2]/div")).size();
		System.out.println(colCount);
		for(int row=1;row<rowCount-3; row++)
		{
			for(int col =1; col<=colCount; col++)
			{
				String actual = driver.findElement(By.xpath(".//div[@id=\"innings_1\"]/div[1]/div["+(row+1)+"]/div["+(col)+"]")).getText();
				if(actual.equals("c Pooran b Obed McCoy"))
				{
					System.out.println(row+" : "+col);
				}
				
			}
		}
		
	}
	
	

}
