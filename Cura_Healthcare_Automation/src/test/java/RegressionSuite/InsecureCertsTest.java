package RegressionSuite;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import Helpers.ExtentReporters;
import Helpers.ReadProperties;
import Helpers.WebDriverHelper;
import PageMethods.ReusableMethods;
import PageMethods.WebMethods;

public class InsecureCertsTest 

{	
	//This TestClass Put the ChromeOptions  in Test
	static WebDriver driver;
	static WebMethods hey;
	static String base_url;
	static ExtentTest test;
	static ReusableMethods beta;
	static ExtentReporters logtest;
	
	@BeforeMethod
	public static void Setup(Method method) 
	{
		driver = WebDriverHelper.ChromeDriver();
		hey = new WebMethods(driver);
		test = ExtentReporters.Test();
		base_url = beta.setUrl(method.getName());
		
	}
	
	@Test(priority=0)
	public static void expiredCertTest() throws IOException 
	{
		//test.log(Status.INFO, "Testing Expired SSL Certification");
		hey.navigateTo(base_url);
		if(driver.getCurrentUrl().contains("expired.badssl.com")) {
		test.log(Status.PASS, "Testing Expired SSL Certification is Successful");
		}
		hey.waitforSeconds(5);
		hey.takeScreenshot(driver);
		hey.waitforSeconds(2);
	}
	@Test(priority=1)
	public static void wrongHostCertTest() 
	{
		//test.log(Status.INFO, "Testing Wrong Host Certification url");
		hey.navigateTo(base_url);
		if(driver.getCurrentUrl().contains("wrong.host.badssl.com")) {
		test.log(Status.PASS, "Testing wrong host Certification is Successful");
		}
		hey.waitforSeconds(5);
		hey.takeScreenshot(driver);
		hey.waitforSeconds(2);
		
	}
	@Test(priority=2)
	public static void selfsignedCertTest() 
	{
		//test.log(Status.INFO, "Testing Self-Signed Certification url");
		hey.navigateTo(base_url);
		if(driver.getCurrentUrl().contains("self-signed.badssl.com")) {
		test.log(Status.PASS, "Testing Self-Signed Certification is Successful");
		}
		hey.waitforSeconds(5);
		hey.takeScreenshot(driver);
		hey.waitforSeconds(2);
		
	}
	@Test(priority=3)
	public static void untrustedCertTest() 
	{
		//test.log(Status.INFO, "Testing Untrusted root Certification url");
		hey.navigateTo(base_url);
		if(driver.getCurrentUrl().contains("untrusted-root.badssl.com")) {
		test.log(Status.PASS, "Testing Untrusted root Certification is Successful");
		}
		hey.waitforSeconds(5);
		hey.takeScreenshot(driver);
		hey.waitforSeconds(2);
		
	}
	@Test(priority=4)
	public static void revokedCertTest() 
	{
		//test.log(Status.INFO, "Testing Revoked Certification url");
		hey.navigateTo(base_url);
		if(driver.getCurrentUrl().contains("revoked.badssl.com")) {
		test.log(Status.PASS, "Testing Revoked Certification is Successful");
		}
		hey.waitforSeconds(5);
		hey.takeScreenshot(driver);
		hey.waitforSeconds(2);
		
	}
	@Test(priority=5)
	public static void pinningCertTest() 
	{
		//test.log(Status.INFO, "Testing Pinning test Certification url");
		hey.navigateTo(base_url);
		if(driver.getCurrentUrl().contains("pinning-test.badssl.com")) {
		test.log(Status.PASS, "Testing pinning test Certification is Successful");
		}
		hey.waitforSeconds(5);
		hey.takeScreenshot(driver);
		hey.waitforSeconds(2);
		
	}
	
	@AfterMethod
	public static void tearDown() 
	{

		System.out.println("Closing Browser");
		driver.manage().deleteAllCookies();
		System.out.println(driver.manage().logs().toString());
		driver.close();
		driver.quit();
		test.log(Status.INFO, "Chrome Browser is Closed ");
		logtest.Flush();
	}

}
