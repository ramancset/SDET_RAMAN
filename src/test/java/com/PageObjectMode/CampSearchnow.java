package com.PageObjectMode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampSearchnow 
{
	WebDriver driver;
	public CampSearchnow(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="(.//input[@class=\"crmbutton small create\"])[1]")
	private WebElement searchoptionbox;
	public WebElement getSearchoptionbox() {
		return searchoptionbox;
	}
	@FindBy(xpath="//input[@name='selected_id']")
	private WebElement afterSearchResult;
	public WebElement getAfterSearchResult() {
		return afterSearchResult;
	}
	
	@FindBy(xpath="(.//input[@class='crmbutton small delete'])[1]")
	private WebElement clickOnDeleteOption;
	public WebElement getClickOnDeleteOption() {
		return clickOnDeleteOption;
	}

}
