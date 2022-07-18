package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class PaymentPage  extends TestBase {
	
	@FindBy (name="proceedToRetailCheckout")
	WebElement proceed;
	
	@FindBy (xpath="//a[contains(text(),'Deliver to this address')]")
	WebElement deliver;
	
	@FindBy (name="ppw-widgetEvent:SetPaymentPlanSelectContinueEvent")
	WebElement contd;

	@FindBy (css="#subtotals-marketplace-table > tbody > tr:nth-child(9) > td.a-color-price.a-size-medium.a-text-right.grand-total-price.aok-nowrap.a-text-bold.a-nowrap")
    WebElement 	amnt;
	
	@FindBy (name="placeYourOrder1")
	WebElement placeorder;
	
	
	
	//initialize
	
public PaymentPage() 
{
PageFactory.initElements(driver, this);
}




//action methods
	
	public void Proceed()
	{
		proceed.click();
	}
	
	
	public void Deliverto()
	{
		deliver.click();
	}
	
	public void Continue()
	{
		contd.click();
	}
	
	
	public boolean Verifyamount()
	{
		return amnt.isDisplayed();
	}
	
	
	public void PlaceOrder()
	{
		placeorder.click();
	}
	
}
