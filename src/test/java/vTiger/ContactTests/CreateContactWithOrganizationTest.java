package vTiger.ContactTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewOrganizations;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

@Listeners(vTiger.GenericUtilities.ListenerImplementationClass.class)
public class CreateContactWithOrganizationTest extends BaseClass{

	
	@Test (groups="SmokeSuite")
	 public void createContactWithOrganizationTest() throws IOException
	{
    	
    	//Step1: Read data from Excel
    	
       String LASTNAME	=eUtil.readDataFromExcel("contacts", 4, 2);
    	String ORGNAME=eUtil.readDataFromExcel("Contacts", 4,3)+jUtil.getRandomNumber();
    	

       //Step2: Navigate to Organization
    	
    	HomePage hp=new HomePage(driver);
    	hp.clickOnOrganizationLink();
    	//driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
    	//driver.findElement(By.linkText("Organizations")).click();
    
    	//Step3: Click on create organization lookup image
    	
    	OrganizationsPage op=new OrganizationsPage(driver);
    	op.clickOnOrgLookUpImg();
    	Assert.fail();
    	
    	//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
    	
    	
    		
    	
    	//driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
//    	driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
//    	driver.findElement(By.name("button")).click();
    	
    	//Step4: Create Organization with Mandatory details and save
    	
    	CreateNewOrganizations cnop=new CreateNewOrganizations(driver);
    	cnop.createNewOrgnization(ORGNAME);
    	
    	//Step 5: Validate Organization
//    	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
//    	String OrgHeader=oip.getOrgHeaderText();
//    	Assert.assertTrue(OrgHeader.contains(ORGNAME));
    	
    	//Step5:Navigate to Contacts Link
    	
    	hp.clickOnContactsLink();
    	Reporter.log("Contacts link is clicked");
    	
    	//driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
        //driver.findElement(By.linkText("Contacts")).click();
    	
    	//Step6: Click on create Contacts lookup image
    	//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
    	
    	ContactsPage cp=new ContactsPage(driver);
    	cp.clickOnPlusButton();
    	Reporter.log("Create contacts look up image is clicked");
    	
    	//Step7:Create new Contact with mandatory fields
    	
    	driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

    // Step8: Navigate to Contacts lookup  image
    	driver.findElement(By.xpath("//img[@title='Select' and contains(@onclick,'Accounts&action')]")).click();
    	
    	// Mam code
    	// driver.findElement(By.xpath(" //input[@name='account_name']/following-sibling::img[@title='Select']")).click();
    	
    	
    	// Step 9: Switch the control to organizations window
    	
    	wUtil.switchToWindow(driver, "Accounts");
    	driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
    	driver.findElement(By.name("search")).click();
    	
    	driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();//Dynamic Xpath - Xpath generated at run time
    	
    	
    	//Step 10: Switch the control back to parent window
    	wUtil.switchToWindow(driver, "Contacts");
    	
    	//Step 11: Save
    	
       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 12: Validate for Contacts
		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		Assert.assertEquals(ContactHeader.contains(LASTNAME), true);
	
  }

	@Ignore
	@Test(groups="RegressionSuite")
	public void DemoTest()
	{
		Assert.fail();
		System.out.println("This is Demo");
	}
}
