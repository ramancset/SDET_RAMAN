package com.PageObjectMode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForVerifyOrgText 
{
	WebDriver driver;
	public ForVerifyOrgText(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath=".//table[@align=\"center\"]/tbody/tr/td/span[@class=\"dvHeaderText\"]")
	private WebElement checktextofcreatedorg;
	public WebElement getChecktextofcreatedorg() {
		return checktextofcreatedorg;
	}

}
