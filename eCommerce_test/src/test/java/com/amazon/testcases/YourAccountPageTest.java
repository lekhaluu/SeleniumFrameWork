package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.LoginPage;
import com.amazon.pages.YourAccountPage;

public class YourAccountPageTest extends TestBase {
	LoginPage loginpage;
	YourAccountPage accountpage;
		
	public YourAccountPageTest()
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
	accountpage = loginpage.submitbtn();
	
	}
	
    @Test (priority=1 )
	
	public void verifyhelloTest()
	{
		String Welcometext = accountpage.verifyhellotext();
	
		System.out.println(Welcometext);
			
	}
	
	@Test (priority=2) 
	
	public void hellodropdownTest()
	{
     Assert.assertTrue(accountpage.hellodropdown(),"Dropdown list is missing on the page");
				
	}
	
	@Test (priority=3)
	
	public void accountpageTest() throws InterruptedException
	{
	 accountpage.clickablelink();
	 Thread.sleep(2000);
	}
	
	@AfterMethod
	
	public void teardown()
	{
		driver.quit();
	}

}
