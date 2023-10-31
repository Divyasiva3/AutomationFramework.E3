package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import objectRepository.ContactInformationPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.CreateNewOrganizationPage;
import objectRepository.HomePage;
import objectRepository.OrganizationInformationPage;
import objectRepository.OrganizationPage;

public class CreateContactForGroup  extends BaseClass
 {
	@Test(groups="SmokeSuite")
	public void  CreateContact()  throws EncryptedDocumentException, IOException
	{
		
		String LASTNAME = eUtil.readDataFromExcelSheet("contact", 8, 2);
		
		
		
		//step10:click on  contact link
		HomePage hp=new HomePage(driver);
		hp.clickOnContactLink();
		
		//step11: click on create contact look up image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnContactLookUp();
		
		//step12:create conatct with organization
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		
		//step13:validation using ASSERTION
		ContactInformationPage cip=new ContactInformationPage(driver);
		String conHeader=cip.getHeaderText();
		Assert.assertTrue(conHeader.contains(LASTNAME));
		System.out.println(conHeader);
			
	}
		
	}

