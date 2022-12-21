package vTiger.OrganizationTests;

    import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewOrganizations;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

@Listeners(vTiger.GenericUtilities.ListenerImplementationClass.class)
	public class CreateOrganizationWithIndustryPOMTest 
	{
		public void createOrganizationWithIndustryPOMTest() throws IOException
		{
			//Step1: Create all the Objects
			
			PropertyFileUtility pUtil=new PropertyFileUtility();
			ExcelFileUtility eUtil=new ExcelFileUtility();
			JavaUtility jUtil=new JavaUtility();
			WebDriverUtility wUtil=new WebDriverUtility();
			
			/* Property file-Common data*/
			
			
			String BROWSER=pUtil.readDataFromPropertyFile("browser");
	    	String URL = pUtil.readDataFromPropertyFile("url");
	    	String USERNAME = pUtil.readDataFromPropertyFile("username");
	    	String PASSWORD = pUtil.readDataFromPropertyFile("password");
	    	
	    	/* Excel file - Test Data */
	    	
	    
	   	    String ORGNAME = eUtil.readDataFromExcel("Organizations", 4, 2)+jUtil.getRandomNumber();
	   	    String IndustryType=eUtil.readDataFromExcel("Organizations", 4, 3);
	   
	   	    
	   	 WebDriver driver = null;
		 //Step2: Launch the browser- run time Polymorphism - driver is experiencing the polymorphism
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
			 System.out.println("invalid browser name");
		 }
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		//Step3: Login to Application
		
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//Step4: Click on Organization Link
		
		HomePage hp= new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Step5: Click on create organization lookup image
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnOrgLookUpImg();
		
		
		// Step6: Create new organization with Industry and save
		
		CreateNewOrganizations cnos=new CreateNewOrganizations(driver);
		cnos.createNewOrganization(ORGNAME,IndustryType);
		
		/* Select Industry from DropDown */
		
//		WebElement IndustryDropDown =driver.findElement(By.name("industry"));
//		wUtil.handleDropDown(eUtil.readDataFromExcel("Organizations", 4, 3), IndustryDropDown);
//		
		//Step7: Validation
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String OrgHeader=oip.getOrgHeaderInfo();
		
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println(OrgHeader);
			System.out.println("Pass: New Organization is created");
		}
		else
		{
			System.out.println("Fail: Organization is not created");
		}
		
		
		//Thread.sleep(2000);
		
		//Step7: Logout
		
		hp.logOutOfApp(driver);
		
		

	    	
		}

	}


