package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsPractice 
{
  @Test
  public void assertPractice()
  {
	  System.out.println("Step1");
	  System.out.println("Step2");
	  System.out.println("Step3");
	  Assert.assertEquals(false, true);
	  System.out.println("Step4");
	  System.out.println("Step5");
	  System.out.println("Step6");
  }
}
