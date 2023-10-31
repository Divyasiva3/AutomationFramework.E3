package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v112.v112CdpInfo;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage 
{
	//Declaration
	
			@FindBy(xpath ="//img[@alt='Create Contact...']")
			private WebElement contactlookupImg;
			
						
			//initialization
			public  ContactsPage (WebDriver driver) 
			{
			PageFactory.initElements(driver, this);	
			
			}
			
			//utilization


			public WebElement getContactlookupImg() {
				return contactlookupImg;
			}
			
			//Business Library
			/**
			 * This method will clock on create contact look up image
			 */
			public void clickOnContactLookUp()
			{
				contactlookupImg.click();
			}

}
