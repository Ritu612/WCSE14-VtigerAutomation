package vTiger.OrganizationTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;

@Listeners(vTiger.GenericUtilities.ListenerImplementationClass.class)
public class CreateOrganizationWithIndustryTest extends BaseClass
{

	@Test(groups="SmokeSuite")
	
	public void createOrganizationWithIndustryTest() throws IOException, InterruptedException
	{
		
		
	   //Step1:/* Excel file - Test Data */
    	
     String ORGNAME = eUtil.readDataFromExcel("Organizations", 4, 2)+jUtil.getRandomNumber();
   	    
   //Step2: Click on Organization Link
	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	
	//Step3: Click on create organization lookup image
	
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	
	
	// Step4: Create new organization with Industry and save
	
	driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
	/* Select Industry from DropDown */
	
	WebElement IndustryDropDown =driver.findElement(By.name("industry"));
	wUtil.handleDropDown(eUtil.readDataFromExcel("Organizations", 4, 3), IndustryDropDown);
	
    // Save
	driver.findElement(By.name("button")).click();
	
	
	
	

    	
	}
	
	@Test(groups="RegressionSuite")
	public void demoTest()
	{
		System.out.println("This is demo");
	}

	
}
