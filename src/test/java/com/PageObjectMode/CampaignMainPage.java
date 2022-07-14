package com.PageObjectMode;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignMainPage 
{
	WebDriver driver;
	public CampaignMainPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="search_text")
	private WebElement SearchBox;
	public WebElement getSearchBox() {
		return SearchBox;
	}
	
	@FindBy(xpath="(.//select[@id=\"bas_searchfield\"])[1]")
	private WebElement campNoDrop;
	public WebElement getCampNoDrop() {
		return campNoDrop;
	}
	
}	
	
	
	
