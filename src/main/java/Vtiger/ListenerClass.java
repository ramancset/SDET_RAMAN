package Vtiger;

import org.testng.ITestContext;



import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenerClass extends BaseClass implements ITestListener {

	ExtentSparkReporter reporter;
	ExtentReports reports;
	ExtentTest test;
	

	public void onTestStart(ITestResult result) 
	{
		test=reports.createTest(result.getMethod().getMethodName());
		//System.out.println(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS,result.getMethod().getMethodName()+" got pass");
		test.log(Status.PASS, result.getThrowable());
//		String path;
//		try {
//			path=BaseClass.takeScreenshot(result.getMethod().getMethodName());
//			test.addScreenCaptureFromPath(path);
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}


	}

	public void onTestFailure(ITestResult result) 
	{
		

		test.log(Status.FAIL,result.getMethod().getMethodName()+" got Fail");
		test.log(Status.FAIL, result.getThrowable());

		String path;
		try
		{
			path=BaseClass.takeScreenshot(result.getMethod().getMethodName());
			Thread.sleep(3000);
			test.addScreenCaptureFromPath(path);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		

	}

	public void onTestSkipped(ITestResult result) 
	{
		test.log(Status.SKIP,result.getMethod().getMethodName()+" got Skip");


	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {


	}

	public void onStart(ITestContext context) 
	{
		reporter = new ExtentSparkReporter(IAutoconsts.extentreportpath);

		reporter.config().setDocumentTitle("VTiger App");

		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("CRM Report");

		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("Application Version", "5.0.1");
		reports.setSystemInfo("Browser", "firefox");
		reports.setSystemInfo("Env", "QA");			
	}

	public void onFinish(ITestContext context)
	{
		reports.flush();

	}

	public void onTestFailedWithTimeout(ITestResult result) {


	}

}
