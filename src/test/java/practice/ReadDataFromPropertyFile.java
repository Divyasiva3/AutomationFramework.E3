package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		
		//step1 open the document in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step2 create object of properties for java .util package
		Properties p=new Properties();
		//step3 load the file input stream into properties
		p.load(fis);
		//step4 provide the key and read the value
		String value = p.getProperty("username");
		System.out.println(value);
	}

}
