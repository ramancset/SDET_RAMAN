package JDBC.Practice;

import org.testng.annotations.Test;

public class TestngPractice 
{
	// Every test case default priority is Zero
	//Priority may + ,- number
	//If we not provide any priority it will work on alpha order
	//If we provide same no. of priority than it will work on alpha order
	@Test(priority = 2)
	public void attendExamTest()
	{
		System.out.println("Attend in Exam ");
	}
	
	@Test(priority = 3)
	public void resultOfTenthTest()
	{
		System.out.println("Result published");
		
	}
	@Test(priority = 1)
	public void admitcardTest()
	{
		System.out.println("Admit card get from School");
	}

}
