package com.amazon.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.base.TestBase;

public class YourAccountPage extends TestBase {
	
	@FindBy (id="nav-link-accountList")
	WebElement hellotxt;
	
	@FindBy (className= "nav-line-2")
	WebElement hellolist;
	
	@FindBy (id="nav-link-accountList-nav-line-1")
	WebElement hellolink;
	
	
	@FindBy (xpath="//h2[contains(text(),'Your Orders')]")
	WebElement orderspage;
	
	@FindBy (xpath="//h2[contains(text(),'Login & security')]")
	WebElement loginsecuritypage;
	
	@FindBy (xpath="//h2[contains(text(),'Your Addresses')]")
	WebElement addresspage;
	
	@FindBy (xpath="//h2[contains(text(),'Your Payments')]")
	WebElement paymentspage;
	
	
	//Initialize elements with help of page factory class
	
		public YourAccountPage() {
			
			PageFactory.initElements(driver, this);
		}
		
   //Action methods of your account page 
		
	
		public String verifyhellotext()
		{
			return hellotxt.getText();
			
		}
		
		public boolean hellodropdown()
		{
		   return hellolist.isEnabled();
	  		 
		}
		
		public YourAccountPage clickablelink()
		{
			hellolink.click();
			
			return new YourAccountPage();
		}
		
		public YourOrdersPage yourorderspage()
		{
			orderspage.click();
			
			return new YourOrdersPage();
		}
	
		
		public LoginSecurityPage loginsecuritypage()
		{
			loginsecuritypage.click();
			
			return new LoginSecurityPage();
		}
		
		public YourAddressPage addresspage()
		{
			addresspage.click();
			
			return new YourAddressPage();
		}
		
		public YourPaymentsPage paymentspage()
		{
			paymentspage.click();
			
			return new YourPaymentsPage();
		}
}

