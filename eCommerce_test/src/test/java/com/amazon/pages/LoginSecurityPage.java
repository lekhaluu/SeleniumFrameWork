package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class LoginSecurityPage extends TestBase {
	
	
	@FindBy (xpath="//h2[contains(text(),'Login & security')]")
	WebElement LoginSecurityBtn;
	
	@FindBy (xpath="//input[@id='auth-cnep-edit-name-button']")
	WebElement name;
	
	@FindBy (id="ap_customer_name")
	WebElement editname;
	
	@FindBy (xpath="//input[@id='cnep_1C_submit_button']")
	WebElement savebtn;
	
	@FindBy (xpath="//h4[contains(text(),'Success')]")
	WebElement successmsg;
	
	
	//initialize
	
    public LoginSecurityPage() 
    {
		
		PageFactory.initElements(driver, this);
	}
	
	//Action class

     public void LoginsecurityClick()

    {
	LoginSecurityBtn.click();
	}
     
      public void EditName()
       {
    	name.click();
	   }
      
      public void Nameupdate(String updatename)
      {
    	  editname.sendKeys(updatename);
      }
      public void Submit()
      {
    	  savebtn.click();
      }
      public boolean Success()
      {
    	  return successmsg.isDisplayed();
      }

}
