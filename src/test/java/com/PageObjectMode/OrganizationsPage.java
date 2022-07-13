package com.PageObjectMode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage 
{
	WebDriver driver;
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath=".//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement orgnametxtbox;
	public WebElement getOrgnametxtbox() {
		return orgnametxtbox;
	}
	@FindBy(xpath=".//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement contacttxtbox;
	public WebElement getContacttxtbox() {
		return contacttxtbox;
	}
	

	

}
