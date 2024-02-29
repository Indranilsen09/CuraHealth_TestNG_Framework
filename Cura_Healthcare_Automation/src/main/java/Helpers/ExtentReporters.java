package Helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporters {
	
	
	
		//Creates a Reporter
		static ExtentSparkReporter htmlreporter = new ExtentSparkReporter("user.dir/target/HtmlReports"+"ExtentReports.html");
		
		//Creating the extentReport and Attaching Reporter so that Reporter logs everything into The Report File
		static ExtentReports extent = new ExtentReports();
		//creating test to log files under Reports
		static ExtentTest test = extent.createTest("Cura_HealthCare_Test");
	
	public static ExtentTest Test()
	{
		
		extent.attachReporter(htmlreporter);
		return test;
	}
	
	public static void Flush() {
		extent.flush();
	}
}
