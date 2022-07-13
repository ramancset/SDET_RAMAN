package practic;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IccCricket {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.icc-cricket.com");
		Thread.sleep(5000);
		WebElement ranking = driver.findElement(By.xpath("(.//div[@class=\"global-navigation__link\"])[5]"));
		Thread.sleep(5000);
		ranking.click ();
		WebElement overview = driver.findElement(By.xpath("(//a[text()='Overview'])[1]"));
		Thread.sleep(5000);
		overview.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)");
		driver.findElement(By.xpath(".//a[text()='View Full Table']")).click();
		
		List<WebElement> str = driver.findElements(By.xpath(".//div[@class=\"rankings-block__container full rankings-table\"]//td[*]"));
		
//		int str1 = str.size();
//		System.out.println(str1);
//		for(int z=1; z<=str1-1; z++)
//		{
//			//WebElement str3 = driver.findElement(By.xpath(".//div[@class=\"rankings-block__container full rankings-table\"]//td[z]"));
//			Thread.sleep(6000);
//		    String str4=str3.getText();
//			System.out.println(str4);
//			//String[] myString1=new String[4];
//		}
		
//		WebElement teamranking = driver.findElement(By.xpath("(//a[text()='Team Rankings'])[1]"));
//		Thread.sleep(5000);
//		teamranking.click();
//		List<WebElement>sl = driver.findElements(By.xpath(".//div[@class=\"rankings-block__container full rankings-table\"]//td[1]"));
//		Thread.sleep(5000);
//		List<WebElement>name = driver.findElements(By.xpath(".//div[@class=\"rankings-block__container full rankings-table\"]//td[2]"));
//		Thread.sleep(5000);
//    	List<WebElement>match = driver.findElements(By.xpath(".//div[@class=\"rankings-block__container full rankings-table\"]//td[3]"));
//		Thread.sleep(5000);
//		List<WebElement>point = driver.findElements(By.xpath(".//div[@class=\"rankings-block__container full rankings-table\"]//td[4]"));
//		Thread.sleep(5000);
//		List<WebElement>rating = driver.findElements(By.xpath(".//div[@class=\"rankings-block__container full rankings-table\"]//td[5]"));
//		Thread.sleep(5000);
//		for(int b=0; b<=name.size()-1; b++)
//		{
//			String sl_name = sl.get(b).getText();
//			String team = name.get(b).getText();
//			String matchno = match.get(b).getText();
//			String point1= point.get(b).getText();
//			String team1 = rating.get(b).getText();
//			System.out.println(sl_name+ " team name "+ team+ " match " + matchno+ " point "+point1+ " rating "+team1);
//		}
//				
				

	}

	
}


