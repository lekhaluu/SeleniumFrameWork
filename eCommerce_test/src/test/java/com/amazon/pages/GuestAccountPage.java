package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class GuestAccountPage  extends TestBase {
	
	
	
	@FindBy(id="twotabsearchtextbox")
	WebElement search;
	
	@FindBy (xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchbox;
	
	@FindBy (id="nav-search-submit-button")
	WebElement submit;
	
	@FindBy (linkText="Mens 2-Pack Crewneck T-Shirts")
	WebElement tshirt;
	
	@FindBy (name="submit.add-to-cart")
	WebElement addtocart;
	
	@FindBy (xpath= "//input[@name='proceedToRetailCheckout']")
	WebElement proceed;
	
	@FindBy (xpath="//label[@for='ap_email']")
	WebElement signin;
	
	
	//initialize
	
     public GuestAccountPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	//action methods
	
	
	public void SearchBar()
	{
		search.click();
		
	}
	public void Searchbox(String keyword)
	{
		searchbox.sendKeys(keyword);
	}
	public void Keyword()
	{
		submit.click();
	}
	
	public void select()
	{
		tshirt.click();
	}
	
	public void AddCart()
	{
		addtocart.click();
	}
	
	public void Checkout()
	{
		proceed.click();
	}
	public boolean Signin()
	{
		return signin.isDisplayed();
	}
	
	
}
