package practice;

import org.testng.annotations.Test;

public class DataProvider
{
	@Test(dataProvider = "getData")
	public void addProductToCart(String name, int price, int qty, String model)
	{
		System.out.println("phone name is  " +name+ "  price  " +price+  "  Qty  "  +qty+  "  model  "  +model);
		
	}
	
	@org.testng.annotations.DataProvider
	public Object[][] getData()
	{
								//row col
		Object[][] data=new Object[3][4];   //3 sets of data with 4 details in each set
		
		data[0][0]="samsung";
		data[0][1]=10000;
		data[0][2]=20;
		data[0][3]="A80";
		
		data[1][0]="nokia";
		data[1][1]=12000;
		data[1][2]=10;
		data[1][3]="A80";
		
		data[2][0]="Iphone";
		data[2][1]=15000;
		data[2][2]=20;
		data[2][3]="s14";
		
		return data;
		
	}

}
