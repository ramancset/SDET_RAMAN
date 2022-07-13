package practic;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CurrentDate {

	public static void main(String[] args) 
	{
		
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.println(date);
		String currentDate = date.toString();
		String[] str = currentDate.split(" ");
		String day = str[0];
		String month = str[1];
		String date1 = str[2];
		String year = str[5];
		String todaysdate = day+" "+month+" "+" "+date1+" "+year;
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath(".//span[@class=\"langCardClose\"]")).click();
		driver.findElement(By.xpath(".//span[text()='DEPARTURE']")).click();
		driver.findElement(By.xpath(".//div[@aria-label='"+todaysdate+"']"));
		

	}

}
