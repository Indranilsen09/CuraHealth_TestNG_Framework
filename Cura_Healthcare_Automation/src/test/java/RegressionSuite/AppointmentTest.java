package RegressionSuite;

import java.io.IOException;
import java.util.Scanner;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import org.testng.annotations.*;

import Helpers.ExtentReporters;
import Helpers.ReadProperties;
import Helpers.WebDriverHelper;
import PageMethods.ReusableMethods;
import PageMethods.WebMethods;
import PageObjects.CuraHealthLocators;

public class AppointmentTest 
{
	//This Test is Designed on TestNG Framework.
	static WebDriver driver= null;
	static WebMethods siri = null;
	static String baseurl =null;
	static String username = null;
	static String password = null;
	static CuraHealthLocators e = new CuraHealthLocators();
	static ReusableMethods alexa = new ReusableMethods();
	static ExtentTest test;
	static ExtentReporters logtest;

	
	@BeforeTest
	public static void setup() throws Exception 
	{
		
		System.out.println("Setting Up ChromeBrowser");
		//Starting Chrome Browser and Also Getting the Driver into this class
		driver = WebDriverHelper.ChromeDriver();
		//Creating siri(Object) of WebMethods to Perform WebActions
		siri 	 = new WebMethods(driver);
		//Getting all the Key Values to Login Perfectly into the Application
		baseurl  = ReadProperties.getProperty("cura");
		username = ReadProperties.getProperty("username");
		password = ReadProperties.getProperty("password");
		//Creating Object of ExtentReporters so that I can Start the Reporter
		logtest = new ExtentReporters();
		//Getting the ExtentTest to this class to log the details
		test = logtest.Test();
		//Calling Siri(Object of WebMethods) to Navigate to the Application Base URL
		siri.navigateTo(baseurl);
		//Calling Siri to Wait for Seconds
		siri.waitforSeconds(15);
		
		
	}
	@Test
	public static void AppointmentTest() throws Exception 
	{
		try {
		siri.click(e.btn_makeAppointment);
		siri.waitforSeconds(10);

		siri.EnterText(e.txt_user,username);
		
		test.log(Status.INFO, username+" is Entered as Username");
		
		siri.EnterText(e.txt_pass,password);
		test.log(Status.INFO, password+" is Entered as Username");
		siri.click(e.btn_Login);
		test.log(Status.PASS, "Login is Successful");
		siri.waitforSeconds(10);
		siri.select(e.dropdown_facility,"Seoul CURA Healthcare Center");
		test.log(Status.INFO,"Hi user, Seoul CURA Healthcare Center is Selected" );
		siri.waitforSeconds(5);
		siri.click(e.radio_recommendation);
		siri.click(e.radio_HealthCare_Program("Medicaid"));
		System.out.println("Medicaid - Health Program is Selected");
		test.log(Status.PASS, "Medicaid - Health Program is Selected");
		
		int day = alexa.getTodaysDate();
		if(day>=25) {
			int left_days = 30 -day;
			System.out.println("Seven days from now would be Next Month");
			siri.click(e.visit_date);
			siri.click(e.btn_nextMonth);
			siri.waitforSeconds(2);
			
			siri.click(e.slt_day((7-left_days)));
		}else {
		siri.click(e.visit_date);
		siri.waitforSeconds(2);
		siri.click(e.slt_day(day+7));
		}
		
		test.log(Status.INFO,"Hi user, Selecting Appoint date as "+ (day+7)+ " of the Month");
		siri.click(e.txt_comment);
		siri.EnterText(e.txt_comment, "Looking Good");
		siri.waitforSeconds(10);
		siri.click(e.btn_bookAppnment);
		siri.waitforSeconds(10);
		logtest.Test().log(Status.PASS,"Appointment is Booked Successfully");
		siri.click(e.btn_toggleMenu);
		siri.waitforSeconds(2);
		siri.click(e.btn_history);
		siri.waitforSeconds(10);
		siri.click(e.btn_toggleMenu);
		siri.waitforSeconds(5);
		siri.click(e.btn_logout);
		test.log(Status.PASS, "Logged Out Successfully");
		System.out.println("Hi Indra We've Successfully in Github");
		}catch(Exception e) 
		{
			e.printStackTrace();
			test.fail("Failed To Book Appointment",MediaEntityBuilder.createScreenCaptureFromPath("Screenshot.jpg").build());
		}

	}
	@AfterTest
	static void TearDown() throws Exception
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
