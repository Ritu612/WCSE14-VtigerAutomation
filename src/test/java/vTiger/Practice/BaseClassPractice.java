package vTiger.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClassPractice
{
   @BeforeSuite
   public void bsConfig()
   {
	   System.out.println("before suite");
   }
   
   @BeforeMethod
   public void bmConfig()
   {
	   System.out.println("before method");
	   
	  
   }
   
   @BeforeClass
   
   public void bcConfig()
   {
	   System.out.println(" before class");
   }
   
   @Test
   
   public void test()
   {
	   System.out.println("Test");
   }
   
   @Test
   
   public void test1()
   {
	   System.out.println("Test1");
   }
 
@AfterClass
  
public void acConfig()
{
	System.out.println("after class");
}


@BeforeClass

public void bcConfig1()
{
	   System.out.println(" before class1");
}

@Test

public void test2()
{
	   System.out.println("Test2");
}


@AfterClass

public void acConfig1()
{
	System.out.println("after class1");
}

   
@AfterMethod

public void amConfig()
{
	   System.out.println(" after method");
}
   
   @AfterSuite
   
   public void asConfig()
   {
	   System.out.println("after suite");
   }
   
   
}
