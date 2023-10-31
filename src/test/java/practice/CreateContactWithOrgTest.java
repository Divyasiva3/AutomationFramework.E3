package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;

public class CreateContactWithOrgTest extends BaseClass
{
	@Test
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException
	{
		String ORGNAME = eUtil.readDataFromExcelSheet("contact", 8, 3)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcelSheet("contact", 8, 2);
		
					
	
		//Step 6: Navigate to Organizations link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 7: Click on Create Organization look Up Imge
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 7: Create Organization with mandatory information
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//Step 8: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 9: Validate
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println(OrgHeader);
			System.out.println("orgnization created successfully");
		}
		else
		{
			System.out.println("FAIL");
		}

		// Step 10: Navigate to Contacts
		driver.findElement(By.linkText("Contacts")).click();

		// Step 11: Click on create Contact look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// Step 12: Create Contact with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

		// Step 13: click on Organization look Up Image
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();

		wUtil.switchToWindow(driver, "Accounts");

		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();

		driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']")).click();
		// Orgname is dynamic
		// xpath is changing dynamically - dynamic xpath
		// a[text()='"+varible+"']

		wUtil.switchToWindow(driver, "Contacts");

		// Step 14: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 15: Validate for Organization
		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		if (ContactHeader.contains(LASTNAME))
		{
			System.out.println(ContactHeader);
			System.out.println("PASS");
		} 
		else 
		{
			System.out.println("FAIL");
		}

	}
	
	

}
