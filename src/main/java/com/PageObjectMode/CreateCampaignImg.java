package com.PageObjectMode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignImg 
{
	WebDriver driver;
	public CreateCampaignImg(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//@FindBy(xpath=".//img[@src=\"themes/softed/images/btnL3Add.gif\"] or //img[@alt=\"Create Campaign...\"] or //img[@alt=alt=\"Create Contact...\"]")
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement clickOnCreateCamp;
	public WebElement getClickOnCreateCamp() {
		return clickOnCreateCamp;
	}
	
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement imgonClickCreateContacts;
	public WebElement getImgonClickCreateContacts() {
		return imgonClickCreateContacts;
	}
	
	

}
