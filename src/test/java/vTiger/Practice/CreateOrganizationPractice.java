package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class CreateOrganizationPractice {

	public static void main(String[] args) throws IOException 
	{
	
		Random random=new Random();
		int randomNumber=random.nextInt(100);
		
		
		// Launch the browser
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		// Data read from Properties File
		
		FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		
		// Properties File Implementation
		driver.get(p.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Login to Application
		driver.findElement(By.name("user_name")).sendKeys(p.getProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(p.getProperty("password"));
		driver.findElement(By.id("submitButton")).click();
		 WebElement homepage = driver.findElement(By.xpath("//a[contains(text(),'Home')] "));
		if(homepage.getText().equalsIgnoreCase("Home"))
			System.out.println("Pass: Home page is displayed");
		else
			System.out.println("Fail: Home page is not displayed");
		
		//Click on Organization Link
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index' and text()='Organizations']")).click();
		WebElement orgHeaderName = driver.findElement(By.xpath("//a[@class='hdrLink']"));
		if(orgHeaderName.getText().equalsIgnoreCase("Organizations"))
			System.out.println("Pass: Organization Page is displayed");
		else
		   System.out.println("Fail: Organization page is not displayed");
		
		// Click on create Organization lookup image
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		WebElement createNewOrgName = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		if(createNewOrgName.getText().equalsIgnoreCase("Creating New Organization"))
			System.out.println("Pass: Create New Organization Page displayed");
		else
			System.out.println("Fail:Create New Organization Page not displayed ");
		// Read Data from Excel
		
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		String newOrgName=wb.getSheet("Organizations").getRow(1).getCell(2).getStringCellValue();
		
		
		System.out.println(newOrgName);
		
		// Create new organization with mandatory information and save
		String newOrganzationName=newOrgName+randomNumber;
		
		driver.findElement(By.name("accountname")).sendKeys(newOrganzationName);
		driver.findElement(By.xpath("//input[@value='T']")).click();
		WebElement assignedToDropDown = driver.findElement(By.name("assigned_group_id"));
		Select s=new Select(assignedToDropDown);
		s.selectByVisibleText("Support Group");
		driver.findElement(By.name("button")).click();
		WebElement newOrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		if(newOrgHeader.getText().contains(newOrganzationName))
			System.out.println("Pass: New Organization created successfully");
		else
			System.out.println("Fail: New Organization not created");
		WebElement orgHeaderName1 = driver.findElement(By.xpath("//a[@class='hdrLink']"));
		if(orgHeaderName1.getText().equalsIgnoreCase("Organizations"))
			System.out.println("Pass: Organization Page is displayed");
		else
		   System.out.println("Fail: Organization page is not displayed");
//		//11String newCreatedOrg = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[last()]/td[3]/a")).getText();
		
		 //String newCreatedOrg=driver.findElement(By.xpath("//table[@class='lvt small']/descendant::tr[last()]/td[3]/a")).getText();
//	        System.out.println(newCreatedOrg);
//		 if(newCreatedOrg==newOrganzationName)
//			System.out.println("Test Case Passed");
//		else
//			System.out.println("Test case Failed");
		 
		 	WebElement administratorImage = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		   Actions a=new Actions(driver);
		   a.moveToElement(administratorImage).perform();
		   driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		   driver.quit();
		

		
		
		
		

	}

}
