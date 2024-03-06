package Helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Loggers 
{
	//Creating an instance of Logger for this Class
	static	Logger logger = LogManager.getLogger(Loggers.class);
	
	
	public static void main(String a[]) 
	{
		System.out.println("Start of the Program");
		
		logger.error("This is an Error Message");
		logger.info("This is an Info");
		logger.warn("This is an warning");
		
		logger.fatal("This is an Fatal Errror Message");
		
		System.out.println("End of the Program");
		
	}
}
