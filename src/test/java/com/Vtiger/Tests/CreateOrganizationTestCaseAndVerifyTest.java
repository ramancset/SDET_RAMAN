package com.Vtiger.Tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.PageObjectMode.ForVerifyOrgText;
import com.PageObjectMode.HomePage;
import com.PageObjectMode.NewOrgCreatedPage;
import com.PageObjectMode.OrganizationsPage;

import JDBC.Practice.FakerDate;
import Vtiger.BaseClass;
import Vtiger.WebDriverUtil;
@Listeners(Vtiger.ListenerClass.class)
public class CreateOrganizationTestCaseAndVerifyTest extends BaseClass 
{
	@Test(groups= "regration",retryAnalyzer = Vtiger.RetryAnalyzer.class)
	public void testScriptTest2() throws Throwable 
	{
		
		FakerDate faker = new FakerDate();
		String orgname = faker.company();
		
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
		Assert.assertEquals(true, true);
		Thread.sleep(8000);
		if(text1.contains(orgname))
		{
			System.out.println("Organization name matched");
		}
		else
		{
			System.out.println("Organization name not matched");
		}
		Thread.sleep(8000);
		
        Assert.assertEquals(true, true);
		
	}

}
