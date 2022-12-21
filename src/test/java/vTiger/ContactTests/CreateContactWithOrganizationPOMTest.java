package vTiger.ContactTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.BaseClass;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.ContactInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizations;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

@Listeners(vTiger.GenericUtilities.ListenerImplementationClass.class)
public class CreateContactWithOrganizationPOMTest extends BaseClass
{
    @Test(groups="SmokeSuite")
    public void createContactWithOrganizationPOMTest() throws IOException
	{
    	//Step1: read test data
    	
        String LASTNAME	=eUtil.readDataFromExcel("contacts", 4, 2);
    	String ORGNAME=eUtil.readDataFromExcel("Contacts", 4,3)+jUtil.getRandomNumber();

    	 
    	//Step5: Navigate to Organization
    	 
    	 HomePage hp=new HomePage(driver);
    	 hp.clickOnOrganizationLink();
    	 Reporter.log("Organization is clicked",true);
    	 //Assert.fail();
    	 
    	//Step6: Click on create organization lookup image
    	 OrganizationsPage op=new OrganizationsPage(driver);
    	 op.clickOnOrgLookUpImg();
    	 Reporter.log("Create Organization look up image is clicked",true);
    	
    	
    	 //Step7: Create Organization with mandatory details and save
    	 CreateNewOrganizations cno=new CreateNewOrganizations(driver);
    	 cno.createNewOrgnization(ORGNAME);
    	 Reporter.log("Organization is created with"+ORGNAME,true);
    	
    	 
    	 //Step 8: Validate Organization
    	 
    	 OrganizationInfoPage oip=new OrganizationInfoPage(driver);
    	 String OrgHeader=oip.getOrgHeaderInfo();
    	 Assert.assertTrue(OrgHeader.contains(ORGNAME));
    	// Assert.fail();
    	 
    			
    	
    	//Step9:Navigate to Contacts Link
    	
    	hp.clickOnContactsLink();
    	Reporter.log("Contacts link is clicked");
    	
    	//Step10: Click on create Contacts lookup image
    	
    	ContactsPage cp=new ContactsPage(driver);
    	cp.clickOnPlusButton();
    	Reporter.log("Create contact lookup image is clicked");
    	//Step11:Create new Contact with mandatory fields
    	
    	CreateNewContactPage cncp=new CreateNewContactPage(driver);
    	cncp.createNewContacts(LASTNAME, driver, ORGNAME);
    	Reporter.log("New Contact with organization is created-->"+LASTNAME,true);
    	
    	//Step 16: Validate for Contacts
    			ContactInfoPage cip = new ContactInfoPage(driver);
    			String ContactHeader = cip.getContactPageHeader();
    			Assert.assertEquals(ContactHeader.contains(LASTNAME), true);
    			
    			//Step 17: Logout of Application
    			hp.logOutOfApp(driver);
    			driver.quit();
    		


    	
    	
  }

}
