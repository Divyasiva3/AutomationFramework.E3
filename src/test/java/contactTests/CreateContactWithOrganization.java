package contactTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import genericUtilities.ExcelFileUtility;
import genericUtilities.Javautility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.ContactInformationPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.OrganizationInformationPage;
import objectRepository.OrganizationPage;

public class CreateContactWithOrganization 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	
	{
	
		//Step 1: Create all the required Objects
		Javautility jUtil = new Javautility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		WebDriver driver = null;
		
		//Step 2: Read The Required Data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String ORGNAME = eUtil.readDataFromExcelSheet("contact", 8, 3)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcelSheet("contact", 8, 2);
		
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
		
		//step 5:Login to application
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//step 6:  click on org link
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganisationLink();
		
		//step 7: click on look up img
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnOrganizationLookUpImg();
		
		//step 8: create organization
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		
		
		//step 9: validation
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String orgHeader = oip.getHeaderText();
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println(orgHeader);
			System.out.println("Organization Created");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//step10:click on  contact link
		hp.clickOnContactLink();
		
		//step11: click on create contact look up image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnContactLookUp();
		
		//step12:create conatct with organization
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(driver, LASTNAME, ORGNAME);
		
		//step13:validation
		ContactInformationPage cip=new ContactInformationPage(driver);
		String conHeader=cip.getHeaderText();
		if(conHeader.contains(LASTNAME))
		{
			System.out.println(conHeader);
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
		
		//step14:logout the application
		hp.logoutTheApp(driver);
		//step15: Close the Browser
		driver.quit();
	}
}
