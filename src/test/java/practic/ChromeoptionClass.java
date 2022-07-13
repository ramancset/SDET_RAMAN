package practic;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeoptionClass {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();		
		ChromeOptions options = new ChromeOptions();
		 //options.addArguments("headless");
		 //options.addArguments("no-sandbox");
		// options.addArguments("window-size=1200x600");
		options.addArguments("start-maximized");
		//options.addArguments("headless");
		options.addArguments("test-type");
		options.addArguments("disable-popup-blocking");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);	
		options.merge(capabilities);
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://chromedriver.chromium.org/contributing");
        LoggingPreferences pre = new LoggingPreferences()
//		
	}

}
