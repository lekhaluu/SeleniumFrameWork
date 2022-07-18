package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class YourAddressPage extends TestBase {

	
	@FindBy (xpath="//h2[contains(text(),'Your Addresses')]")
	WebElement addressbtn;
	
	
	@FindBy (id="ya-myab-plus-address-icon")
	WebElement addaddress;
	
	@FindBy (className="a-button-text a-declarative")
	WebElement country;
	
	@FindBy (id="address-ui-widgets-enterAddressFullName")
	WebElement fullname;
	
	@FindBy (id="address-ui-widgets-enterAddressPhoneNumber")
	WebElement phonenum;
	
	@FindBy (id="address-ui-widgets-enterAddressLine1")
	WebElement address;
	
	@FindBy (id="address-ui-widgets-enterAddressCity")
	WebElement city;
	
	@FindBy (css="#address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_8")
	WebElement province;
	
	@FindBy (id="address-ui-widgets-enterAddressPostalCode")
	WebElement postal;
	
	@FindBy (id="address-ui-widgets-use-as-my-default")
	WebElement defaultbtn;
	
	@FindBy (name="address-ui-widgets-addr-details-gate-code")
	WebElement code;
	
	@FindBy (css="#dropdown1_1")
	WebElement delivery;
	
	@FindBy (className="a-button-input")
	WebElement addbtn;
	
	@FindBy (xpath="//h4[contains(text(),'Address saved')]")
	WebElement addsaved;
	
	//Initialize elements with help of page factory class

			public YourAddressPage() {
				
				PageFactory.initElements(driver, this);
			}
		
			
	//Action methods of your address page
			
		public void Addressbutton()
		{
			addressbtn.click();
		}
	    public void Addaddr()
	    {
	    	addaddress.click();
	    }
	    public String Country()
	    {
	    	return country.getText();
	    }
	
	public void Fullname(String name)
	{
		fullname.sendKeys(name);
	}
	public void Phonenum(String string)
	{
		phonenum.sendKeys(string);
	}
	public void Address (String add)
	{
		address.sendKeys(add);
	}
	
	public void City (String cityname)
	{
	 city.sendKeys(cityname);
	}
	public void Province (String provincename)
	{
		province.sendKeys(provincename);
	}
	
	public void Postal(String string)
	{
		code.sendKeys(string);
		
	}
	
	public void Defaultbtn()
	{
		defaultbtn.click();
	}
	public void Securitycode(String string1)
	{
		code.sendKeys(string1);
	}
	
	public void Deliver()
	{
	delivery.getText();
	}
	
	public void AddAddress()
	{
		addbtn.click();
	}
	
	public void Addmsg()
	{
		addsaved.getText();
	}
	
	
	
}
