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

public class CreateContactWithOrgAssertTest extends BaseClass
{
	@Test
	public void CreateContactWithOrgAssertTest() throws EncryptedDocumentException, IOException
	{
		String ORGNAME = eUtil.readDataFromExcelSheet("contact", 8, 3)+jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromExcelSheet("contact", 8, 2);
		
		
		
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
		Assert.assertTrue(orgHeader.contains(ORGNAME));
			System.out.println(orgHeader);
		
		
	
		//step10:click on  contact link
		hp.clickOnContactLink();
		
		//step11: click on create contact look up image
		ContactsPage cp=new ContactsPage(driver);
		cp.clickOnContactLookUp();
		
		//step12:create conatct with organization
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(driver, LASTNAME, ORGNAME);
		
		//step13:validation using ASSERTION
		ContactInformationPage cip=new ContactInformationPage(driver);
		String conHeader=cip.getHeaderText();
		Assert.assertTrue(conHeader.contains(LASTNAME));
		System.out.println(conHeader);
			
	}
}
