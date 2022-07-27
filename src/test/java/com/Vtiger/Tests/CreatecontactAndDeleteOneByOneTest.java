package com.Vtiger.Tests;

import java.time.Duration;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.PageObjectMode.ContactHomePage;
import com.PageObjectMode.ContactSearch;
import com.PageObjectMode.CreateCampaignImg;
import com.PageObjectMode.HomePage;
import com.PageObjectMode.NewCampCreate;
import com.PageObjectMode.SelectOgrOfFistBox;

import JDBC.Practice.FakerDate;
import Vtiger.BaseClass;
import Vtiger.WebDriverUtil;
@Listeners(Vtiger.ListenerClass.class)
public class CreatecontactAndDeleteOneByOneTest extends BaseClass
{
	@Test(retryAnalyzer =Vtiger.RetryAnalyzer.class)
	public void ContactsTestCaseTest() throws Throwable
	{
		FakerDate data = new FakerDate();
		String orgname = data.firstName1();
		String orgname1 = data.lastNmae();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		HomePage homePage = new HomePage(driver);
		homePage.getContactbutton().click();
		Thread.sleep(5000);
		CreateCampaignImg createCampaignImg = new CreateCampaignImg(driver);
		Thread.sleep(2000);
		createCampaignImg.getImgonClickCreateContacts().click();
		Thread.sleep(2000);
		NewCampCreate newCampCreate = new NewCampCreate(driver);
		WebElement fistName = newCampCreate.getClickOnFirstNameDropdown();
		Thread.sleep(5000);
		fistName.click();
		WebDriverUtil webDriverUtil = new WebDriverUtil(driver);
		webDriverUtil.slectClass(fistName, 1);
		Thread.sleep(5000);
		newCampCreate.getFirstNameTextBox().sendKeys(orgname);
		Thread.sleep(4000);
		newCampCreate.getLastNametextbox().sendKeys(orgname1);
		
		newCampCreate.getOrgNameTextBox().click();
		String window1 = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		 Iterator<String> itr = s.iterator();
		 while (itr.hasNext()) 
		 {
			 Thread.sleep(3000);
			String refChildId = itr.next();
			driver.switchTo().window(refChildId);
			Thread.sleep(4000);
			ContactSearch contactSearch = new ContactSearch(driver);
			WebElement driver1 = contactSearch.getContactsearchtextbox();
			
			Thread.sleep(4000);
			String name = "test";

			driver1.sendKeys(name);
			
			
		}
		    ContactSearch contactSearch = new ContactSearch(driver);
		    contactSearch.getClickSearchoption().click();
		    Thread.sleep(5000);
			SelectOgrOfFistBox selectOgrOfFistBox = new SelectOgrOfFistBox(driver);
			selectOgrOfFistBox.getSelectfistelement().click();
			Thread.sleep(5000);
			driver.switchTo().window(window1);
		    WebElement campType = newCampCreate.getContactLeadSourceText();
		    campType.click();
		    Thread.sleep(4000);
		    webDriverUtil.slectClass(campType, 3);
		    Thread.sleep(4000);
		    newCampCreate.getClickOnSaveoption().click();
		    Thread.sleep(4000);
		    homePage.getContactbutton().click();
		    Thread.sleep(4000);
		    ContactHomePage contactHomePage = new ContactHomePage(driver);
		    contactHomePage.getSearchFildtext().sendKeys(orgname);
		    Thread.sleep(4000);
		    WebElement InField = contactHomePage.getInFildDropDown();
		    InField.click();
		    webDriverUtil.slectClass(InField, 1);
		    Thread.sleep(4000); 
		    contactHomePage.getSearchNowBox().click();
		    Thread.sleep(4000);
		    List<WebElement> list = driver.findElements(By.xpath(".//input[@type=\"checkbox\"]"));
		    int size =list.size();
		    System.out.println(size);
		    Thread.sleep(4000);
		    for(int i=1; i<size; i++)
		    {
		    	contactHomePage.getClickOnCheckBox().click();
			    Thread.sleep(4000);
			    contactHomePage.getDeleteOptionBox().click();
			    Thread.sleep(4000);
			    webDriverUtil.alertPop_up();
			    Thread.sleep(4000);
		    }
		    contactHomePage.getSearchFildtext().clear();
		    Thread.sleep(4000);
		    contactHomePage.getSearchFildtext().sendKeys(orgname);
		    Thread.sleep(4000);
		    WebElement InField1 = contactHomePage.getInFildDropDown();
		    InField1.click();
		    webDriverUtil.slectClass(InField1, 1);
		    Thread.sleep(4000); 
		    contactHomePage.getSearchNowBox().click();
		    Thread.sleep(4000);
		    WebElement popUp = contactHomePage.getPopUpOfNOElement();
		    Thread.sleep(4000);
			String text = popUp.getText();
			String expected = "No Contact Found !";	
		    Assert.assertEquals(text, expected);
		    System.out.println("No Contact Found");
		    
			
		
		   
				
		
				
	}
	

}
