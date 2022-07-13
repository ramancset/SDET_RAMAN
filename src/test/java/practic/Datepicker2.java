package practic;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Datepicker2 {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in");
	    driver.findElement(By.xpath(".//div[@class=\'nav-search-scope nav-sprite\']")).click();
	    Thread.sleep(5000);
	     String str = ".//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']";
		List<WebElement> list = driver.findElements(By.xpath(str));
		for(int i=0; i<list.size();i++)
		{
			String listname = list.get(i).getText();
			System.out.println("Name: "+listname);
			if(listname.equalsIgnoreCase("Books"))
			{
			   driver.findElement(By.xpath(".//option[text()='Books']")).click();
			   break;
				
			}
			else
			{
				continue;
			}
			
			
		}
		//driver.findElement(By.xpath(""))
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,500)");
		//WebElement ele = driver.findElement(By.xpath(".//option[text()='Books']"));
		
		//Select s = new Select(ele);
		//s.selectByValue("Books");		

	}

}
