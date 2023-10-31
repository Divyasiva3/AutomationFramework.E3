package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario4 {
	
public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
		//launch the browser
		driver.get("http://localhost:8888");
		
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin", Keys.ENTER);
		//driver.findElement(By.name("user_password")).sendKeys("admin");
		//driver.findElement(By.id("submitButton")).click();
		
		//Navigate to Organizations link 
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		//Click on Create Organization look Up Image 
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//create organization
		driver.findElement(By.name("accountname")).sendKeys("saathvik prasanna");
		WebElement industrydd = driver.findElement(By.name("industry"));
		Select s=new Select(industrydd);
		s.selectByValue("Chemicals");
		
		WebElement type = driver.findElement(By.xpath("accounttype"));
		Select s1=new Select(type);
		s.selectByValue("Customer");
		
		//save
		driver.findElement(By.name("button")).click();

}

}
