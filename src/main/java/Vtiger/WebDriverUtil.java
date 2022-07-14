package Vtiger;

import java.time.Duration;

import java.util.Random;

import org.openqa.selenium.Alert;
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
	
	public void slectClass(WebElement industry,int index)
	{
		Select s = new Select(industry);
		s.selectByIndex(1);	
	
	}
	public void slectClass(WebElement industry,String Value)
	{
		Select s = new Select(industry);
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
	}
	public void waitankclick(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

}
