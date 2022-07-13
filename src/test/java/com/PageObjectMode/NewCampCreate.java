package com.PageObjectMode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCampCreate 
{
	WebDriver driver;
	
	public NewCampCreate(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(name="campaignname")
	private WebElement orgtextfild;

	public WebElement getOrgtextfild() {
		return orgtextfild;
	}
	 
	@FindBy(name="campaigntype")
	private WebElement dropDownCampaType;

	public WebElement getDropDownCampaType() {
		return dropDownCampaType;
	}
	
	@FindBy(xpath = ".//input[@title=\"Save [Alt+S]\"]")
	private WebElement clickOnSaveoption;

	public WebElement getClickOnSaveoption() {
		return clickOnSaveoption;
	}
	
	
	
	

}
