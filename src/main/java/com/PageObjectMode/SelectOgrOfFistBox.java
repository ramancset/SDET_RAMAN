package com.PageObjectMode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectOgrOfFistBox
{
	WebDriver driver;
	public SelectOgrOfFistBox(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="(//a[@href=\"javascript:window.close();\"])[1]")
	private WebElement selectfistelement;
	public WebElement getSelectfistelement() {
		return selectfistelement;
	}

}
