package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyserPractice 
{
   
 @Test(retryAnalyzer=vTiger.GenericUtilities.RetryAnalyserImplementation.class)
 
 public void practiceRetry()
 {
	 Assert.fail();
	 System.out.println("Run");
 }
   
 
 @Test
 
 public void practiceRetry1()
 {
	 System.out.println("Run1");
 }
}
