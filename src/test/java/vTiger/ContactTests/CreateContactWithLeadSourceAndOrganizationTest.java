package vTiger.ContactTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;

public class CreateContactWithLeadSourceAndOrganizationTest {

	@Test
	  public void createContactWithLeadSourceAndOrganizationTest() throws IOException, InterruptedException
	{
		// Step 1: Create the necessary objects
		  
		  PropertyFileUtility pUtil=new PropertyFileUtility();
		  ExcelFileUtility eUtil=new ExcelFileUtility();
		  JavaUtility jUtil=new JavaUtility();
		  WebDriverUtility wUtil=new WebDriverUtility();
		  WebDriver driver = null;
		  
		  //Step2: Read the required data
		  
		  String BROWSER=pUtil.readDataFromPropertyFile("browser");
		  String URL=pUtil.readDataFromPropertyFile("url");
		  String USERNAME=pUtil.readDataFromPropertyFile("username");
		  String PASSWORD=pUtil.readDataFromPropertyFile("password");
		  
		  String LASTNAME=eUtil.readDataFromExcel("Contacts", 7, 2);
		  String ORGNAME=eUtil.readDataFromExcel("Contacts", 7, 4)+jUtil.getRandomNumber();
		  
		  // Step3 : Launch the browser
		  
		  if(BROWSER.equalsIgnoreCase("chrome"))
		  {
			  WebDriverManager.chromedriver().setup();
			  driver=new ChromeDriver();
		  }
		  else if(BROWSER.equalsIgnoreCase("firefox"))
		  {
			  WebDriverManager.firefoxdriver().setup();
			  driver=new FirefoxDriver();
		  }
		  else
		  {
			  System.out.println("Invalid browser name");
		  }
		  
		  wUtil.maximiseWindow(driver);
		  wUtil.waitForPageLoad(driver);
		  driver.get(URL);
		  
		 // Step4 :Login to Application
		  
		    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	    	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    	driver.findElement(By.id("submitButton")).click();
	    	
	    	//Step 5: Navigate to Organization
	    	
	    	driver.findElement(By.linkText("Organizations")).click();
	    	
	    	//Step 6: Click on create organization lookup image
	    	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	    	
	    	// Step7: Create new organization with mandatory information and save
	    	driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
	    	driver.findElement(By.xpath("//input[@type='radio' and @value='T']")).click();
	    	WebElement AssignedTo=driver.findElement(By.name("assigned_group_id"));
	    	wUtil.handleDropDown("Support Group", AssignedTo);
	    	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    	
	    	// Step 8: Validate Organization
	    	
	    	String OrgHeader=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    	if(OrgHeader.contains(ORGNAME))
	    	{
	    		System.out.println("Pass : New Organization created");
	    	}
	    	else
	    	{
	    		System.out.println("Fail: Organization not created");
	    	}
	    	
		  //Step9: Navigate to Contacts Link
	    	driver.findElement(By.linkText("Contacts")).click();
	    	
	    	//Step10: Click on Create Contacts lookup image
	    	
	    	driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
	    	
	    	//Step11:Create new Contact with mandatory fields
	    	
	    	driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	    	
	    	// Step12: Navigate to Contacts lookup  image
	    	driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif' and contains(@onClick,'Accounts&action')]")).click();
	    	
	    	// // Step 13: Switch the control to organizations window
	    	wUtil.switchToWindow(driver, "Accounts");
	    	driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
	    	driver.findElement(By.name("search")).click();
	    	
	    	driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();//Dynamic Xpath - Xpath generated at run time
	    
	    	//Step 14: Switch the control back to parent window
	      	wUtil.switchToWindow(driver, "Contacts"); 	
	      	
	      	 //Step 15: LeadSource value
	      	
	      	WebElement LeadSource=driver.findElement(By.name("leadsource"));
	        wUtil.handleDropDown(eUtil.readDataFromExcel("Contacts", 7, 3), LeadSource);
	        
	     // Save
	    	driver.findElement(By.name("button")).click();
	    	
	    	Thread.sleep(2000);
	    	
	    	//Step 16: Validate for Contacts
			String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(ContactHeader.contains(LASTNAME))
			{
				System.out.println(ContactHeader);
				System.out.println("PASS");
			}
			else
			{
				System.out.println("FAIL");
			}
	    	//Step17: Logout
	    	
	    	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	    	wUtil.mouseHoverAction(driver, ele);
	    	driver.findElement(By.linkText("Sign Out")).click();
	    	driver.quit();
		  
		  
		
	}

}
