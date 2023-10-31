package practice;

import java.io.IOException;

import genericUtilities.ExcelFileUtility;
import genericUtilities.Javautility;
import genericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {
	
	public static void main(String[] args) throws IOException
	{
		PropertyFileUtility putil=new PropertyFileUtility();
		String URL = putil.readDataFromPropertyFile("username");
		System.out.println(URL);
		
		String pw = putil.readDataFromPropertyFile("password");
		System.out.println(pw);
		
		String BROWSER = putil.readDataFromPropertyFile("browser");
		System.out.println(BROWSER);
	
	
	ExcelFileUtility eutil=new ExcelFileUtility();
   String value1 = eutil.readDataFromExcelSheet("contact", 4, 3);
   System.out.println(value1);
   
   Javautility jutil=new Javautility();
   int num = jutil.getRandomNumber();
   System.out.println(num);
   
   
   String date = jutil.getSystemDate();
   System.out.println(date);
   

	}
}
