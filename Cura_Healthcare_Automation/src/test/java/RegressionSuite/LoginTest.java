package RegressionSuite;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Helpers.ReadProperties;
import Helpers.WebDriverHelper;
import PageMethods.ReusableMethods;
import  PageMethods.WebMethods;
import PageObjects.CuraHealthLocators;

public class LoginTest extends WebMethods
{
	public LoginTest(WebDriver driver) {
		super(driver);

	}
	static InputStream fis=null;
	static Properties props=null;	
	static WebMethods siri;
	static String baseurl=null;
	static WebDriver driver;
	static String username;static String password;
	
	static CuraHealthLocators e = new CuraHealthLocators();
	static ReusableMethods alexa = new ReusableMethods();
	
	public static void main(String args[])
	{
		try {
			Setup("Chrome");
			//Actions
			siri.navigateTo(baseurl);
			waitforSeconds(15000);
			
			
			siri.click(e.btn_makeAppointment);
			waitforSeconds(10000);

			siri.EnterText(e.txt_user,username);
			siri.EnterText(e.txt_pass,password);
			siri.click(e.btn_Login);
			waitforSeconds(10000);
			siri.select(e.dropdown_facility,"Seoul CURA Healthcare Center");
			System.out.println("Hi user, Seoul CURA Healthcare Center is Selected");
			waitforSeconds(5000);
			siri.click(e.radio_recommendation);
			siri.click(e.radio_HealthCare_Program("Medicaid"));
			System.out.println("Medicaid - Health Program is Selected");
			int day = alexa.getTodaysDate();
			siri.click(e.visit_date);
			waitforSeconds(2000);
			siri.click(e.slt_day(day+7));
			System.out.println("Hi user, Selecting Appoint date as "+ (day+7)+ " of the Month");
			siri.click(e.txt_comment);
			siri.EnterText(e.txt_comment, "Looking Good");
			waitforSeconds(10000);
			siri.click(e.btn_bookAppnment);
			waitforSeconds(10000);
			siri.click(e.btn_toggleMenu);
			waitforSeconds(2000);
			siri.click(e.btn_history);
			waitforSeconds(10000);
			siri.click(e.btn_toggleMenu);
			waitforSeconds(5000);
			siri.click(e.btn_logout);
			System.out.println("Hi Indra we're in Github, Congo");
			TearDown();

		}catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

	static void Setup(String Browser) 
	{
		try {
			if(Browser.contains("Chrome"))
			{
				System.out.println("Setting Up ChromeBrowser");
				driver = WebDriverHelper.ChromeDriver();
				siri = new WebMethods(driver);
				baseurl = ReadProperties.getProperty("cura");
				username = ReadProperties.getProperty("username");
				password=ReadProperties.getProperty("password");
				
			}
		}catch(Exception e) {

		}

	}
	
	static void TearDown() 
	{
		System.out.println("Closing Browser");
		driver.manage().deleteAllCookies();
		System.out.println(driver.manage().logs());
		driver.close();
		driver.quit();
		
		
	}

}
