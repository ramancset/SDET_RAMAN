package practic;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ComplexSVGGraph {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://emicalculator.net/");
		String graphXpath = "//*[local-name()='svg']//*[name()='g' and @class=\"highcharts-series-group\"]//*[name()='rect']";
		String textXpath = "//*[local-name()='svg']//*[name()='g' and @class=\"highcharts-label highcharts-tooltip highcharts-color-undefined\"]//*[name()='text']";
		List<WebElement> barlist = driver.findElements(By.xpath(graphXpath));
		int no = barlist.size();
		System.out.println("no bar:"+no);
		Actions act = new Actions(driver);
		for(WebElement e : barlist)
		{
			act.moveToElement(e).perform();
			Thread.sleep(500);
			String text = driver.findElement(By.xpath(textXpath)).getText();
			System.out.println(text);
			
		
		}
		
		

	}

}
