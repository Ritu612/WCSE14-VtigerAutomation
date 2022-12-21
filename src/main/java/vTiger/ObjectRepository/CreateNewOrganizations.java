package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtilities.WebDriverUtility;

public class CreateNewOrganizations extends WebDriverUtility
{
  // Declaration
	
	@FindBy(name="accountname")
	private WebElement OrgNameText;
	
	@FindBy(name="industry")
	private WebElement IndustryDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//Initialization
	
	public CreateNewOrganizations(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	
	public WebElement getOrgNameText() {
		return OrgNameText;
	}

	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
// Business Library
	/**
	 * This method will create Organization with mandatory fields
	 * @param orgName
	 */
	public void createNewOrgnization(String orgName)
	{
		OrgNameText.sendKeys(orgName);
		saveBtn.click();
	}
	
	/**
	 * This method will create Organization with mandatory fields and industry type
	 * @param orgName
	 * @param industryType
	 */
	public void createNewOrganization(String orgName, String industryType)
	{
		OrgNameText.sendKeys(orgName);
		handleDropDown(IndustryDropDown,industryType);
		saveBtn.click();
		
	}
	
}
