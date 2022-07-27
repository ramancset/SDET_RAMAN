package Vtiger;

import java.io.File;


import java.io.IOException;
import java.time.Duration;


import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WebDriverUtil 
{
	WebDriver driver ;

	public WebDriverUtil(WebDriver driver)
	{
		this.driver=driver;
	}


	public void maxWindow()
	{
		driver.manage().window().maximize();
	}
	public void waitexplicitly()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));

	}
	public void refreshBrowser()
	{
		driver.navigate().refresh();
	}

	public void slectClass(WebElement locator,int index)
	{
		Select s = new Select(locator);
		s.selectByIndex(index);	

	}
	public void slectClass(WebElement locator,String Value)
	{
		Select s = new Select(locator);
		s.selectByVisibleText("raman");
	}
	public int randomClass()
	{
		Random random = new Random();
		int number = random.nextInt(10);
		return number;
	}

	public void movelement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();

	}

	public void Browserclose() {
		driver.close();
	}
	public void alertPop_up()
	{
		Alert a = driver.switchTo().alert();
		a.accept();
	}
	public void waitankclick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	//	public void selectDropDownValue(WebElement locator,String type ,String value)
	//	{
	//		Select select = new Select(locator);
	//		
	//		switch (type) 
	//		{
	//		case "index":
	//			select.selectByIndex(Integer.parseInt(value));
	//			
	//			break;
	//		case "value":
	//			select.selectByValue(value);;
	//			
	//			break;
	//		case "visibletext":
	//			select.selectByVisibleText(value);
	//			
	//			break;
	//
	//		default:
	//			System.out.println("please pass the correct selection criteria......");
	//			break;
	//		}

	public String takeScreenShot(String name)
	{
		TakesScreenshot shot =(TakesScreenshot)BaseClass.sdriver;
		File file = shot.getScreenshotAs(OutputType.FILE);
		String screenshot = "../SDET_RAM/screnshot/"+name+".png";
		File f1= new File(screenshot);
		try {
			FileUtils.copyFile(file, f1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return screenshot;
	}



}










