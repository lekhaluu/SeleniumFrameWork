package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.LoginPage;
import com.amazon.pages.LoginSecurityPage;
import com.amazon.pages.YourAccountPage;

public class LoginSecurityPageTest extends TestBase {
	
	
	LoginPage loginpage;
	YourAccountPage accountpage;
	LoginSecurityPage loginsecurity;
	
	public LoginSecurityPageTest()
	{
		super();
	}
		
	@BeforeMethod
    public void setup() 
	{
	initialization();
	loginpage= new LoginPage();
	loginpage.signin();
	loginpage.typeemail(prop.getProperty("username"));
	loginpage.continuebtn();
	loginpage.typepass(prop.getProperty("password"));
	loginpage.rememberme();
	accountpage =loginpage.submitbtn();
	accountpage.clickablelink();
    loginsecurity = new LoginSecurityPage();
    
	}
	@Test
	public void LoginSecurityClickTest()
	{
		loginsecurity.LoginsecurityClick();
		loginsecurity.EditName();
		loginsecurity.Nameupdate("123");
		loginsecurity.Submit();
		boolean actmsg = loginsecurity.Success();
		Assert.assertEquals(actmsg, true, "not updated");
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	
}
