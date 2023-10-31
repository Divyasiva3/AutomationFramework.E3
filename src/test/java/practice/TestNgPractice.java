package practice;


import org.testng.annotations.Test;

public class TestNgPractice 
{
	@Test
	public void createCustomer()
	{
	System.out.println("create");	
	}
	
	@Test(priority = 0)
	public void modifyCustomer()
	{
	System.out.println("modify");
	}
	
	@Test(priority = 5)
	public void deleteCustomer()
	{
		System.out.println("delete");
		
	}
}
