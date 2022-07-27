package JDBC.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestngPractice1 
{
	@Test(dependsOnMethods = "admitcardTest")
	public void attendExamTest()
	{
		System.out.println("Attend in Exam ");
		Assert.assertFalse(true);
	}
	
	@Test()
	public void resultOfTenthTest()
	{
		System.out.println("Result published");
		
	}
	@Test()
	public void admitcardTest()
	{
		System.out.println("Admit card get from School");
	}


}
