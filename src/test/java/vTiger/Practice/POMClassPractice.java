package vTiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import vTiger.ObjectRepository.LoginPage;

public class POMClassPractice
{
	public static void main(String[] args) throws IOException 
	{
	   // Launch the browser
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		//Login to Application
		LoginPage lp=new LoginPage(driver);
		
//		
//		lp.getUsernameEdt().sendKeys("admin");
//		lp.getPasswordEdt().sendKeys("admin");
//		lp.getSubmitBtn().click();
//		
	   // Optimised
		lp.loginToApp("admin", "admin");
		
		//Click on Organization Link
				driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index' and text()='Organizations']")).click();
				WebElement orgHeaderName = driver.findElement(By.xpath("//a[@class='hdrLink']"));
				if(orgHeaderName.getText().equalsIgnoreCase("Organizations"))
					System.out.println("Pass: Organization Page is displayed");
				else
				   System.out.println("Fail: Organization page is not displayed");
				
	   
		
		
		
				

}
}
