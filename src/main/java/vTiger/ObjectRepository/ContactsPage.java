package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage 
{
  
	// Declaration
   @FindBy(xpath="//img[@alt='Create Contact...']")
   private WebElement plusButton;
   
   //Initialization
   
   public ContactsPage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }

   // Utilization
 public WebElement getPlusButton()
 {
	return plusButton;
}
   
 //Business Library
 
 public void clickOnPlusButton()
 {
	 plusButton.click();
 }
   
}
