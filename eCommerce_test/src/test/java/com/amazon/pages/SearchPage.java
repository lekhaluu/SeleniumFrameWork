package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.base.TestBase;

public class SearchPage extends TestBase {
	
	@FindBy (xpath= "//input[@id='twotabsearchtextbox']")
	WebElement searchtab;
	
	@FindBy (id="nav-search-submit-button")
	WebElement searchbtn;
	
	@FindBy (id="searchDropdownBox")
	WebElement searchdropdown;
	
	@FindBy (xpath="//span[contains(text(),'Clothing, Shoes & Accessories')]")
	WebElement deptname;
	
	@FindBy (xpath="//span[contains(text(),'Polo Ralph Lauren Womens Crew Neck T-Shirt')]")
	WebElement prodinfo;
	
	@FindBy (xpath="//span[contains(text(),'1-48 of over 100,000 results for')]")
	WebElement count;
	
	@FindBy (linkText="Next")
	WebElement nextpage;
	
	@FindBy (xpath="//span[contains(text(),'49-96 of over 100,000 results for')]")
	WebElement secondpage;
	
//initialize
	public SearchPage() 
	    {
		PageFactory.initElements(driver, this);
		}
	  
	 //Action methods 
	 
	public void SearchBar() 
	{
	searchtab.click();
	}
    public void SearchProduct(String keyword) 
    {		
    searchtab.sendKeys(keyword);;
	}
    public void Dept(String dep)
	{
	Select dropdept = new Select(searchdropdown);
		dropdept.selectByVisibleText(dep);
	}
    public void Searchbtn()
    {
    	searchbtn.click();
    }
    
   
    public boolean Deptname()
    {
	return deptname.isDisplayed();
    }

    public boolean ProductInfo()
    {
	return prodinfo.isDisplayed();
     }
	public boolean Product()
	{
		return searchtab.isEnabled();
	}
	
	public boolean ProductCount()
	{
		return count.isDisplayed();
	}
    public void NextPage()
    {
    	nextpage.click();
    }

     public boolean VerifyPage()
     {
    	  return secondpage.isDisplayed();
     }




















}

