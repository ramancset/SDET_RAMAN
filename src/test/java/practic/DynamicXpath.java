package practic;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicXpath
{
	@Test
	public void name() throws Throwable
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.google.co.in/");
		
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("seleni");
		Thread.sleep(5000);
		
		WebElement dynamicXpath = driver.findElement(By.xpath(".//div[@class=\"OBMEnb\"]/ul//div[@class=\"pcTkSc\"]/div/span[text()='selenium']/b[text()=' download']"));
		
		dynamicXpath.click();
	}

}