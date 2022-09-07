package ImprotantQuestionProgram;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws Throwable, IOException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		linkslist.addAll(driver.findElements(By.tagName("img")));
		System.out.println(linkslist.size());
		
		List<WebElement> activelinks = new ArrayList<WebElement>();
		
		for(int i=0; i<linkslist.size();i++)
		{
			if(linkslist.get(i).getAttribute("href")!=null && (! linkslist.get(i).getAttribute("href").contains("javascript")))
			{
				activelinks.add(linkslist.get(i));
			}
		}
		
		System.out.println(activelinks.size());
		for(int j=0; j<activelinks.size();j++)
		{
			HttpsURLConnection connection = (HttpsURLConnection)new URL(activelinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activelinks.get(j).getAttribute("href")+"    "+response);
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
