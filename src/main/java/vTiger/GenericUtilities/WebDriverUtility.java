
package vTiger.GenericUtilities;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
/**
 *  This class contains generic methods to perform all web driver related actions.
 */
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility 
{
	/**
	 * This method will maximize the window when its called
	 * @param driver
	 */
   public void maximiseWindow(WebDriver driver)
   {
	   driver.manage().window().maximize();
   }
   
   /**
    * This method will minimise the window
    * @param driver
    */
   public void minimiseWindow(WebDriver driver)
   {
	   driver.manage().window().minimize();
   }
   
   /**
    * This method will wait for entire page to load for 20secs.
    * @param driver
    */
   public void waitForPageLoad(WebDriver driver)
   {
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
   }
   /**
    * This method is used to wait for a element to be visible
    * @param driver
    * @param element
    */
   public void waitForElementToBeVisible(WebDriver driver,WebElement element)
   {
	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	   wait.until(ExpectedConditions.visibilityOf(element));
   }
   
  /**
   * This method will wait for element to be clickable
   * @param driver
   * @param element
   */
   public void waitForElementToBeClickable(WebDriver driver,WebElement element)
   {
	   WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element)) ;
   }
   
   /**
    * This is a custom wait for a second to wait for element to become clickable
    * @param element
    * @throws InterruptedException
    */
   public void customWaitForSecond(WebElement element) throws InterruptedException
   {
	   int count=0;
	   while(count<10)
	   {
		   try
		   {
			   element.click(); // exception
			   break;
		   }
		   
		   catch(Exception e)
		   {
			  Thread.sleep(1000);
			  count++;
			  
		   }
	   }
	   
   }
   /**
    * This method will handle drop down based on index value
    * @param element
    * @param index
    */
   public void handleDropDown(WebElement element,int index)
   {
	   Select s=new Select(element);
	   s.selectByIndex(index);
	   
   }
   
  /**
   * This method will handle drop down based on  value
   * @param element
   * @param value
   */
   public void handleDropDown(WebElement element,String value)
   {
	   Select s=new Select(element);
	   s.selectByValue(value);
   }
   
   /**
    * This method will handle drop down based on  visible text
    * @param visibleText
    * @param element
    */
   public void handleDropDown(String visibleText,WebElement element)
   {
	   Select s=new Select(element);
	   s.selectByVisibleText(visibleText);
   }
   
  /**
   * This method will perform mouseHover Action
   * @param driver
   * @param element
   */
   public void mouseHoverAction(WebDriver driver,WebElement element)
   {
	   Actions a=new Actions(driver);
	   a.moveToElement(element).perform();
	   
   }
   
   public void mouseHoverAction(WebDriver driver,WebElement element, int x, int y)

{
	  Actions a=new Actions(driver);
	  a.moveToElement(element, x, y).perform();
}
   
   
  /**
   * This method will perform right click randomly on the web page
   * @param driver
   */
   public void rightClickAction(WebDriver driver)
   {
	   Actions a=new Actions(driver);
	   a.contextClick().perform();
   }
   
   /**
    * This method will perform right click particular web element
    * @param driver
    */
   public void rightClickAction(WebDriver driver,WebElement element)
   {
	   Actions a=new Actions(driver);
	   a.contextClick(element).perform();
   }
   
   /**
    * This method will perform double click randomly on web page
    * @param driver
    */
   public void doubleClickAction(WebDriver driver)
   {
	   Actions a=new Actions(driver);
	   a.doubleClick().perform();
   }
   
   /**
    * This method will perform double click on particular web element
    * @param driver
    * @param element
    */
   public void doubleClickAction(WebDriver driver,WebElement element)
   {
	   Actions a=new Actions(driver);
	   a.doubleClick(element).perform();
   }
   
   /**
    * This method will drag and drop from source element to target element
    * @param driver
    * @param srcElement
    * @param tarElement
    */
   public void dragAndDrop(WebDriver driver,WebElement srcElement,WebElement tarElement)
   {
	   Actions a=new Actions(driver);
	   a.dragAndDrop(srcElement, tarElement).perform();
   }
   
   /**
    * This method will press and release the enter key
    * @throws AWTException
    */
   public void pressEnterKey() throws AWTException
   {
	   Robot r=new Robot();
	   r.keyPress(KeyEvent.VK_ENTER);
	   r.keyRelease(KeyEvent.VK_ENTER);
	   
   }
   
   /**
    * This method will switch to frame based on index
    * @param driver
    * @param index
    */
   public void switchToFrame(WebDriver driver, int index)
   {
	   driver.switchTo().frame(index);
   }
   
  /**
   * This method will switch to frame based on name or ID
   * @param driver
   * @param nameOrID
   */
   public void switchToFrame(WebDriver driver, String nameOrID)
   {
	   driver.switchTo().frame(nameOrID);
   }
   
   
   /**
    * This method will switch to frame based on web element
    * @param driver
    * @param element
    */
   public void switchToFrame(WebDriver driver, WebElement element)
   {
	   driver.switchTo().frame(element);
   }
   
  /**
   * This method will switch to default frame
   * @param driver
   */
   public void switchToDefaultFrame(WebDriver driver)
   {
	   driver.switchTo().defaultContent();
   }
   
   /**
    * This method will scroll down for 500 unti
    * @param driver
    */
   public void scrollAction(WebDriver driver)
   {
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("window.scrollBy(0,500)", "");
   }
   /**
    * This method will scroll until a particular element
    * @param driver
    * @param element
    */
   public void scrollAction(WebDriver driver,WebElement element)
   {
	   JavascriptExecutor js=(JavascriptExecutor)driver;
	   int y=element.getLocation().getY();
	   js.executeScript("window.scrollBy(0,"+y+")",element);
   }
   
   /**
    * This method will take screenshot and save it in screenshot folder
    * @param driver
    * @param screenShotName
    * @return
 * @throws IOException 
    */
   public String taketheScreenShot(WebDriver driver,String screenShotName) throws IOException
   {
	   TakesScreenshot ts=(TakesScreenshot) driver;
	   File src=ts.getScreenshotAs(OutputType.FILE);
	   File dst=new File("./ScreenShots/"+screenShotName+".png" );
	   Files.copy(src, dst);
	   return dst.getAbsolutePath(); // used for extent Reports
}

   /**
    * This method will switch to window based on partial window title
    * @param driver
    */
   public void switchToWindow(WebDriver driver,String partialWinTitle)
   {
	   // no duplication so set of string return type
	   Set<String> allWindows = driver.getWindowHandles();
	   for(String indwindow:allWindows)
	   {
		   String currentWinTitle=driver.switchTo().window(indwindow).getTitle();
		   if(currentWinTitle.contains(partialWinTitle))
		   {
			   break;
		   }
	   }
   }
   
   
}
