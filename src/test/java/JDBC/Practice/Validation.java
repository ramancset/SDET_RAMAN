package JDBC.Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Validation extends Property {

	public static void main(String[] args) throws Throwable 
	{
		
		// For login in Vtiger
		Property.fileinput();
		// For create Campaign test script
		WebElement driver1 = driver.findElement(By.xpath(".//a[@href=\"javascript:;\"]"));
		
		Actions a = new Actions(driver);
		Thread.sleep(5000);
		a.moveToElement(driver1).perform();
		WebElement driver2 = driver.findElement(By.xpath(".//a[text()='Campaigns']"));
		Thread.sleep(5000);
		//a.click().perform();
		driver2.click();
		driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();
		FakerDate date = new FakerDate();
		String str5 = date.company();
		//String str= "testyantra";
		Random random = new Random();
		int number = random.nextInt();
		String name1 = str5+number;
		System.out.println(name1);

		driver.findElement(By.xpath(".//input[@name=\"campaignname\"]")).sendKeys(name1);
		driver.findElement(By.xpath(".//input[@class=\"crmButton small save\"]")).click();
        WebElement driver3 = driver.findElement(By.xpath(".//a[@href=\"javascript:;\"]"));
		
		Actions a1 = new Actions(driver);
		Thread.sleep(5000);
		a1.moveToElement(driver3).perform();
		WebElement driver4 = driver.findElement(By.xpath(".//a[text()='Campaigns']"));
		Thread.sleep(5000);
		//a.click().perform();
		driver4.click();
		List<WebElement> name = driver.findElements(By.xpath(".//a[text()='Campaign Name']"));
		
		ArrayList<String> name3=new ArrayList<String>();
		
		
		// for  Search and delete script
		driver.findElement(By.xpath(".//input[@name=\"search_text\"]")).sendKeys(name1);
		Thread.sleep(5000);
		WebElement div = driver.findElement(By.xpath("(.//select[@id=\"bas_searchfield\"])[1]"));
		div.click();
		Select s = new Select(div);
		s.selectByIndex(1);
		driver.findElement(By.xpath(".//input[@class=\"crmbutton small create\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='selected_id']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(.//input[@class=\"crmbutton small delete\"])[1]")).click();
		Thread.sleep(5000);
		Alert a2 = driver.switchTo().alert();
		a2.accept();
		
		System.out.println("program complite");
		


	}

}
