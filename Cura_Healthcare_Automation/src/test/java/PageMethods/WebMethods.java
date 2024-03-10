package PageMethods;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.*;

import Helpers.WebDriverHelper;

public class WebMethods 
{
	static WebDriver driver; static int sscount =0;
	private static final Logger logger = LogManager.getLogger(WebMethods.class.getName());
	public WebMethods(WebDriver driver) 
	{
		this.driver= driver;
	}

	public void click(By by) 
	{
		try {
		if(driver.findElements(by).size()>0) 
		{
			logger.info(driver.findElements(by).size()+" size");
			driver.findElement(by).click();
			logger.info(driver.findElement(by).getText()+" is Clicked");
			
		}else {
			System.out.println(by.toString()+" is Not Found");
			System.out.println("Executing Javascript Click");
			WebElement btn = driver.findElement(by);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", btn);
			if(btn.getText().isEmpty()) 
			{
				if(btn.getAttribute("value").isBlank()) {
					
				}else {
					logger.info(btn.getAttribute("value")+" is Clicked");
				}
			}else {
			logger.info(btn.getText()+" is Clicked");
			}
		}
		}catch(Exception e) 
		{
			logger.warn("Failed to Click: error: "+ e.getLocalizedMessage());
		}
	}

	public void EnterText(By by,String text)throws InterruptedException 
	{
		try {

		if(driver.findElements(by).size()>0) 
		{
			driver.findElement(by).click();
			Thread.sleep(2000);
			driver.findElement(by).sendKeys(text);
			if(driver.findElement(by).getText().isBlank()) {
				logger.info(text+" is Entered in "+ driver.findElement(by).getAttribute("value"));
			}else {
			logger.info(text+" is Entered in "+ driver.findElement(by).getText());
			}
		}
		}catch(Exception e) 
		{
			logger.warn("Failed to Enter Text: error: "+ e.getLocalizedMessage());
		}
		
	}
	public static void waitforSeconds(int time) 
	{
		try {
			Thread.sleep(time*1000);
		}catch(Exception e) {
			e.printStackTrace();
			logger.warn(" failed to wait:"+ e.getLocalizedMessage());
		}
	}
	
	public static void navigateTo(String url) 
	{
		try {
		if(url.contains("cura")) {
		logger.info("Hi User Navigating to Cura HealthCare HomePage");
		}
		else {
			logger.info("Hi user , Navigating to : "+url);
		}
		driver.navigate().to(url);
		
		}catch(Exception e) 
		{
			logger.error("Failed to navigate to "+ url+ " | Error: "+ e.getMessage());
		}
	}
	
	public static void select(By by,String text) 
	{
		try {
				Select option = new Select(driver.findElement(by));
				option.selectByVisibleText(text);
				logger.info(text+" option is selected");
		}catch(Exception e) 
		{
			logger.warn(text+" failed to select option");
		}
	}

	public static void takeScreenshot(WebDriver driver) 
	{
		try {
			TakesScreenshot ss = ((TakesScreenshot)driver);
			File srcFile = ss.getScreenshotAs(OutputType.FILE);
			File destFile = new File("user.dir"+"/Screenshots/"+"screenshot"+sscount+".png");
			sscount++;
			FileUtils.copyFile(srcFile, destFile);
			
		}catch(Exception e) {
			e.printStackTrace();
			e.getLocalizedMessage();
			logger.fatal("Failed to Take Screenshot | Error: "+ e.getLocalizedMessage());
		}
	}

}
