package PageMethods;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

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

}
