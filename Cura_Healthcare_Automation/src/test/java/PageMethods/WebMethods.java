package PageMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import Helpers.WebDriverHelper;

public class WebMethods 
{
	static WebDriver driver;
	public WebMethods(WebDriver driver) 
	{
		this.driver= driver;
	}

	public void click(By by) 
	{
		if(driver.findElements(by).size()>0) 
		{
			System.out.println(driver.findElements(by).size()+" size");
			driver.findElement(by).click();
			System.out.println(by.toString()+" is Clicked");
		}else {
			System.out.println(by.toString()+" is Not Found");
			System.out.println("Executing Javascript Click");
			WebElement btn = driver.findElement(by);
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", btn);
		}

	}

	public void EnterText(By by,String text)throws InterruptedException 
	{

		if(driver.findElements(by).size()>0) 
		{
			driver.findElement(by).click();
			Thread.sleep(2000);
			driver.findElement(by).sendKeys(text);
			System.out.println(by.toString()+ " text Entered");
		}else {
			System.out.println(by.toString()+" is Not Found");
		}
	}
	public static void waitforSeconds(int time) 
	{
		try {
			Thread.sleep(time*1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void navigateTo(String url) 
	{
		if(url.contains("cura")) {
		System.out.println("Hi User Navigating to Cura HealthCare HomePage" );
		}
		driver.navigate().to(url);
		
	}
	
	public static void select(By by,String text) 
	{
		try {
				Select option = new Select(driver.findElement(by));
				option.selectByVisibleText(text);
		}catch(Exception e) 
		{
			
		}
	}


}
