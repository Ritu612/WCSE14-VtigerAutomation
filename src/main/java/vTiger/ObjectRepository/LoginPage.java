package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  //Rule 1
{
   
	//Rule 2: Declaration
	@FindBy(name="user_name")
   private WebElement usernameEdt;
   
   @FindBy(name="user_password")
   private WebElement passwordEdt;
   
   @FindBy(id="submitButton")
   private WebElement submitBtn;
   
   //Rule 3:- Initialization
   
   public LoginPage(WebDriver driver)
   {
	   PageFactory.initElements(driver,this);
   }


   // Rule 4:- Utilization
   
   public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	   
	// Rule 5: Business Libraries
	// It is a generic methods which you can write only to this page
	/**
	 * This business library will perform login action
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username,String password)
	{
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		submitBtn.click();
		
	}
	
	
}
