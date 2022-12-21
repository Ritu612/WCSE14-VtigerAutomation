package vTiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

/**
 * This class consists of Basic Configuration annotations.
 * @author DELL
 *
 */
public class BaseClass 
{
   
	public PropertyFileUtility pUtil=new PropertyFileUtility();
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public JavaUtility jUtil=new JavaUtility();
	public WebDriverUtility wUtil=new WebDriverUtility();
	public static WebDriver sdriver=null;
	
	public WebDriver driver=null;
	
	@BeforeSuite(groups={"RegressionSuite","smokeSuite"})
   public void bsConfig()
   {
	   System.out.println("Database Connection successful");
   }
   
  // @Parameters("BROWSER")
   // @BeforeTest
   @BeforeClass(groups={"RegressionSuite","smokeSuite"})
   public void bcConfig(/*String BROWSER*/) throws IOException
   {
	 String BROWSER= pUtil.readDataFromPropertyFile("browser"); 
     String URL= pUtil.readDataFromPropertyFile("url");
     if(BROWSER.equalsIgnoreCase("chrome"))
     {
    	 WebDriverManager.chromedriver().setup();
    	 driver=new ChromeDriver();
    	 System.out.println("======="+BROWSER+"====Browser is launched====");
    	 
     }
     else if(BROWSER.equalsIgnoreCase("Firefox"))
     {

    	 WebDriverManager.firefoxdriver().setup();
    	 driver=new FirefoxDriver();
    	 System.out.println("======="+BROWSER+"====Browser is launched====");
     }
     
     else
     {
    	 System.out.println("Invalid browser");
     }
     
     
     sdriver=driver;
     wUtil.maximiseWindow(driver);
     wUtil.waitForPageLoad(driver);
     driver.get(URL);
   }
   
  @BeforeMethod(groups={"RegressionSuite","smokeSuite"})
  
  public void bmConfig() throws IOException
  {
	  String USERNAME=pUtil.readDataFromPropertyFile("username");
	  String PASSWORD=pUtil.readDataFromPropertyFile("password");
	  
	  LoginPage lp=new LoginPage(driver);
	  lp.loginToApp(USERNAME, PASSWORD);
	  System.out.println("===Login to app is successful==");
	  
  }
  
  @AfterMethod(groups={"RegressionSuite","smokeSuite"})
  
  public void amConfig()
  {
     HomePage hp=new HomePage(driver);
     hp.logOutOfApp(driver);
     System.out.println("=====Logout from app successfully");
  }
  
 
 //@AfterTest()
  @AfterClass(groups={"RegressionSuite","smokeSuite"})
  
  public void acConfig()
  {
	  driver.quit();
	  System.out.println("======Browser is closed======");
  }
  
  @AfterSuite(groups={"RegressionSuite","smokeSuite"})
  
  public void asConfig()
  {
	  System.out.println("====DataBase connection is closed====");
  }
}
