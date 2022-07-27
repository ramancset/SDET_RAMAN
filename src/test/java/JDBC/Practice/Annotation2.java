package JDBC.Practice;

import org.testng.annotations.Test;

public class Annotation2 extends Annotation
{
	@Test(groups = "smoke")
	public void mainMethod3()
	{
		System.out.println("Main three method will execute");
	}
	
	@Test(groups = "smoke")
	public void mainMethod4()
	{
		System.out.println("Main four method will execute");
	}

}
