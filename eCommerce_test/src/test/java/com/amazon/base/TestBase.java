package com.amazon.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amazon.utilities.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;  //properties variable
	
	
	
	// to read the properties from configuration file
	public TestBase () {
		
		try {
		prop = new Properties();
		FileInputStream ip= new FileInputStream("C:\\Users\\lekha\\eclipse-workspace\\eCommerce_test\\src\\test\\java\\com\\amazon\\configuration\\config.properties");
		prop.load(ip);
		
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			
		}catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
	   // to initialize the browser
		public static void initialization() {
		     String browsername = prop.getProperty("browser");
		     if(browsername.equals("chrome"))
		     {
		     System.setProperty("webdriver.chrome.driver","C:\\Users\\lekha\\eclipse-workspace\\eCommerce_test\\Drivers\\chromedriver.exe");
		     driver = new ChromeDriver();
		     }
		     else if (browsername.equals("edge"))
		     {
		    System.setProperty("webdriver.edge.driver","C:\\Users\\lekha\\eclipse-workspace\\eCommerce_test\\Drivers\\msedgedriver.exe");
		    driver = new EdgeDriver();
		     } 
		     
		     else if (browsername.equals("firefox"))
		     {
		    System.setProperty("webdriver.gecko.driver","C:\\Users\\lekha\\eclipse-workspace\\eCommerce_test\\Drivers\\geckodriver.exe");
		    driver = new FirefoxDriver();
		     }
		     
		    
		     driver.manage().window().maximize();
		     driver.manage().deleteAllCookies();
		     driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		     driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		     driver.get(prop.getProperty("url"));
		     }
			
		 public void captureScreen(WebDriver driver, String tname) throws IOException {
			 
			 TakesScreenshot ts= (TakesScreenshot) driver;
			 File source = ts.getScreenshotAs (OutputType.FILE);
			 File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			 FileUtils.copyFile(source, target);
			 System.out.println("Screentshot taken");
			 
		 }
	}
	