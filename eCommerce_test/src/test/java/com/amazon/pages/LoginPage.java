package com.amazon.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory or object repository
	
	@FindBy(xpath="//*[@id=\"nav-link-accountList\"]/span")
	WebElement signinbtn;
	
	@FindBy(id="ap_email")
	WebElement email;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement cont;
	
	@FindBy(id="ap_password")
	WebElement pwd;
	
	@FindBy(name="rememberMe")
	WebElement rembtn;
	
	@FindBy(id="signInSubmit")
	WebElement sbmtbtn;
	
	@FindBy (xpath="//h4[contains(text(),'There was a problem')]")
	WebElement errormsg;
	
	//Initialize elements with help of pagefactory class
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Action methods of login page
	
	public void signin() 
	{
		signinbtn.click();
	}
	
	public void typeemail(String username)
	{
		email.sendKeys(username);
	}
	public void continuebtn()
	 {
		 cont.click();
	 }
	public void typepass(String password)
	{
		pwd.sendKeys(password);
    }
	
	public void rememberme()
	{
		rembtn.click();
	}
	
	public boolean invaliderror()
	{
		return errormsg.isDisplayed();
		
	}
	
	public YourAccountPage submitbtn()   // this method is returning to your account page, your account is the landing page 
	{
		sbmtbtn.click();
		
		return new YourAccountPage();
	}
	
}


