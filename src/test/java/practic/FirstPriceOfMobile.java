package practic;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstPriceOfMobile {

	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/?tag=admpdesktopin-21&ref=pd_sl_aA3AA585448E9A346A378CBAAF&mfadid=adm");
		Thread.sleep(2000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile under 20000");
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//span[text()='OnePlus']")).click();
		Thread.sleep(2000);
		String str = "(.//div[@class=\"s-matching-dir sg-col-16-of-20 sg-col sg-col-8-of-12 sg-col-12-of-16\"]//span[contains(text(),'OnePlus ')])[1]";
		Thread.sleep(5000);
		String ref = driver.findElement(By.xpath(str)).getText();
		System.out.println("name: " + ref);
		Thread.sleep(2000);
		String price = driver.findElement(By.xpath("(.//span[@class=\"a-size-medium a-color-base a-text-normal\"])[1]/ancestor::div[@class=\"a-section a-spacing-small a-spacing-top-small\"]//span[@class=\"a-price\"]")).getText();
		Thread.sleep(2000);
		String str1 = price.substring(1);
		String str2 = str1.replaceAll(",", "");
		Thread.sleep(2000);
		int value = Integer.parseInt(str2);
		System.out.println("Price: "+ value);
		if(value>20000)
		{
			System.out.println("Script is correct");
		}
		else
		{
			System.out.println("Script is  not correct");
		}
			
		

	}

}
