package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGPractice 
{
   @Test 
   public void createCustomerTest()
   {
	   Assert.fail();
	   System.out.println("create customer");
   }
   @Ignore
   @Test
   public void modifyCustomerTest()
   {
	   System.out.println("modify customer");
   }
   
   @Test(enabled=false)
   public void deleteCustomrTest()
   {
	   System.out.println("Deleter customer");
   }
}
