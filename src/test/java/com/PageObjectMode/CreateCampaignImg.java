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
	
	@FindBy(xpath=".//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement clickOnCreateCamp;
	public WebElement getClickOnCreateCamp() {
		return clickOnCreateCamp;
	}
	
	

}
