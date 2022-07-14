package com.PageObjectMode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement Organizationsbutton;
	public WebElement getOrganizationsbutton() {
		return Organizationsbutton;
	}
	
	@FindBy(xpath=".//a[text()='Contacts']")
	private WebElement contactbutton;
	public WebElement getContactbutton() {
		return contactbutton;
	}
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutimg;


	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutlink;
	public WebElement getSignoutimg() {
		return signoutimg;
	}


	public WebElement getSignoutlink() {
		return signoutlink;
	}
	
	@FindBy(xpath=".//td[@class=\"tabUnSelected\"]/a[@href=\"javascript:;\"]")
	private WebElement clickMoreText;
	public WebElement getClickMoreText() {
		return clickMoreText;
	}
	
	//Click on Campaigns option
	
	@FindBy(xpath=".//a[@name=\"Campaigns\"]")
	private WebElement clickOnCampaigns;
	public WebElement getClickOnCampaigns() {
		return clickOnCampaigns;
	}
	
	
	 
	

}
