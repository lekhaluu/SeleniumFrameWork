package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;

import com.amazon.pages.SearchPage;


public class SearchPageTest extends TestBase {
	
	SearchPage search;
	
	public SearchPageTest()
	{
		super();
	}
	@BeforeMethod
    public void setup() 
	{
	initialization();
     search= new SearchPage();	
	}
	
	@Test (priority=1)
	public void SearchBarTest()
	{
		search.SearchBar();
	}
	@Test (priority=2)
	public void SearchProductTest()
	{
		search.SearchProduct("tshirts");
		search.Dept("Clothing, Shoes & Jewelry");
		search.Searchbtn();
	}
	@Test(priority=3)
	
	public void DeptSpecificTest()
	
	{
		search.SearchProduct("tshirts");
		search.Dept("Clothing, Shoes & Jewelry");
		search.Searchbtn();
		Assert.assertEquals(search.Deptname(), true);
	
	}
	@Test (priority=4)
	 public void DeptAllTest() throws InterruptedException
	
	{
		search.SearchProduct("tshirts");
		search.Dept("All Departments");
		search.Searchbtn();
	    Thread.sleep(3000);
	}
	
	@Test (priority=5)
	public void ProductInfoTest() throws InterruptedException
	{
		search.SearchProduct("B07BN15B37");
		search.Dept("All Departments");
		search.Searchbtn();
		Assert.assertEquals(search.ProductInfo(),true);
        Thread.sleep(3000);
	}
	@Test (priority=6)
	public void ProductTest()
	{
		search.SearchProduct("tshi");
		Assert.assertEquals(search.Product(), true);
		
	}
	@Test (priority=7)
	public void ProductCountTest() throws InterruptedException
	{
		search.SearchProduct("tshirts");
		search.Dept("All Departments");
		search.Searchbtn();
		Assert.assertEquals(search.ProductCount(), false);
		Thread.sleep(2000);
	}
	@Test (priority=8)
	public void NextPageTest() throws InterruptedException
	{
		search.SearchProduct("tshirts");
		search.Dept("All Departments");
		search.Searchbtn();
		search.NextPage();
		search.VerifyPage();
		Assert.assertEquals(search.VerifyPage(), true);
		Thread.sleep(3000);	
	}
	 @AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
}
