package vTiger.Practice;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class CreateContactPractice {

	public static void main(String[] args) {
		Random random=new Random();
		int RandomNumber=random.nextInt(100);
		
		
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
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		WebElement contactHeader = driver.findElement(By.xpath("//a[@class='hdrLink']"));
		if(contactHeader.getText().equalsIgnoreCase("Contacts"))
			System.out.println("Pass: Contacts page is displayed");
		else
			System.out.println("Fail: Contacts page is not displayed");
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		WebElement createNewContactHeader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));
		if(createNewContactHeader.getText().equalsIgnoreCase("Creating New Contact"))
			
			System.out.println("Pass: Create New Contacts page is displayed");
		else
			System.out.println("Fail: Create New Contacts page is not displayed");
		
		String LastName="Ritu"+RandomNumber;
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\DELL\\Desktop\\MicrosoftTeams-image (6).png");
		driver.findElement(By.name("button")).click();
		
		WebElement contactInfoPageHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		if (contactInfoPageHeader.getText().contains(LastName))
			System.out.println("Pass : New contact created successfully");
		else
			System.out.println("Fail : Contact is not created");
		

	 	WebElement administratorImage = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	   Actions a=new Actions(driver);
	   a.moveToElement(administratorImage).perform();
	   driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	   driver.quit();

		
		
		
		
		


	}

}
