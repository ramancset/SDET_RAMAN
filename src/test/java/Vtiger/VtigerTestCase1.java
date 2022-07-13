package Vtiger;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.PageObjectMode.ForVerifyOrgText;
import com.PageObjectMode.HomePage;
import com.PageObjectMode.LoginPage;
import com.PageObjectMode.NewOrgCreatedPage;
import com.PageObjectMode.OrganizationsPage;

import JDBC.Practice.FakerDate;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerTestCase1 {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, Throwable 
	{
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
		HomePage homepage = new HomePage(driver);
		homepage.getOrganizationsbutton().click();
		Thread.sleep(5000);
		OrganizationsPage  organizationspage = new OrganizationsPage(driver);
		organizationspage.getOrgnametxtbox().click();
		Thread.sleep(5000);
		
		NewOrgCreatedPage creatingneworganization = new NewOrgCreatedPage(driver);
		
		creatingneworganization.getOrgtextbox().sendKeys(orgname);
		Thread.sleep(5000);
		
		
		System.out.println("create one Organization");
		
		WebElement industry = creatingneworganization.getOrgOfindustry();
		industry.click();
		WebDriverUtil util = new WebDriverUtil(driver);
		util.slectClass(industry, 5);
		
		creatingneworganization.getOptsavimg().click();
		Thread.sleep(5000);
		ForVerifyOrgText forVerifyOrgText= new ForVerifyOrgText(driver);
		WebElement text=forVerifyOrgText.getChecktextofcreatedorg();
		String text1 = text.getText();
		System.out.println(text1);
		//Thread.sleep(5000);
		if(text1.contains(orgname))
		{
			System.out.println("Organization name matched");
		}
		else
		{
			System.out.println("Organization name not matched");
		}
		
		

	}

}
