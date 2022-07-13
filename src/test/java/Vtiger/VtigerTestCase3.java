package Vtiger;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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
		homePage.getClickMoreText().click();
		
		//Click on Campaigns option
		
		WebElement campaigns = homePage.getClickOnCampaigns();
		WebDriverUtil util = new WebDriverUtil(driver);
		util.movelement(campaigns);
		
		//click Create Campaigns 
		
		CreateCampaignImg campaignImg = new CreateCampaignImg(driver);
		campaignImg.getClickOnCreateCamp().click();
		
		//create new Campaigns
		
		NewCampCreate newCampCreate = new NewCampCreate(driver);
		newCampCreate.getOrgtextfild().sendKeys(orgname);
		
		WebElement campType = newCampCreate.getDropDownCampaType();
		campType.click();
		util.slectClass(campType, 3);
		
		// Click on Save option
		
		newCampCreate.getClickOnSaveoption().click();
		
		//Click on More option in homePage
		
		
		homePage.getClickMoreText().click();
				
		//Click on Campaigns option
				
		WebElement campaigns1 = homePage.getClickOnCampaigns();
		util.movelement(campaigns1);
		
		//Click on Campaign Search field
		
		CampaignMainPage campaignMainPage = new CampaignMainPage(driver);
		campaignImg.getClickOnCreateCamp().sendKeys(orgname);
      
		// Click on Campaign in field
		
		WebElement campNo = campaignMainPage.getCampNoDrop();
		campNo.click();
		util.slectClass(campNo, 1);
		
		// click on Search option
		
		
		
		
		driver.findElement(By.xpath(".//input[@name=\"search_text\"]")).sendKeys(name);
		Thread.sleep(5000);
		WebElement div = driver.findElement(By.xpath("(.//select[@id=\"bas_searchfield\"])[1]"));
		div.click();
		Select s = new Select(div);
		s.selectByIndex(1);
		driver.findElement(By.xpath(".//input[@class=\"crmbutton small create\"]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='selected_id']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(.//input[@class=\"crmbutton small delete\"])[1]")).click();
		Thread.sleep(5000);
		Alert a2 = driver.switchTo().alert();
		a2.accept();
		System.out.println("program complite");


	}

}
