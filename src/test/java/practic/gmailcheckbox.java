package practic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class gmailcheckbox {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath(".//div[@class=\"gb_e gb_f\"][1]")).click();
		driver.findElement(By.xpath(".//div[@class=\"header__aside__buttons\"]/a[2]")).click();
		WebElement gmail = driver.findElement(By.xpath(".//div[@class=\"Xb9hP\"]/input[@aria-label=\"Email or phone\"]"));
		gmail.click();
		gmail.sendKeys("raman27cset@gmail.com");
		driver.findElement(By.xpath(".//span[text()='Next']")).click();
		
		
		

	}

}
