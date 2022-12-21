package vTiger.OrganizationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;
import vTiger.GenericUtilities.WebDriverUtility;

public class CreateOrganizationUsingDDTTest 
{
    @Test
    public void createContactWithOrganizationPOMTest() throws IOException, InterruptedException
    {
    	//Step1: Create all the Objects
    	
    	PropertyFileUtility pUtil=new PropertyFileUtility();
    	ExcelFileUtility eUtil=new ExcelFileUtility();
    	JavaUtility jUtil=new JavaUtility();
    	WebDriverUtility wUtil=new WebDriverUtility();
    	
    	
    	/* Property File - Common Data */
    	
    	String BROWSER=pUtil.readDataFromPropertyFile("browser");
    	String URL = pUtil.readDataFromPropertyFile("url");
    	String USERNAME = pUtil.readDataFromPropertyFile("username");
    	String PASSWORD = pUtil.readDataFromPropertyFile("password");
    	
    	/*Excel File - Test Data*/ 
    	
    	 String ORGNAME = eUtil.readDataFromExcel("Organizations", 1, 2)+jUtil.getRandomNumber();
    	 
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
    	 
    	wUtil.maximiseWindow(driver);
    	wUtil.waitForPageLoad(driver);
    	driver.get(URL);
    	
    	//Step3: Login to Application
    	
    	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
    	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
    	driver.findElement(By.id("submitButton")).click();
    	
    	//Step4: Click on Organization Link
    	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
    	
    	//Step5: Click on create organization lookup image
    	
    	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
    	
    	
    	// Step6: Create new organization with mandatory information and save
    	
    	driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
    	driver.findElement(By.name("button")).click();
    	
    	Thread.sleep(2000);
    	//Step7: Logout
    	
    	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, ele);
		//wUtil.waitForElementToBeClickable(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

    	
    }
}
