package practic;

import java.time.Duration;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//button[@class=\"_2KpZ6l _2doB4z\"]")).click();
		
		WebElement search = driver.findElement(By.xpath(".//input[@class=\"_3704LK\"]"));
		search.click();
		search.sendKeys("iphone 12");
		Thread.sleep(5000);
	    driver.findElement(By.xpath(".//button[@class=\"L0Z3Pu\"]")).click();
		String str = ("(.//a[@class=\"_1fQZEK\"])[1]");
		driver.findElement(By.xpath(str)).click();
		//String price = driver.findElement(By.xpath(".//div[text()='APPLE iPhone 12 (Black, 128 GB)']/ancestor::a[@class=\"_1fQZEK\"]//div[@class=\"_30jeq3 _1_WHN1\"]")).getText();
		//System.out.println("price: "+ price);
		Set<String>s=driver.getWindowHandles();
		Iterator<String> itr= s.iterator();
		itr.next();
		Thread.sleep(2000);
		String child_refid = itr.next();
		driver.switchTo().window(child_refid);
		Thread.sleep(2000);
		String childwindow = driver.getTitle();
		System.out.println("childname : "+childwindow);
		String price = driver.findElement(By.xpath(".//span[@class=\"B_NuCI\"]/ancestor::div[@class=\"aMaAEs\"]//div[@class=\"_30jeq3 _16Jk6d\"]")).getText();
		System.out.println("price: "+ price);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[name()='svg' and@class=\"_1KOMV2\"]")).click();
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		WebElement addcart = driver.findElement(By.xpath(".//div[@class=\"nZz3kj _1hNI6F\"]//button[text()='+']"));
		Thread.sleep(10000);
		//Actions a = new Actions(driver);
		//a.moveToElement(addcart).perform();
		//Thread.sleep(10000);
		//a.click().perform();
		//Thread.sleep(5000);
		//a.click().perform();
		addcart.click();
		Thread.sleep(10000);
		addcart.click();
		Thread.sleep(10000);
		
	    String price1 = driver.findElement(By.xpath(".//div[@class=\"Ob17DV _3X7Jj1\"]")).getText();
		System.out.println("price: "+price1);

	}

}
