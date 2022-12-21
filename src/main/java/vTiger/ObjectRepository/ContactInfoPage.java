package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage 
{
   // Declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
   private WebElement ContactHeader;
   
  

//Initialization
   public ContactInfoPage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   
   //Utilization
   
   public WebElement getContactHeader()
   {
		return ContactHeader;
   }
   
   //Business Library
   
   public String getContactPageHeader()
   {
	   return ContactHeader.getText();
   }
   
}
