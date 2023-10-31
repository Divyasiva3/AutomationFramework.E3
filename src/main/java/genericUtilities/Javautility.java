package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * This class consist of generic methods related to java
 * @author sivap
 *
 */
public class Javautility {
	/**
	 * This Method will generate a random number for every run and return it to caller
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran=new Random();
		int r = ran.nextInt(1000);
		return r;
		
		
	}
	/**
	 * This Method will generate a date for every run and return it to caller
	 * @return
	 */
	
	public String getSystemDate()
	{
		Date d=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		 String date = formatter.format(d);
		return date;
	}
	

}
