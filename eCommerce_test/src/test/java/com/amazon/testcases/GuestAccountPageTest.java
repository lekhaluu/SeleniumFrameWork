package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.GuestAccountPage;

public class GuestAccountPageTest extends TestBase {
	
	GuestAccountPage guest;
	
	public GuestAccountPageTest()
	{
		super();
	}
	@BeforeMethod
    public void setup() 
    {
	initialization();
	guest = new GuestAccountPage();
	}	
	@Test
	public void SearchBarTest() throws InterruptedException
	{
		guest.SearchBar();
		guest.Searchbox("tshirts");
		guest.Keyword();
		guest.select();
		guest.AddCart();
		guest.Checkout();
		boolean act= guest.Signin();
		Assert.assertEquals(act, false);
	}
		
    @AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
