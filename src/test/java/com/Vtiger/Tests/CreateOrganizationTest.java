package com.Vtiger.Tests;

import org.testng.annotations.Listeners;

import org.testng.annotations.Test;

import com.PageObjectMode.HomePage;
import com.PageObjectMode.NewOrgCreatedPage;
import com.PageObjectMode.OrganizationsPage;
import JDBC.Practice.FakerDate;
import Vtiger.BaseClass;
@Listeners(Vtiger.ListenerClass.class)
public class CreateOrganizationTest extends BaseClass 
{
	
	@Test(retryAnalyzer = Vtiger.RetryAnalyzer.class)
	public  void  TestScriptTest1() throws Throwable 
	{
		FakerDate faker = new FakerDate();
		String orgname = faker.company();
		HomePage homepage = new HomePage(driver);
		homepage.getOrganizationsbutton().click();
		Thread.sleep(5000);
		OrganizationsPage  organizationspage = new OrganizationsPage(driver);
		organizationspage.getOrgnametxtbox().click();
		Thread.sleep(5000);
		
		NewOrgCreatedPage newOrgCreatedPage= new NewOrgCreatedPage(driver);
		newOrgCreatedPage.getOrgtextbox().sendKeys(orgname);
		Thread.sleep(5000);
		//Optionofsave saveoption = new Optionofsave(driver);
		newOrgCreatedPage.getOptsavimg().click();
		
		System.out.println("create one Organization");
		Thread.sleep(5000);

	}

}
