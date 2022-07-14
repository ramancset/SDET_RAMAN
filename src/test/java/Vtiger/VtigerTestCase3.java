package Vtiger;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.PageObjectMode.CampSearchnow;
import com.PageObjectMode.CampaignMainPage;
import com.PageObjectMode.CreateCampaignImg;
import com.PageObjectMode.HomePage;
import com.PageObjectMode.LoginPage;
import com.PageObjectMode.NewCampCreate;

import JDBC.Practice.FakerDate;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerTestCase3 {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, Throwable
	{
		FakerDate fake = new FakerDate();
		String orgname=fake.company();
		
		//lunching browser
		
		
		PropertyFile prop = PropertyFile.getObjectPropfile();
		String browser = prop.readDatafromPropfile("browser");
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid input");
		}
		
		//lunching URL
		
		driver.get(prop.readDatafromPropfile("url"));
		Thread.sleep(2000);
	
		//For login in Vtiger;
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getUsernametextbox().sendKeys(prop.readDatafromPropfile("username"));
		
		loginPage.getPasswordtextbox().sendKeys(prop.readDatafromPropfile("password"));
		Thread.sleep(2000);
		
		loginPage.getLoginbutton().click();
		Thread.sleep(4000);
		
		//Click on More option in homePage
		
		HomePage homePage = new HomePage(driver);
		//homePage.getClickMoreText().click();
		
		
		//Click on Campaigns option
		
		
		WebDriverUtil util = new WebDriverUtil(driver);
		//WebElement campaigns = homePage.getClickOnCampaigns();
		util.movelement(homePage.getClickMoreText());
		
		util.movelement(homePage.getClickOnCampaigns());
		
		Thread.sleep(4000);
		
		
		//click Create Campaigns 
		
		CreateCampaignImg campaignImg = new CreateCampaignImg(driver);
		campaignImg.getClickOnCreateCamp().click();
		Thread.sleep(4000);
		
		//create new Campaigns
		
		NewCampCreate newCampCreate = new NewCampCreate(driver);
		newCampCreate.getOrgtextfild().sendKeys(orgname);
		Thread.sleep(4000);
	
		WebElement campType = newCampCreate.getDropDownCampaType();
		campType.click();
		util.slectClass(campType, 3);
		Thread.sleep(4000);
		
		// Click on Save option
		
		newCampCreate.getClickOnSaveoption().click();
		Thread.sleep(4000);
				
		//Click on Campaigns option
				
		//WebElement campaigns1 = homePage.getClickOnCampaigns();
		util.movelement(homePage.getClickMoreText());
		util.movelement(homePage.getClickOnCampaigns());
		Thread.sleep(4000);
		
		//Click on Campaign Search field
		
		CampaignMainPage campaignMainPage = new CampaignMainPage(driver);
		campaignMainPage.getSearchBox().sendKeys(orgname);
		Thread.sleep(4000);
      
		// Click on Campaign in field
		
		WebElement campNo = campaignMainPage.getCampNoDrop();
		campNo.click();
		util.slectClass(campNo, 2);
		Thread.sleep(4000);
		
		// click on Search option
		CampSearchnow campSearchnow = new CampSearchnow(driver);
		campSearchnow.getSearchoptionbox().click();
		Thread.sleep(4000);
		
		//click on check box result
		campSearchnow.getAfterSearchResult().click();
		Thread.sleep(4000);
		
		//click on Delete button
		campSearchnow.getClickOnDeleteOption().click();
		Thread.sleep(4000);
		
		Alert a2 = driver.switchTo().alert();
		a2.accept();
		Thread.sleep(5000);
	
		util.movelement(homePage.getSignoutimg());
		util.movelement(homePage.getSignoutlink());
		Thread.sleep(8000);
		//util.movelement(homePage.getSignoutimg());
		//util.movelement(homePage.getSignoutlink());
		System.out.println("program complite");


	}

}
