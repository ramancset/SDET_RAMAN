package JDBC.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;



public class TestngPractice2
{
	// This will show fail test case intentionally
	@Test()
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
	//If we write enabled = false than this method will not take part in execution.
	//If we write enabled = true than this method is only take part in execution.
	@Test(enabled = false)
	public void admitcardTest()
	{
		System.out.println("Admit card get from School");
	}
	
	//This will not take part in execution.
	@Test(invocationCount = 0)
	public void takePrintOutResultTest ()
	{
		
		System.out.println("Result paper ");
	}

}
