package vTiger.Practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationDropDown {

	public static void main(String[] args) {
	
		Random random=new Random();
		int randomNumber=random.nextInt(100);
		
		//WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		 WebElement homepage = driver.findElement(By.xpath("//a[contains(text(),'Home')] "));
		if(homepage.getText().equalsIgnoreCase("Home"))
			System.out.println("Pass: Home page is displayed");
		else
			System.out.println("Fail: Home page is not displayed");
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index' and text()='Organizations']")).click();
		WebElement orgHeaderName = driver.findElement(By.xpath("//a[@class='hdrLink']"));
		if(orgHeaderName.getText().equalsIgnoreCase("Organizations"))
			System.out.println("Pass: Organization Page is displayed");
		else
		   System.out.println("Fail: Organization page is not displayed");
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		WebElement createNewOrgName = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		if(createNewOrgName.getText().equalsIgnoreCase("Creating New Organization"))
			System.out.println("Pass: Create New Organization Page displayed");
		else
			System.out.println("Fail:Create New Organization Page not displayed ");
		
		String newOrganzationName="ICICI"+randomNumber;
		driver.findElement(By.name("accountname")).sendKeys(newOrganzationName);
		//driver.findElement(By.xpath("//input[@value='T']")).click();
		
		
		WebElement industryDropDown = driver.findElement(By.name("industry"));
		
		Select s=new Select(industryDropDown);
		s.selectByVisibleText("Healthcare");
		
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
		
		 
		 	WebElement administratorImage = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		   Actions a=new Actions(driver);
		   a.moveToElement(administratorImage).perform();
		   driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		   driver.quit();


	}

}
