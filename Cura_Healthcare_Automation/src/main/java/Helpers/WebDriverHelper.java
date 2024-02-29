package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.Status;

public class WebDriverHelper 
{
		static ExtentReporters report = new ExtentReporters();
	
	public static WebDriver ChromeDriver() 
	{
		System.getProperty("webdriver.chrome.driver","user.dir"+"/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		report.Test().log(Status.INFO, "Chrome Browser is Successfully Started");
		return driver;
		
	}

}
