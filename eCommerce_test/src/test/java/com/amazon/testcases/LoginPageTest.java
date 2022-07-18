package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.LoginPage;
import com.amazon.pages.YourAccountPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	YourAccountPage accountpage;
	
	public LoginPageTest() 
	{
		super();  // super keyword will call the constructor of parent class
	}
	@BeforeMethod
    public void setup() 
	{
	initialization();
	 loginpage= new LoginPage();  //created object of LoginPage class to use all its methods/functions		
	}
	
	@Test (priority=1)
	public void signinTest() throws InterruptedException
	{
		loginpage.signin();
		loginpage.typeemail(prop.getProperty("username"));
		loginpage.continuebtn();
		loginpage.typepass(prop.getProperty("password"));
		loginpage.rememberme();
		accountpage= loginpage.submitbtn();   //submit button is returning to your account page, we stored this in ref. variable account page
		
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	
	public void invalidusername() throws InterruptedException
	{
		loginpage.signin();
		loginpage.typeemail("..");
		loginpage.continuebtn();
		boolean error=loginpage.invaliderror();
		Assert.assertEquals(error, false);
		loginpage.typepass(prop.getProperty("password"));
		accountpage= loginpage.submitbtn();
	 Thread.sleep(3000);
	}
	
	@Test (priority=3)
    public void invalidpasswd() throws InterruptedException
    {
		loginpage.signin();
		loginpage.typeemail(prop.getProperty("username"));
		loginpage.continuebtn();
		loginpage.typepass("..");
		accountpage=loginpage.submitbtn();
		boolean error = loginpage.invaliderror();
		Assert.assertEquals(error, false);
	    accountpage=loginpage.submitbtn();
		Thread.sleep(3000);
		
    }
	 @AfterMethod
    public void teardown()
    {
    	driver.quit();
    }
}
