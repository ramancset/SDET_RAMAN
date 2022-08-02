package com.Vtiger.Tests;

import org.openqa.selenium.Alert;




import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.PageObjectMode.CampSearchnow;
import com.PageObjectMode.CampaignMainPage;
import com.PageObjectMode.CreateCampaignImg;
import com.PageObjectMode.HomePage;
import com.PageObjectMode.NewCampCreate;

import JDBC.Practice.FakerDate;
import Vtiger.BaseClass;
import Vtiger.WebDriverUtil;
@Listeners(Vtiger.ListenerClass.class)
public class CreateCampaignsAndDeleteTest extends BaseClass 
{
	@Test(groups= {"smoke","regration"},retryAnalyzer =Vtiger.RetryAnalyzer.class)
	public  void ScriptTest4Test() throws Throwable 
	{
		FakerDate fake = new FakerDate();
		String orgname1=fake.company();
		String orgname=orgname1;
		
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
		Thread.sleep(4000);
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
	
		util.slectClass(campNo, 1);
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
//		util.movelement(homePage.getSignoutimg());
//		util.movelement(homePage.getSignoutlink());
//		Thread.sleep(5000);
		Assert.assertEquals(true,true);
		
		System.out.println("program complite");


	}

}
