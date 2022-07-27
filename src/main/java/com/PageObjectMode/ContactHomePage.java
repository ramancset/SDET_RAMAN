package com.PageObjectMode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactHomePage 
{
	WebDriver driver;
	public ContactHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath=".//input[@name=\"search_text\"]")
	private WebElement SearchFildtext;
	
	
	
	
	@FindBy(id="bas_searchfield")
	private WebElement InFildDropDown;
	
	
	
	@FindBy(xpath= ".//input[@onclick=\"callSearch('Basic');\"]")
	private WebElement SearchNowBox;
	
	@FindBy(xpath="(.//input[@class=\"crmbutton small delete\"])[1]")
	private WebElement deleteOptionBox;
	
	
	
	@FindBy(xpath=".//input[@onclick=\"check_object(this)\"]")
	private WebElement ClickOnCheckBox;



	public WebElement getSearchFildtext() {
		return SearchFildtext;
	}



	public WebElement getInFildDropDown() {
		return InFildDropDown;
	}



	public WebElement getSearchNowBox() {
		return SearchNowBox;
	}



	public WebElement getDeleteOptionBox() {
		return deleteOptionBox;
	}



	public WebElement getClickOnCheckBox() {
		return ClickOnCheckBox;
	}
	
	@FindBy(xpath=".//span[@class=\"genHeaderSmall\"]")
	private WebElement popUpOfNOElement;
	public WebElement getPopUpOfNOElement() {
		return popUpOfNOElement;
	}
	
	
	
	

}
