package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

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

/**
 * This class consist of all generic methods related to web driver actions
 * @author sivap
 *
 */

public class WebDriverUtility {
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	/**
	 *  This method will maximize the window
	 * @param driver
	 */
	public void minimize(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method will wait for the page to load
	 * @param driver
	 */
	public void  waitForPageLoad(WebDriver driver)
	{
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
	}
	/**
	 * This method will wait for a  particular element to be visible in the DOM
	 * @param driver
	 */
	
	public void waitForElementToBevisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait for a  particular element to be clickable in the DOM
	 * @param driver
	 * @param element
	 */
	public void waitforElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will  handle drop down by visible text
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This method will  handle drop down by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element, int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * This method will  handle drop down by value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element, String value)
	{
		Select sel=new Select(element);
		sel.selectByValue(value);
	}
	/**
	 * This method will perfom mouse hover actions 
	 * @param driver
	 * @param element
	 */
	
	public void mouseHoverAction(WebDriver driver, WebElement element) 
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
		
	}
	/**
	 * This method will move cursor based on offset and clickon web page 
	 * @param driver
	 */
	public void moveAndClick(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.moveByOffset(10, 10).click().perform();
	}
	/**
	 *  This method will perfom right click action
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.contextClick().perform();
	}
	/**
	 * This method will perfom double click action
	 * @param driver
	 */
	public void doubleClick(WebDriver driver)
	{
		Actions a=new Actions(driver);
		a.doubleClick().perform();
	}
	/**
	 * This method will perform drag and drop operation
	 * @param driver
	 * @param srcEle
	 * @param dstEle
	 */
	public void dragAndDropAction(WebDriver driver,WebElement srcEle, WebElement dstEle)
	{
		Actions a=new Actions(driver);
		a.dragAndDrop(srcEle, dstEle).perform();
	}
	/**
	 * This method will handle frame by index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method will handle frame by Name or Id
	 * @param driver
	 * @param NameorId
	 */
	public void switchToFrame(WebDriver driver,String NameorId)
	{
		driver.switchTo().frame(NameorId);
	}
	/**
	 * This method will handle frame by Web Element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * This method will scroll down by 500 units
	 * @param drivera
	 */
	public void scrollDownAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);","");
		
	}
	/**
	 * This method will scroll up by 500 units
	 * @param driver
	 */
	public void scrollUpAction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500);","");
	}
	/**
	 * This method will accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will cancel the alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will fetch the alert text and return it to caller 
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 *This method will take the ScreenShot and return the destination path
	 * @param driver
	 * @return 
	 * @throws IOException 
	 */
	public String captureScreenShots(WebDriver driver, String ScreenshotName ) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots\\"+ScreenshotName+".png");
		                                     //Scenario1.png
		Files.copy(src, dst);
		return dst.getAbsolutePath();//used for extent reports
	}
	/**
	 * This method will switch from one window to another based on window Title
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		//step 1:get all the window IDs
		Set<String> allWinIds = driver.getWindowHandles();
		
		//step2:Navigate thru each window
		for(String winID:allWinIds)
		{
			//step3: switch to each window and capture the title
			String actTitle = driver.switchTo().window(winID).getTitle();
			
			//step4: Compare act title with expected patial title
			if(actTitle.contains(partialWinTitle))
			{
				break;
			}
		}
	}
}
