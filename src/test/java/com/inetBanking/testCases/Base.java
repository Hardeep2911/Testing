
package com.inetBanking.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import com.inetBanking.utillities.ReadConfig;

public class Base {
	
	ReadConfig readconfig = new ReadConfig();
	
	public static  WebDriver driver;
	public String url = readconfig.getUrl();
	public String Uname = readconfig.getUsername();
	public String Password = readconfig.getPassword();
	//public String browserName = readconfig.getBrowserName(); through TestNg
	public String chromepath = readconfig.getChromePath();
	public static Logger log;
	
	@Parameters("browser")
	@BeforeClass
	public void initializeBrowser(String browserName) throws IOException
	
	{
				
		log = Logger.getLogger("Base");
		//to configure properties from the properties file
		PropertyConfigurator.configure("log4j.properties");
		
		if(browserName.equalsIgnoreCase("chrome"))
			
		{
			log.info("Chrome is started");
			System.setProperty("webdriver.chrome.driver", chromepath);
			driver = (WebDriver) new ChromeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			
			
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = (WebDriver) new ChromeDriver();
			
		}	
		
		log.debug("Maximizing the browser");
		driver.manage().window().maximize();
		
		log.fatal("Providing implicit wait");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get(url);

					
		
	}
	
	@AfterClass
	public void tearDown()
	{
		log.warn("Closing the browser");
		driver.quit();
		
	}
	
	public String captureScreenshot(String screenshotName) throws IOException
	
	{
		//null pointer exception here
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMYYYYhhmmss");
		String screenshotname1 = screenshotName+sdf.format(d)+".png";
		String destination = System.getProperty("user.dir")+"\\Screenshots\\"+screenshotname1;
		File finalDestination = new File(destination);
		FileUtils.copyFile(src, finalDestination);
		return destination;
		
	}
	
	public String randomString()
	{
		return RandomStringUtils.randomAlphabetic(8);

	}
	
	public String randomNum()
	{
	return RandomStringUtils.randomNumeric(5);
	}
}
