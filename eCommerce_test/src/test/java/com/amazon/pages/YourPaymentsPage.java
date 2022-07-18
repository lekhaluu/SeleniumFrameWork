package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.amazon.base.TestBase;

public class YourPaymentsPage extends TestBase {
	
	
	@FindBy (xpath="//h2[contains(text(),'Your Payments')]")
	WebElement paymentbtn;
	
	@FindBy (linkText="Add a payment method")
	WebElement addpayment;
	
	@FindBy (xpath="//body/div[@id='a-page']/div[4]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]/input[1]")
	WebElement addcard;
	
	
	@FindBy (name="addCreditCardNumber")
	WebElement cardnumber;

	@FindBy (name="addCreditCardNumber")
	WebElement carddetails;
	
	@FindBy (name="ppw-accountHolderName")
	WebElement nameoncard;
	
	@FindBy (className="a-dropdown-prompt")
	WebElement month;
	
	@FindBy (className="a-button-text a-declarative")
	WebElement year;
	
	@FindBy (name="ppw-widgetEvent:AddCreditCardEvent")
	WebElement add;
	
	@FindBy (className="ppw-widgetEvent:SavePaymentMethodDetailsEvent")
	WebElement savebtn;
	
	@FindBy (id="a-list-item")
	WebElement successmsg;
	
	//initialize
	
	public YourPaymentsPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	//action class
	
	public void YourPayments()
	{
		paymentbtn.click();
		
	}
	public void AddPayment()
	{
		addpayment.click();
		
	}
	public void AddCard()
	{
		addcard.click();
	}
  public void Frame()
  {
	  driver.switchTo().frame(0);
  }
  public void Cardnumber()
  {
	  cardnumber.click();
  }
  
  public void CardDetails(String number)
  
  {
	  carddetails.sendKeys(number);
  }
  
  public void Name(String name)
  {
	  nameoncard.sendKeys(name);
  }
  
  public void Expirymonth(int index)
  {
	Select dropmonth = new Select(month);
	 dropmonth.selectByIndex(index);
	 
  }
  
  public void Expiryyear(int index)
  {
	  Select dropyear= new Select(year);
	  dropyear.selectByIndex(index);
  }
  
  public void AddCardDetails()
  {
	  add.click();
  }
  
  public void SaveButton()
  {
	  savebtn.click();
  }
  
  public boolean Success()
  {
	  return successmsg.isDisplayed();
  }
  
}
	

