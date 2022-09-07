package practic;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.devtools.v85.css.model.CSSStyleSheetHeader;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TimePassClass 
{
	@Test
	public void timePassMethod() throws Throwable
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in");
		//WebElement xpath1 = driver.findElement(By.xpath(".//input[@aria-label=\"Search\"]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("document.getElementsByName('field-keywords')[0].value='iphone 12'");
		js.executeScript("document.getElementsByClassName('nav-input nav-progressive-attribute')[0].value='iphone 12'");
		//js.executeScript("arguments[0].value='iphone 12'",xpath1);
		Thread.sleep(5000);
		String parent = driver.getWindowHandle();
	
		WebElement click = driver.findElement(By.id("nav-search-submit-button"));
		Actions a = new Actions(driver);
		a.moveToElement(click).click().build().perform();
		
		//click.click();
		//driver.quit();
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://demo.actitime.com/login.do");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//a[text()='actiTIME Inc.']")).click();
		Thread.sleep(5000);
		Set<String> ref = driver.getWindowHandles();
		Iterator<String>itr = ref.iterator();
		String child1 = itr.next();
		String child_ref = itr.next();
		driver.switchTo().window(child_ref);
		Thread.sleep(5000);
		String child_tittle = driver.getTitle();
		System.out.println(child_tittle);
		Thread.sleep(5000);
		FileInputStream s = new FileInputStream("../SDET_RAM/src/test/java/text1.PROPERTIES");
		Properties p = new Properties();
		p.load(s);
		Thread.sleep(5000);
		String username = p.getProperty("username");
		
		driver.findElement(By.xpath(".//input[@id=\"username\"]")).sendKeys(username);
		Thread.sleep(5000);
		String password = p.getProperty("password");
		driver.findElement(By.xpath(".//input[@type=\"password\"]")).sendKeys(password);
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//div[text()='Login ']")).click();
		Thread.sleep(5000);
		driver.switchTo().window(parent);
		Thread.sleep(5000);
		WebElement xpath1 = driver.findElement(By.xpath(".//input[@aria-label=\"Search\"]"));
		xpath1.clear();
		Thread.sleep(5000);
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("APPLE iPhone 12 (Black, 128 GB)");
		Thread.sleep(5000);
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(5000);
		WebElement iphonename = driver.findElement(By.xpath(".//span[text()='Apple iPhone 12 Mini (128GB) - Black']"));
		 iphonename.click();
		 //Actions a = new Actions(driver1);
		 //a.moveToElement(iphonename).contextClick().perform();
		 Thread.sleep(5000);
		Set<String>s1=driver.getWindowHandles();
		Iterator<String> itr1= s1.iterator();
		String parent2=	itr1.next();
		String child_refid1 = itr1.next();
		Thread.sleep(2000);	
		driver.switchTo().window(child_refid1);
		Thread.sleep(2000);
		String childwindow1 = driver.getTitle();
		System.out.println("childname : "+childwindow1);
		//String priceamoz = driver1.findElement(By.xpath(".//span[@class=\"a-size-large product-title-word-break\"]/ancestor::div[@class=\"centerColAlign centerColAlign-bbcxoverride\"]//span[@class=\"a-offscreen"]")).getText();
		//String stramoz = priceamoz.substring(1);
		Thread.sleep(2000);
		String priceamoz = driver.findElement(By.xpath(".//h1[@class='a-size-large a-spacing-none']/ancestor::div[@class='centerColAlign centerColAlign-bbcxoverride']//span[@class='a-price-whole']")).getText();
		String stramoz1 = priceamoz.replaceAll(",", "");
		String stramoz2 = stramoz1.substring(1);
		Thread.sleep(2000);
		int value1 = Integer.parseInt(stramoz2);
		System.out.println("Price: "+ value1);
		Thread.sleep(5000);
		driver.quit();
		
		driver.switchTo().window(child1);
		Thread.sleep(5000);
//		FileInputStream s = new FileInputStream("../SDET_RAM/src/test/java/text1.PROPERTIES");
//		Properties p = new Properties();
//		p.load(s);
//		Thread.sleep(5000);
//		String username = p.getProperty("username");
//		
//		driver.findElement(By.xpath(".//input[@id=\"username\"]")).sendKeys(username);
//		Thread.sleep(5000);
//		String password = p.getProperty("password");
//		driver.findElement(By.xpath(".//input[@id=\"password\"]")).sendKeys(password);
//		Thread.sleep(5000);
//		driver.findElement(By.xpath(".//div[text()='Login ']")).click();
		
	}
	

}
