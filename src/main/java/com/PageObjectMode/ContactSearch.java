package com.PageObjectMode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactSearch
{
	WebDriver driver;
	public ContactSearch(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath=".//input[@type=\"text\"]")
	private WebElement contactsearchtextbox;
	public WebElement getContactsearchtextbox() {
		return contactsearchtextbox;
	}
	@FindBy(xpath=".//input[@onclick=\"callSearch('Basic');\"]")
	private WebElement clickSearchoption;
	public WebElement getClickSearchoption() {
		return clickSearchoption;
	}
//	
//	@FindBy(name="search_text")
//	private WebDriver searchOrgText;
//	public WebDriver getSearchOrgText() {
//		return searchOrgText;
//	}
//	
	

}
