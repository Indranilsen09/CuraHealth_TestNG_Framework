package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aventstack.extentreports.Status;

public class WebDriverHelper 
{
		static ExtentReporters report = new ExtentReporters();
		
		static ChromeOptions opts;
	
	public static WebDriver ChromeDriver() 
	{
		
	
		System.getProperty("webdriver.chrome.driver","user.dir"+"/Drivers/chromedriver.exe");
		//Setting ChromeOptions for ChromeDriver
		opts = getDesiredChromeOptions();
		WebDriver driver = new ChromeDriver(opts);
		driver.manage().window().maximize();
		report.Test().log(Status.INFO, "Chrome Browser is Successfully Started");
		return driver;
		
		
	}
	
	static ChromeOptions getDesiredChromeOptions() 
	{
		ChromeOptions opt = new ChromeOptions();
		try {
			//It will Accept Insecure Certificates
			opt.setAcceptInsecureCerts(true);
			
			
		}catch(Exception e) 
		{
			
		}
		return opt;
	}

}
