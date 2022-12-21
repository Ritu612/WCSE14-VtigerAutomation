package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
   // Declaration
	@FindBy(linkText="Organizations")
   private WebElement OrganizationsLnk;
   
   @FindBy(linkText="Contacts")
   private WebElement ContactsLnk;
   
   @FindBy(linkText="Opportunities")
   private WebElement OpportunitiesLnk;
   
   @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
   private WebElement AdminImg;
   
   @FindBy(xpath="//a[text()='Sign Out']")
   private WebElement SignoutLnk;
   
   
   //Initialization
   
   public HomePage(WebDriver driver)
   {
	   PageFactory.initElements(driver,this);
   }


// Utilization
   public WebElement getOrganizationsLnk() {
	return OrganizationsLnk;
}


public WebElement getContactsLnk() {
	return ContactsLnk;
}


public WebElement getOpportunitiesLnk() {
	return OpportunitiesLnk;
}


public WebElement getAdminImg() {
	return AdminImg;
}


public WebElement getSignoutLnk() {
	return SignoutLnk;
}
   
 // Business Library
/**
 *  This method will click on organizations link in home page
 */
public void clickOnOrganizationLink()
{
	OrganizationsLnk.click();
}

/**
 * This method will click on Contacts link in home page
 */
public void clickOnContactsLink()
{
	ContactsLnk.click();
}
 
/**
 * This method will click on Opportunities link in home page
 */
public void clickOnOpportunitiesLink()
{
	OpportunitiesLnk.click();
}
   /**
    * This method will sign out of Application
    * @param driver
    */
public void logOutOfApp(WebDriver driver)
{
	mouseHoverAction(driver, AdminImg);
	SignoutLnk.click();
	
}
   
}
