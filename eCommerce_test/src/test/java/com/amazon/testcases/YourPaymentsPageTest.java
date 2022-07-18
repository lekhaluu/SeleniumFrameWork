package com.amazon.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.base.TestBase;
import com.amazon.pages.LoginPage;
import com.amazon.pages.YourAccountPage;
import com.amazon.pages.YourPaymentsPage;

public class YourPaymentsPageTest extends TestBase {
	
	LoginPage loginpage;
	YourAccountPage accountpage;
	YourPaymentsPage paymentpage;
	
	
    public YourPaymentsPageTest()
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
	paymentpage = new YourPaymentsPage();
	}
	@Test
	public void YourPaymentsTest() {
		paymentpage.YourPayments();
		paymentpage.AddPayment();
		paymentpage.AddCard();
		paymentpage.Frame();
		paymentpage.Cardnumber();
		paymentpage.CardDetails("5431111111111111");
		paymentpage.Name("Srilekha Duvvuri");
		paymentpage.Expirymonth(5);
		paymentpage.Expiryyear(3);
		paymentpage.AddCard();
		paymentpage.SaveButton();
		boolean act = paymentpage.Success();
		Assert.assertEquals(act, true, "success msg not displayed");
	}
	
   @AfterMethod
   public void teardown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
