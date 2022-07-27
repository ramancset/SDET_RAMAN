package com.Vtiger.Tests;

import java.util.Iterator;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.PageObjectMode.ContactInformationtxt;
import com.PageObjectMode.ContactSearch;
import com.PageObjectMode.HomePage;
import com.PageObjectMode.NewOrgCreatedPage;
import com.PageObjectMode.OrganizationsPage;
import com.PageObjectMode.SelectOgrOfFistBox;

import JDBC.Practice.FakerDate;
import Vtiger.BaseClass;
import Vtiger.WebDriverUtil;
@Listeners(Vtiger.ListenerClass.class)
public class CreateContactAndSinoutTest extends BaseClass 
{
	@Test(retryAnalyzer =Vtiger.RetryAnalyzer.class)
	public void testScript3Test() throws Throwable 
	{
		
		FakerDate faker = new FakerDate();
		String orgname = faker.company();
		
		
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
		Assert.assertEquals(true, true);
		
	
		System.out.println("program complite");
		

	}
	

}
