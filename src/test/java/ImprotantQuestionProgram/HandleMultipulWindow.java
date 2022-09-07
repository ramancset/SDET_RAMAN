package ImprotantQuestionProgram;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleMultipulWindow {

	public static void main(String[] args) throws AWTException, Throwable 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com");
		driver.findElement(By.xpath("@href=\"https://www.linkedin.com/company/orangehrm/mycompany/\"")).click();
		driver.findElement(By.xpath("@href=\"https://www.facebook.com/OrangeHRM/\"")).click();
		driver.findElement(By.xpath("//a[@href=\"https://twitter.com/orangehrm?lang=en\"\"]")).click();
		
		
		
	}
}
