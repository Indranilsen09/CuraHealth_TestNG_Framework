package Helpers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties 
{
	
		static InputStream fis = null;
		static Properties props = null;
		static String url=null;
		
	 private static Properties readproperty(String filename) throws IOException
	    {
	        Properties prop = new Properties();
	        try {
	            String config = "/Configs/"+filename;
	            fis = ReadProperties.class.getResourceAsStream(config);
	            if(fis !=null) {
	                prop.load(fis);
	            }
	        }catch (Exception e){
	            System.out.println("File Not Found"+ e.getLocalizedMessage());
	        }
	        return prop;
	    }

	    public static String getProperty(String key) throws IOException
	    {
	    	try {
	        props = readproperty("stage.properties");
	        if(key.contains("cura")) {
	        url = props.getProperty("cura_healthcare_url");
	        }
	        else {
	        	url = props.getProperty(key);
	        }
	    	}catch(Exception e) 
	    	{
	    		System.out.println("File not found"+ e.getLocalizedMessage());
	    	}
	    	return url;
	    }

}
