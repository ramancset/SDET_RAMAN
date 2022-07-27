package practic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MonkeyTest 
{
	WebDriver driver;
	
	public MonkeyTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	

}
