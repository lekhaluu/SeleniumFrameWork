package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.LoginPage;
import com.amazon.pages.YourAccountPage;
import com.amazon.pages.YourOrdersPage;

public class YoursOrdersPageTest extends TestBase {
	
	LoginPage loginpage;
	YourAccountPage accountpage;
	YourOrdersPage orderspage;
	
	public YoursOrdersPageTest() {
		
		super();
	}

	@BeforeMethod
    public void setup() 
	{
	initialization();
	loginpage= new LoginPage();
	loginpage.signin();
	loginpage.typeemail(prop.getProperty("username"));
	loginpage.continuebtn();
	loginpage.typepass(prop.getProperty("password"));
	loginpage.rememberme();
	accountpage = loginpage.submitbtn();
	accountpage.clickablelink();
	
	orderspage = new YourOrdersPage();
	}
	
	
	@Test (priority=1)
	
	public void YourordersTest() {
		
		orderspage.Yourorders();
		
	}
	
	@Test (priority=2)
	public void BuyagainTest()
	{
		orderspage.Yourorders();
		orderspage.Buyagain();
	    String actual= orderspage.Buyagaintext();
	    Assert.assertEquals(actual, "There are no recommended items for you to buy again at this time. Check Your Orders for items you previously purchased.");
	    System.out.println(actual);
	    
	}
		
	@Test  (priority=3)
	public void NotShippedTest()
	{
		orderspage.Yourorders();
		orderspage.Notshipped();
		String actual= orderspage.NotShippedtext();
		Assert.assertEquals(actual, "Looking for an order? All of your orders have shipped. View all orders");
		System.out.println(actual);
	}
	
	@Test (priority=4)
	public void CancelledTest()
	{
		orderspage.Yourorders();
		orderspage.cancelledorders();
		String actual= orderspage.cancelledorderstext();
	    Assert.assertEquals(actual, "We aren't finding any cancelled orders (for orders placed in the last 6 months). View all orders");
	    System.out.println(actual);
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
