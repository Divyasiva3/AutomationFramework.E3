package practice;

import org.testng.annotations.Test;

public class AssertionPractice
{
	@Test
	public void practice()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		
		if(1==0)
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		System.out.println("Step3");
		System.out.println("Step4");
	}
	

}
