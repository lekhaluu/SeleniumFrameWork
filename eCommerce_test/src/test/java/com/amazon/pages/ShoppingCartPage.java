package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.base.TestBase;

public class ShoppingCartPage extends TestBase {
	
	
	@FindBy (id="twotabsearchtextbox")
	WebElement searchbar;
	
	@FindBy (linkText="Mens 2-Pack Slim-Fit Crewneck T-Shirt")
	WebElement product;
	
	@FindBy(id="nav-search-submit-button")
	WebElement search;
	
	@FindBy (id="add-to-cart-button")
	WebElement addbtn;
	
	
	@FindBy (xpath="//a[contains(text(),'Go to cart')]")
	WebElement cart;
	
	
	@FindBy (xpath="//span[@id='sc-subtotal-label-activecart']")
	WebElement carttotal;
	
	@FindBy (id="a-autoid-5-announce")
	WebElement addmultiple;
	
	@FindBy (id="sc-subtotal-label-activecart")
	WebElement updtdcart;
	
	@FindBy (xpath="//span[contains(text(),'Abe Froman Sausage King of Chicago')]")
	WebElement multiple;
	
	@FindBy (className= "submit.delete.C90757a8c-da73-4669-94e0-42aeb522408d")
	WebElement del;
	
	@FindBy (id="submit.delete.Cff9b7c33-080e-45d4-8765-be451d77582c")
	WebElement delall;
	
	
	
	//initialize 
	
	public ShoppingCartPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	//action methods
	
	public void SearchBar()
	{
		searchbar.click();
	}
	
	public void ProdSearch(String item)
	{
		searchbar.sendKeys(item);
	}
	
	public void Searchbtn()
	{
		search.click();
	}
	
	public void Select()
	{
		product.click();
		
	}
	
	public void Addcart()
	{
		addbtn.click();
	}
	
     public void GotoCart()
      {
	      cart.click();
       }
	
	public boolean CartTot()
	{
		return carttotal.isDisplayed();
	}
	
	public void AddMultiple(int qty)
	{
		Select Qty = new Select(addmultiple);
		Qty.selectByIndex(qty);
		
	}

	
	public boolean UpdateCart()
	{
		return updtdcart.isDisplayed();
	}
	
	public void multipleprod()
	{
		multiple.click();
	}
	
	public void delete()
	{
		del.click();
	}
	
	public void deleteall()
	{
		delall.click();
	}
	
	
	
	
}
