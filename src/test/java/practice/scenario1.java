package practice;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scenario1 {

	public static void main(String[] args) throws InterruptedException {
		
		//launch the browser
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
		//Launch Browser
		driver.get("http://localhost:8888");
		
		//Login to application with valid credentials
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin",Keys.TAB,"admin", Keys.ENTER);
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admim");
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		//Navigate to Contacts link
		driver.findElement(By.partialLinkText("Contacts")).click();
		
		//Click on Create contact look Up Image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//Create Contact with Mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("divraj");
		
		//Save the contacts
		driver.findElement(By.name("button")).click();
	
		//validate
		String contact = driver.findElement(By.xpath("//span[text()='[ CON17 ] divraj  -  Contact Information']")).getText();
		
		if(contact.contains("divraj"))
		{
			System.out.println("pass");
		}
		else {
			System.out.println("fail");
		}
		//signout
		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions a=new Actions(driver);
		a.moveToElement(signout).click().perform();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		System.out.println("signout successful");
	}
	

}
