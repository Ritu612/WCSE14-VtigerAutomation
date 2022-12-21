package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility
{
   // Declaration
	@FindBy(name="lastname")
   private WebElement lastNameTxt;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath="//img[@title='Select' and contains(@onclick,'Accounts&action')]")
	private WebElement orgPlusBtn;
	
	@FindBy(name="search_text")
	private WebElement searchtxt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
   
   //Initialization
	public  CreateNewContactPage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }


  //Utilization
	
   public WebElement getLastNameTxt() {
		return lastNameTxt;
	}



	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}



	public WebElement getOrgPlusBtn() {
		return orgPlusBtn;
	}



	public WebElement getSearchtxt() {
		return searchtxt;
	}



	public WebElement getSearchBtn() {
		return searchBtn;
	}



	public WebElement getSaveBtn() {
		return saveBtn;
	}



	//Business Library
	
	/**
	 * This method will create contact with last name
	 * @param lName
	 */
	public void createNewContacts(String lName)
	{
		lastNameTxt.sendKeys(lName);
		saveBtn.click();
		
	}
	/**
	 * This method will create contact with organization
	 * @param lName
	 * @param driver 
	 * @param orgName 
	 */
	public void createNewContacts(String lName, WebDriver driver, String orgName)
	{
		lastNameTxt.sendKeys(lName);
		orgPlusBtn.click();
		switchToWindow(driver,"Accounts");
		searchtxt.sendKeys(orgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver,"Contacts");
		saveBtn.click();
	}
	
	
}
