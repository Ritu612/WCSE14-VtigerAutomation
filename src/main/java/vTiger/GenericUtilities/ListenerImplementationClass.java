	package vTiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to the ITEstListener Interface  of TestNG
 * @author DELL
 *
 */
 public class ListenerImplementationClass implements ITestListener
 
{
	 ExtentReports report;
	 ExtentTest test;

    public void onTestStart(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"---> test execution started");
		test = report.createTest(methodName);
	}

	public void onTestSuccess(ITestResult result) 
	{
	  String methodName = result.getMethod().getMethodName();	
	
	  test.log(Status.PASS,methodName+ "Success");
	}

	public void onTestFailure(ITestResult result) 
	{
		WebDriverUtility wUtil=new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();
		
		 String methodName = result.getMethod().getMethodName();	
		 test.log(Status.FAIL, methodName+"--> Fail");
		 test.log(Status.FAIL, result.getThrowable());
		  
		  
		  String screenshotname=methodName+"--"+jUtil.getSystemDateInFormat();
		  try {
			String path = wUtil.taketheScreenShot(BaseClass.sdriver, screenshotname);
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();	
	    test.log(Status.SKIP,methodName+"---> Skipped");
	    test.log(Status.SKIP,result.getThrowable());
	}
	

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result)
	{
		
	}

	public void onStart(ITestContext context)
	{
		//Configure the Report
		System.out.println("Execution Started");
		
		//Create Object of Extent Spark reporter class	                        Report--1 dec 2022 17-05-32.html
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReport\\Report--"+new JavaUtility().getSystemDateInFormat()+".html");
	    htmlReport.config().setDocumentTitle("execution Report");
	    htmlReport.config().setTheme(Theme.DARK);
	    htmlReport.config().setReportName("Vtiger Execution Report");
	    
	    //Attach the html report to Extent Report
	    
	    report=new ExtentReports();
	    report.attachReporter(htmlReport);
	    report.setSystemInfo("Base Platform", "Windows");
	    report.setSystemInfo("Base Browser", "Chrome");
	    report.setSystemInfo("Base Environment", "Testing");
	    report.setSystemInfo("Base URL", "http://localhost:8888");
	    report.setSystemInfo("Author", "Ritu");
	    
	
	}

	public void onFinish(ITestContext context)
	{
		System.out.println("Execution Finished");
		
		// Flush the Report  - Consolidate the status of every script and generate the report
		
		report.flush();
		
		
	}
	 
	 
}
