package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.LoginPage;
import com.amazon.pages.ShoppingCartPage;
import com.amazon.pages.YourAccountPage;

public class ShoppingCartPageTest extends TestBase {
	LoginPage loginpage;
	ShoppingCartPage item;
	YourAccountPage accountpage;
	public ShoppingCartPageTest()
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
		item = new ShoppingCartPage();
	}
	@Test (priority=1)
	public void AddtoCartTest()
	{
		item.SearchBar();
		item.ProdSearch("tshirts");
		item.Searchbtn();
		item.Select();
		item.Addcart();
		item.GotoCart();
		Assert.assertEquals(item.CartTot(), true);
	}
	@Test(priority=2)
	public void AddMultipleTest()
	{
		item.SearchBar();
		item.ProdSearch("tshirts");
		item.Searchbtn();
		item.Select();
		item.Addcart();
		item.GotoCart();
		item.AddMultiple(3);
		item.UpdateCart();
	}
	@Test (priority=3)
	public void MultipleProdTest()
	{
		item.SearchBar();
		item.ProdSearch("tshirts");
		item.Searchbtn();
		item.Select();
		item.Addcart();
		item.GotoCart();
		item.SearchBar();
		item.ProdSearch("tshirts");
		item.multipleprod();
		item.Addcart();
		item.GotoCart();
		Assert.assertEquals(item.UpdateCart(), true);
				
	}
	
	@Test (priority=4)
	public void DeleteTest()
	{
		
		item.SearchBar();
		item.ProdSearch("tshirts");
		item.Searchbtn();
		item.Select();
		item.Addcart();
		item.GotoCart();
		item.SearchBar();
		item.ProdSearch("tshirts");
		item.multipleprod();
		item.Addcart();
		item.GotoCart();
		item.UpdateCart();
		item.delete();
		item.UpdateCart();
		Assert.assertEquals(item.UpdateCart(), true);
			
	}
	 @AfterMethod
	public void teardown()
		{
			driver.quit();
		}	
}
	
	
	
	
	
	
	
	

