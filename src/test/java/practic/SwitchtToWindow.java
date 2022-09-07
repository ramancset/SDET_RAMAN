package practic;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchtToWindow
{
	@Test
	public void ebay()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ebay.com/sch/i.html?_from=R40&_trksid=p2380057.m570.l1313&_nkw=iphone&_sacat=0");
		List<WebElement> list = driver.findElements(By.xpath("//h3[@class='s-item__title']"));
		int size = list.size();
		System.out.println(size);
		for( WebElement str : list)
		{
			String str1 = str.getText();
			System.out.println(str1);
		}
		
	}
} 


