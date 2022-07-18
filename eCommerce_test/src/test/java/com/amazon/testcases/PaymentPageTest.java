package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.LoginPage;
import com.amazon.pages.PaymentPage;
import com.amazon.pages.SearchPage;
import com.amazon.pages.ShoppingCartPage;
import com.amazon.pages.YourAccountPage;

public class PaymentPageTest extends TestBase {
	
	LoginPage loginpage;
	PaymentPage pay;
	YourAccountPage accountpage;
	SearchPage search;
	ShoppingCartPage item;
	
	public PaymentPageTest()
	{
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
		search= new SearchPage();
        item = new ShoppingCartPage();
}
	
	@Test (priority=1)
	
	public void ProceedTest()
	{
		
		search.SearchBar();
		search.SearchProduct("tshirts");
		search.Searchbtn();
		item.Select();
		item.Addcart();
		pay.Proceed();
		pay.Deliverto();
		pay.Continue();
		
		Assert.assertEquals(pay.Verifyamount(), true);
		
	}
	
	@Test (priority=2)
	
	public void PlaceOrderTest()
	{
		
		search.SearchBar();
		search.SearchProduct("tshirts");
		search.Searchbtn();
		item.Select();
		item.Addcart();
		pay.Proceed();
		pay.Deliverto();
		pay.Continue();
		pay.PlaceOrder();
				
	}
	
	 @AfterMethod
		
		public void teardown()
		{
			driver.quit();
		}
		
	
	
	
}
