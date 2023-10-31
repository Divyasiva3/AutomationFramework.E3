package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage
{
	//Declaration
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgLookupImg;
	
	//initialization
	public  OrganizationPage(WebDriver driver) 
	{
	PageFactory.initElements(driver, this);	
	
	}
	//utilization
	
	public WebElement getLookupImg()
	{
		return createOrgLookupImg;
	}
	
	//Business Library
	/**
	 * This method will click on create org look up img
	 */
	public void clickOnOrganizationLookUpImg()
	{
		createOrgLookupImg.click();
	}
	

}
