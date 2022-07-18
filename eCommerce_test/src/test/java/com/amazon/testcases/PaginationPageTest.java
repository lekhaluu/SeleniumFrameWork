package com.amazon.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.PaginationPage;

public class PaginationPageTest extends TestBase {
	
	PaginationPage page;

	public PaginationPageTest() {
		super();
	}
	
	@BeforeMethod
    public void setup() 
	{
	initialization();
	page =new PaginationPage();
	}
	@Test 
	public void SortedTest()
	{
		page.SearchBar();
		page.SearchProduct("kid shoes");
		page.Searchbtn();
		page.SortByDropdown("Price: Low to High");
		page.Sortedpagelist();
	}
	@Test
	public void FilterTest()
	{
		page.SearchBar();
		page.SearchProduct("kid shoes");
		page.Searchbtn();
		page.Filter();
		page.FilterPagelist();	
	}
	@Test
	public void Paginationtest() throws InterruptedException
	{
		page.SearchBar();
		page.SearchProduct("kid shoes");
		page.Searchbtn();
		page.Pagination();
		Thread.sleep(3000);
	}
   @AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
}