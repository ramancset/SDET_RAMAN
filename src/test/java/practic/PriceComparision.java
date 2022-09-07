package practic;

import java.time.Duration;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PriceComparision {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
				driver.get("https://www.flipkart.com/");
				Thread.sleep(2000);
				driver.findElement(By.xpath(".//button[@class=\"_2KpZ6l _2doB4z\"]")).click();
		
				WebElement search = driver.findElement(By.xpath(".//input[@class=\"_3704LK\"]"));
				search.click();
				search.sendKeys("APPLE iPhone 12 (Black, 128 GB)");
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
				String str1 = price.substring(1);
				String str2 = str1.replaceAll(",", "");
				Thread.sleep(2000);
				int value = Integer.parseInt(str2);
				System.out.println("Price: "+ value);
				//Thread.sleep(5000);
				//driver.close();
				Thread.sleep(10000);
		WebDriver driver1 = driver.switchTo().newWindow(WindowType.WINDOW);
		driver1.get("https://www.amazon.in");
		Thread.sleep(5000);
		driver1.findElement(By.id("twotabsearchtextbox")).sendKeys("APPLE iPhone 12 (Black, 128 GB)");
		Thread.sleep(5000);
		driver1.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(5000);
		WebElement iphonename = driver1.findElement(By.xpath(".//span[text()='Apple iPhone 12 (128GB) - Black']"));
		 iphonename.click();
		 //Actions a = new Actions(driver1);
		 //a.moveToElement(iphonename).contextClick().perform();
		 Thread.sleep(5000);
		Set<String>s1=driver1.getWindowHandles();
		Iterator<String> itr1= s1.iterator();
		String parent=	itr1.next();
		String child_refid1 = itr1.next();
		Thread.sleep(2000);	
		driver1.switchTo().window(child_refid1);
		Thread.sleep(2000);
		String childwindow1 = driver1.getTitle();
		System.out.println("childname : "+childwindow1);
		//String priceamoz = driver1.findElement(By.xpath(".//span[@class=\"a-size-large product-title-word-break\"]/ancestor::div[@class=\"centerColAlign centerColAlign-bbcxoverride\"]//span[@class=\"a-offscreen"]")).getText();
		//String stramoz = priceamoz.substring(1);
		Thread.sleep(2000);
		String priceamoz = driver1.findElement(By.xpath(".//h1[@class='a-size-large a-spacing-none']/ancestor::div[@class='centerColAlign centerColAlign-bbcxoverride']//span[@class='a-price-whole']")).getText();
		String stramoz1 = priceamoz.replaceAll(",", "");
		String stramoz2 = stramoz1.substring(1);
		Thread.sleep(2000);
		int value1 = Integer.parseInt(stramoz2);
		System.out.println("Price: "+ value1);
		if(value>value1)
		{
			System.out.println("Mobile price of Flipkart is high");
		}
		else
		{
			System.out.println("Mobile price of amazon is high");
		}
		


	}

}
