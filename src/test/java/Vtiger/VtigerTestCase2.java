package Vtiger;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.PageObjectMode.ContactInformationtxt;
import com.PageObjectMode.ContactSearch;
import com.PageObjectMode.HomePage;
import com.PageObjectMode.LoginPage;
import com.PageObjectMode.NewOrgCreatedPage;
import com.PageObjectMode.OrganizationsPage;
import com.PageObjectMode.SelectOgrOfFistBox;

import JDBC.Practice.FakerDate;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerTestCase2 {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, Throwable {
		
		FakerDate faker = new FakerDate();
		String orgname = faker.company();
		
		PropertyFile prop = PropertyFile.getObjectPropfile();
		String BROWSER = prop.readDatafromPropfile("browser");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid input");
		}
		
		driver.get(prop.readDatafromPropfile("url"));
		Thread.sleep(2000);
		LoginPage loginpage = new LoginPage(driver);
		loginpage.getUsernametextbox().sendKeys(prop.readDatafromPropfile("username"));
		Thread.sleep(5000);
		loginpage.getPasswordtextbox().sendKeys(prop.readDatafromPropfile("password"));
		loginpage.getLoginbutton().click();
		
		Thread.sleep(5000);
		HomePage homepage = new HomePage(driver);
		 WebElement homePageElement = homepage.getContactbutton();
		homePageElement.click();
		
		OrganizationsPage organizationsPage= new OrganizationsPage(driver);
		organizationsPage.getContacttxtbox().click();
				
		
		Thread.sleep(5000);
		
		ContactInformationtxt contactInformationtxt = new ContactInformationtxt(driver);
		contactInformationtxt.getContactorgtxt().click();
		String MainWindow = driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();
		Iterator<String> itr= s.iterator();
		while(itr.hasNext())
		{
			
			Thread.sleep(5000);
			String child_refid = itr.next();
			driver.switchTo().window(child_refid);
			String childwindow = driver.getTitle();
			System.out.println( childwindow);
			ContactSearch contactSearch = new ContactSearch(driver);
			WebElement driver1 = contactSearch.getContactsearchtextbox();

			driver1.sendKeys(orgname);
	
		
		}
		//ContactSearch contactSearch = new ContactSearch(driver);
		//contactSearch.getClickSearchoption().click();
		Thread.sleep(5000);
		SelectOgrOfFistBox selectOgrOfFistBox = new SelectOgrOfFistBox(driver);
		selectOgrOfFistBox.getSelectfistelement().click();
		Thread.sleep(5000);
		
		driver.switchTo().window(MainWindow);
		
		NewOrgCreatedPage creatingneworganization = new NewOrgCreatedPage(driver);
		creatingneworganization.getNamelasttext().sendKeys(orgname);
		creatingneworganization.getOptsavimg().click();
		Thread.sleep(5000);
		homepage.getSignoutimg().click();
		WebDriverUtil driverUtil = new WebDriverUtil(driver);
	
		driverUtil.movelement(homepage.getSignoutlink());
		Thread.sleep(5000);
		
	
		System.out.println("program complite");

	}
	

}
