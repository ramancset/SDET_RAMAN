package JDBC.Practice;

import java.io.File;

import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports
{
	//path,set them,title(look and feel)
	ExtentSparkReporter reporter;
	
	// Attach reports manual inputs
	ExtentReports reports;
	
	//To create entries in reports
	ExtentTest test;
	
	@Test y
	public  void reportCreation() throws Throwable 
	{
		reporter = new ExtentSparkReporter("../SDET_RAM/raman.html");
		reporter.config().setDocumentTitle("google");
		reporter.config().setTheme(Theme.STANDARD);
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		
		reports.setSystemInfo("Application Version", "5.0.9");
		reports.setSystemInfo("Browser", "Chrome");
		//reports.setSystemInfo("Browser", "Firefox");
		reports.setSystemInfo("Env", "QA");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com/");
		//Assert.assertFalse(true);
		test = reports.createTest("google");
		
		TakesScreenshot s1 = (TakesScreenshot)driver;
		File file = s1.getScreenshotAs(OutputType.FILE);
		String path = "../SDET_RAM/screnshot/raman.png";
		File f1 = new File (path);
		FileUtils.copyFile(file, f1);
		
		test.addScreenCaptureFromPath(path);
		
		reports.flush();
		
		
		
		
		
		
		
		
	}
	

}
