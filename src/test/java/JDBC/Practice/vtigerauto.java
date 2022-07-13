package JDBC.Practice;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class vtigerauto extends Property {

	public static void main(String[] args) throws Throwable 
	{
		// TODO Auto-generated method stub
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver = new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
//		driver.get("http://localhost:8888/index.php?action=index&module=Home");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath(".//input[@name=\"user_name\"]")).sendKeys("admin");
//		//user.click();
//		//user.sendKeys("admin");
//		Thread.sleep(5000);
//		WebElement password = driver.findElement(By.xpath(".//input[@name=\"user_password\"]"));
//		//password.click();
//		password.sendKeys("admin");
		Property.fileinput();
		driver.findElement(By.xpath(".//input[@id=\"submitButton\"]")).click();
		driver.findElement(By.xpath(".//a[text()='Organizations']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//td[@style=\"padding-right:0px;padding-left:10px;\"]")).click();
		Thread.sleep(5000);
		WebElement org = driver.findElement(By.xpath(".//input[@class=\"detailedViewTextBox\"]"));
		org.click();
		FakerDate date = new FakerDate();
		String str5 = date.firstName1();
		
//		String str= "str5";
//		Random random = new Random();
//		int number = random.nextInt();
//		String name = str+number;
		org.sendKeys(str5);
		driver.findElement(By.xpath(".//input[@class=\"crmbutton small save\"]")).click();
		System.out.println("create one Organization");
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//td[@class=\"tabSelected\"]/a[text()='Organizations']")).click();
		Thread.sleep(5000);
		//List<WebElement> clik = driver.findElements(By.xpath(".//table[@class=\"lvt small\"]/tbody/tr[*]/td[1]"));
		//Thread.sleep(5000);
		List<WebElement> org1 = driver.findElements(By.xpath(".//table[@class=\"lvt small\"]/tbody/tr[*]/td[3]/a"));
		int size = org1.size();
		Thread.sleep(5000);
		for(int x=3; x<=size; x++)
		{
			//WebElement str = driver.findElement(By.xpath(".//table[@class=\"lvt small\"]/tbody/tr["+x+"]/td[1]"));
			WebElement str1 = driver.findElement(By.xpath(".//table[@class=\"lvt small\"]/tbody/tr["+x+"]/td[3]"));
			String text1 = str1.getText();
			System.out.println(text1);
			
		}
		for(int x=3; x<=size; x++)
		{
			WebElement cls = driver.findElement(By.xpath(".//table[@class=\"lvt small\"]/tbody/tr["+x+"]/td[3]"));
			String text = cls.getText();
			Thread.sleep(5000);

			if(text.contains("9"))
			{
				WebElement cls1 = driver.findElement(By.xpath(".//table[@class=\"lvt small\"]/tbody/tr["+x+"]/td[1]"));
				Thread.sleep(5000);
		      cls1.click();
		
			}
		}
		WebElement log = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		act.moveToElement(log).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		

	}

}
