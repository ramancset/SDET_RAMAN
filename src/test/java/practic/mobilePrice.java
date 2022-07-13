package practic;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mobilePrice {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.amazon.in/?tag=admpdesktopin-21&ref=pd_sl_aA3AA585448E9A346A378CBAAF&mfadid=adm");
		Thread.sleep(2000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile under 10000");
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//span[text()='Samsung']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//span[text()='Samsung Galaxy J7 SM-J700F (Gold)']")).click();
		Thread.sleep(2000);
		String title = driver.getTitle();
		System.out.println("name : "+title);
		Thread.sleep(2000);
		Set<String>s=driver.getWindowHandles();
		Iterator<String> itr= s.iterator();
		itr.next();
		Thread.sleep(2000);
		String child_refid = itr.next();
		driver.switchTo().window(child_refid);
		Thread.sleep(2000);
		String childwindow = driver.getTitle();
		System.out.println("childname : "+childwindow);
		String price = driver.findElement(By.xpath(".//span[text()='        Samsung Galaxy J7 SM-J700F (Gold)       ']/ancestor::div[@id=\"centerCol\"]//span[@class=\"a-price-whole\"]")).getText();
		System.out.println(price);
		

	}

}
