package JDBC.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertClass 
{
	@Test(enabled = false)
	public void assertTest()
	{
		// we can write at lest one assert in one test script
		// SoftAssert "soft.assertAll() statement write in the last line before hard assert
		
		System.out.println("lunch browser");
		System.out.println("Enter Url");
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(true, false);
		System.out.println("lunch login page");
		System.out.println("enter user name ");
		System.out.println("enter password");
		System.out.println("click on login page");
		System.out.println("home page display");
		int expectedResult=10;
		int actualResult = 10;
		
		soft.assertAll();
		Assert.assertEquals(actualResult, expectedResult);
	}
	

}
