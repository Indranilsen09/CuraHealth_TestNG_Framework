package PageMethods;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import Helpers.ReadProperties;

public class ReusableMethods 
{
	
	public static int getTodaysDate()
	{
		LocalDate today = LocalDate.now();
		int day = Integer.parseInt(String.valueOf(today.getDayOfMonth()));
		if(day==1) {
			System.out.println("Hi User, Today is "+day+"st of the Month");
		}else if(day ==2) {
			System.out.println("Hi User, Today is "+day+"nd of the Month");
		}else if(day==3) {
			System.out.println("Hi User, Today is "+day+"rd of the Month");
		}else {
		System.out.println("Hi User, Today is "+day+"th of the Month");
		}
		
		return day; 
	}
	
	public static String setUrl(String methodName) 
	{
		String url="";
		try {
			
			if(methodName.contains("expired")) {
				url = ReadProperties.getProperty("expiredCert_url");
			}
			if(methodName.contains("wrong")) {
				url = ReadProperties.getProperty("wronghost_url");
			}
			if(methodName.contains("selfsigned")) {
				url = ReadProperties.getProperty("selfsigned_url");
			}
			if(methodName.contains("untrusted")) {
				url = ReadProperties.getProperty("untrusted_url");
			}
			if(methodName.contains("revoked")) {
				url = ReadProperties.getProperty("revoked_url");
			}
			if(methodName.contains("pin")) {
				url = ReadProperties.getProperty("pinningtest_url");
			}
			
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		
		return url;
		
	}

}
