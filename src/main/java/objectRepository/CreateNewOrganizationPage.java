package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility

{
	//Declaration
	
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgNameEdt;
	
	@FindBy(name = "industry")
	private  WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;
	
	//initialization
	public  CreateNewOrganizationPage (WebDriver driver) 
	{
	PageFactory.initElements(driver, this);	
	
	}
	//utilization

	public WebElement getLastNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	
	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn()
	{
		return saveBtn;
	}
	//Business Library
	/**
	 * This method will create new organisation with mandatory fields
	 * @param ORGNAME
	 */
	public void createNewOrganization(String ORGNAME)
	{
		orgNameEdt.sendKeys(ORGNAME);
		saveBtn.click();
	}
	/**
	 *  This method will create new organisation with industry drop down
	 * @param ORGNAME
	 * @param INDUSTRY
	 */
	public void createNewOrganization(String ORGNAME, String INDUSTRY)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropDown(industryDropDown,INDUSTRY);
		saveBtn.click();
	}
	
	/**
	 * 	 *  This method will create new organisation with industry drop down and type drop down
	 * @param ORGNAME
	 * @param INDUSTRY
	 * @param TYPE
	 */
	public void createNewOrganization(String ORGNAME, String INDUSTRY, String TYPE)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropDown(industryDropDown,INDUSTRY);
		handleDropDown(typeDropDown,TYPE);
		saveBtn.click();
		
	}
}
