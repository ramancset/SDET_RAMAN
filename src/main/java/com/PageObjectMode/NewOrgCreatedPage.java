package com.PageObjectMode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewOrgCreatedPage 
{
	WebDriver driver;
	public NewOrgCreatedPage(WebDriver drive)
	{
		PageFactory.initElements(drive,this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgtextbox;
	public WebElement getOrgtextbox() {
		return orgtextbox;
	}
	@FindBy(xpath=".//input[@title=\"Save [Alt+S]\"]")
	private WebElement optsavimg;
	public WebElement getOptsavimg() {
		return optsavimg;
	}
	
	@FindBy(xpath=".//select[@name=\"industry\"]")
	private WebElement orgOfindustry;
	public WebElement getOrgOfindustry() {
		return orgOfindustry;
	}
	
	@FindBy(name="lastname")
	private WebElement namelasttext;
	public WebElement getNamelasttext() {
		return namelasttext;
	}
	
	
	
	
	

}
