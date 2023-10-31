package organizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtilities.ExcelFileUtility;
import genericUtilities.Javautility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInformationPage;
import objectRepository.OrganizationPage;

public class CreateMultipleOrgWithIndustry
{
	
		//Step 1: Create all the required Objects
	Javautility jUtil = new Javautility();
	ExcelFileUtility eUtil = new ExcelFileUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	
	@Test(dataProvider = "gatData")
	public void CreateMultipleOrg(String ORG, String INDUSTRY) throws IOException, InterruptedException
	{
		
	
	WebDriver driver = null;
	
	//Step 2: Read The Required Data
	String BROWSER = pUtil.readDataFromPropertyFile("browser");
	String URL = pUtil.readDataFromPropertyFile("url");
	String USERNAME = pUtil.readDataFromPropertyFile("username");
	String PASSWORD = pUtil.readDataFromPropertyFile("password");
	
	String ORGNAME = ORG+jUtil.getRandomNumber();
	
	//Step 3: Launch the browser
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println(BROWSER+" launched");
	}
	else if(BROWSER.equalsIgnoreCase("Firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		System.out.println(BROWSER+" launched");
	}
	else if(BROWSER.equalsIgnoreCase("Edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		System.out.println(BROWSER+" launched");
	}
	else
	{
		System.out.println("Invalid Browser Name");
	}
	
	wUtil.maximize(driver);
	wUtil.waitForPageLoad(driver);
	
	
	//Step 4: Load the URL
	driver.get(URL);
	
	//step5:Login to Application
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	
	//step6: click on organization
	HomePage hp=new HomePage(driver);
	hp.clickOnOrganisationLink();
	
	//step7:click on Create Organization look up img
	OrganizationPage op=new OrganizationPage(driver);
	op.clickOnOrganizationLookUpImg();
	
	//step8: create new organization with mandatory fields
	CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	cnop.createNewOrganization(ORGNAME, INDUSTRY);
	wUtil.captureScreenShots(driver, ORGNAME);
	
	//step9: validation for organization
	OrganizationInformationPage oip=new OrganizationInformationPage(driver);
	String orgHeader = oip.getHeaderText();
	if(orgHeader.contains(ORGNAME))
	{
		System.out.println(orgHeader);
	}
	
	else
	{
		System.out.println("FAIL");
	}
	
	//step10:logout the application
	hp.logoutTheApp(driver);
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		return eUtil.readMultipleData("multipleorganization");
	}
	
	
	

}


