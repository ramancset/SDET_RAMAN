package com.PageObjectMode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="user_name")
	private WebElement usernametextbox;
	@FindBy(xpath="//input[@name='user_password']")
	private WebElement passwordtextbox;
	@FindBy(id="submitButton")
	private WebElement loginbutton;
	public WebElement getUsernametextbox() {
		return usernametextbox;
	}
	public WebElement getPasswordtextbox() {
		return passwordtextbox;
	}
	public WebElement getLoginbutton() {
		return loginbutton;
	}

}
