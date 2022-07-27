package JDBC.Practice;

import org.testng.annotations.Test;

public class Annotation1 extends Annotation
{
	@Test(groups = "smoke")
	public void mainMethod1()
	{
		System.out.println("Main one method will execute");
	}
	
	@Test(groups = "regration")
	public void mainMethod2()
	{
		System.out.println("Main two method will execute");
	}

}
