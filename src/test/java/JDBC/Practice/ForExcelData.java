package JDBC.Practice;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ForExcelData implements UtilityClass
{
	public static WebDriver driver;
	public static void BaseClass() throws Throwable
	{
		
		
		FileInputStream excelfile = new FileInputStream(path1);
		Workbook book = WorkbookFactory.create(excelfile);
		Sheet s = book.getSheet("Sheet1");
		Row r = s.getRow(3);
		Cell c = r.getCell(1);
		
		String browser= c.toString();
		if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
			 
		}
		else if (browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		String url= s.getRow(0).getCell(1).toString();
		driver.get(url);
		
		String admin1= s.getRow(1).getCell(1).toString();
		driver.findElement(By.xpath(".//input[@name=\"user_name\"]")).sendKeys(admin1);
		//user.click();
		//user.sendKeys("admin");
		Thread.sleep(5000);
		WebElement password = driver.findElement(By.xpath(".//input[@name=\"user_password\"]"));
		//password.click();
		String password1= s.getRow(2).getCell(1).toString();
		password.sendKeys(password1);
		driver.findElement(By.xpath(".//input[@id=\"submitButton\"]")).click();

		
		}
	}


