package JDBC.Practice;

import java.io.File;


import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener
{

	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+"Test started");

	}

	public void onTestSuccess(ITestResult result) 
	{
		System.out.println(result.getMethod().getMethodName()+"Test Success");

		// TODO Auto-generated method stub
		TakesScreenshot shot =(TakesScreenshot)listenerMainClass.driver;
		File file = shot.getScreenshotAs(OutputType.FILE);
		String screenshot ="../SDET_RAM/"+result.getMethod().getMethodName()+".png"; 
		File f1= new File(screenshot);
		try {
			FileUtils.copyFile(file, f1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void onTestFailure(ITestResult result)
	{
		// TODO Auto-generated method stub
		System.out.println(result.getMethod().getMethodName()+"Test Failure");

		TakesScreenshot shot =(TakesScreenshot)listenerMainClass.driver;
		File file = shot.getScreenshotAs(OutputType.FILE);
		String screenshot = "../SDET_RAM/screnshot/"+result.getMethod().getMethodName()+".png";
		File f1= new File(screenshot);
		try {
			FileUtils.copyFile(file, f1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) 
	{
		// TODO Auto-generated method stub
		System.out.println("Test skipped");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		// TODO Auto-generated method stub


	}

	public void onTestFailedWithTimeout(ITestResult result)
	{
		// TODO Auto-generated method stub
		System.out.println("Test case fail due to timeout");

	}

	public void onStart(ITestContext context)
	{
		// TODO Auto-generated method stub
		System.out.println("Test case start");

	}

	public void onFinish(ITestContext context) 
	{
		// TODO Auto-generated method stub
		System.out.println("Test case finish");

	}

}
