package com.amazon.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.LoginPage;
import com.amazon.pages.YourAccountPage;
import com.amazon.pages.YourAddressPage;

public class YourAddressPageTest extends TestBase {
	
	LoginPage loginpage;
	YourAccountPage accountpage;
	YourAddressPage addresspage;
	
	
	public YourAddressPageTest()
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
	accountpage.clickablelink();
	addresspage = new YourAddressPage();
    }
	
	@Test
	
	public void AddressbuttonTest()
	{
		addresspage.Addressbutton();
		addresspage.Addaddr();
		addresspage.Country();
		addresspage.Fullname("xyz");
		addresspage.Phonenum("764874346");
		addresspage.Address("215 queen st");
		addresspage.City("brmapton");
		addresspage.Province("on");
		addresspage.Postal("l6w0a9");
		addresspage.Defaultbtn();
		addresspage.Securitycode("0289");
		addresspage.Deliver();
		addresspage.AddAddress();
		addresspage.Addmsg();
			
	}
	@AfterMethod
	
	public void teardown()
	{
		driver.quit();
	}

	
	
	
	
	
	
	
	
	
	
	
	
}