package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility 
{
	//Declaration
	@FindBy(linkText ="Contacts")
	private WebElement contactLink;
	
	@FindBy(xpath = "(//a[text()='Organizations'])[1]")
	private WebElement organisationLink;
	
	@FindBy(xpath = "(//img[@style='padding: 0px;padding-left:5px'])[1]")
	private WebElement administatorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;
	
	//Initialization
	public HomePage(WebDriver driver)
	{    
		PageFactory.initElements(driver, this);
	}
	
	//utilization

	public WebElement getContactBtn() {
		return contactLink;
	}

	public WebElement getOrgBtn() {
		return organisationLink;
	}

	public WebElement getSignoutimg() {
		return administatorImg;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
	
	
	//business library
	/**
	 * This method will click on organisation link
	 */
	public void clickOnOrganisationLink()
	{
		organisationLink.click();
	}
	/**
	 * THis method will click on contact link
	 */
	public void clickOnContactLink()
	{
		contactLink.click();
	}
	/**
	 * This Method will logout the application
	 * @param driver
	 * @throws InterruptedException
	 */
	public void logoutTheApp(WebDriver driver) throws InterruptedException
	{
		mouseHoverAction(driver, administatorImg);
		Thread.sleep(1000);
		signoutLink.click();
	}
}
