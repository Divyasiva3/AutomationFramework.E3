package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.Javautility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import objectRepository.LoginPage;

public class CreateContactWithPOM {

	public static void main(String[] args) throws IOException {
		
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
				
				String ORGNAME = eUtil.readDataFromExcelSheet("Organization", 1, 2)+jUtil.getRandomNumber();
				
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
				
				//Step 5: Login to Application
				//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);            //for login it contain 3 lines 
				//driver.findElement(By.id("submitButton")).click();
				
				//LoginPage lp=new LoginPage(driver);
				//lp.getUserNameEdt().sendKeys(USERNAME);
				//lp.getPasswordEdt().sendKeys(PASSWORD);									//for login it also contain 3 lines so no code optimization so we go for business library
				//lp.getLoginBtn().click();
				

				
				//Business library
				LoginPage lp=new LoginPage(driver);
				lp.loginToApp(USERNAME,PASSWORD);
				
}
}