package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage //rule:1 class name should be same as page name
{
		//rule:2 declaration
	
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdt;
	
	@FindAll({@FindBy(id = "submitButton"),@FindBy(xpath = "//input[@value='Login'])[2]")})
	private WebElement loginBtn;
	
	//rule:3 initialization
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);	
	}
	
	
	//rule:4 Utilization

	public WebElement getUserNameEdt()
	{
		return userNameEdt;
	}

	public WebElement getPasswordEdt() 
	{
		return passwordEdt;
	}

	public WebElement getLoginBtn()
	{
		return loginBtn;
	}
	/**
	 * This method will login to application
	 * @param USERNAME
	 * @param PASSWORD
	 */
	//Business library -generic method according to project
	public void loginToApp(String USERNAME, String PASSWORD) 
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
	
}