package com.cleartrip.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.cleartrip.util.TestUtil;



public class TestBase {
     
	public static WebDriver driver;
	public static Properties prop;

	
	
	//TestBase class Constructor 
	public TestBase()
	{
		try{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:/Selenium/codingRound-master/codingRound-master/src/main/java/com/cleartrip/config/config.properties");
		prop.load(ip);
		}
		
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		
		}
	}
	
	public static void setDriverPath()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\codingRound-master\\codingRound-master\\lib\\chromedriver.exe");
					
			driver = new ChromeDriver();
		}
		else if(browserName.equals(prop.getProperty("FF")))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Amazon_Assignment\\lib\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
		
}

