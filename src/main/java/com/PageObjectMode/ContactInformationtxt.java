package com.PageObjectMode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationtxt 
{
	WebDriver driver;
	public ContactInformationtxt(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath=".//img[@alt=\"Select\"]")
	private WebElement contactorgtxt;
	public WebElement getContactorgtxt() {
		return contactorgtxt;
	}
	

}
