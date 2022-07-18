package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class YourOrdersPage extends TestBase {
	
	
	@FindBy(xpath="//h2[contains(text(),'Your Orders')]")
	WebElement ordersbtn;
	
	@FindBy(linkText="Buy Again")
	WebElement buyagn;
	
	@FindBy(xpath="//body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/span[1]")
	WebElement buyagntext;
	
	@FindBy(xpath="//a[contains(text(),'Not Yet Shipped')]")
	WebElement notshpd;
	
	@FindBy(xpath="//body/div[@id='a-page']/div[@id='yourOrders']/div[@id='yourOrdersContent']/div[@id='ordersContainer']/div[1]/div[1]")
	WebElement notshpdtext;
	
	@FindBy(linkText="Cancelled Orders")
	WebElement cancld;
	
	@FindBy(xpath="//body/div[@id='a-page']/div[@id='yourOrders']/div[@id='yourOrdersContent']/div[@id='ordersContainer']/div[1]/div[1]")
    WebElement cancldtext;

//Initialize elements with help of page factory class

		public YourOrdersPage() {
			
			PageFactory.initElements(driver, this);
		}
	
		
		 //Action methods of your account page 
		
		
		public void Yourorders()
		{
			  ordersbtn.click();
		}
		
		public void Buyagain()
		{
			buyagn.click();
		}
		
		public String Buyagaintext()
		{
			return buyagntext.getText();
		}
		
		public void Notshipped()
		{
			notshpd.click();
		}
		
		public String NotShippedtext() 
		{
			
			return notshpdtext.getText();
		}
		
       public void cancelledorders()
       {
    	   cancld.click();
       }
       
       public String cancelledorderstext()
       {
    	   return cancldtext.getText();
       }




}
