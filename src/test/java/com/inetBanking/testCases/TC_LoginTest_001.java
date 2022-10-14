package com.inetBanking.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends Base {
	
	//WebDriver driver;
	@Test
	public void logIn()
	
	{
		
		LoginPage lp = new LoginPage(driver);//life of driver being applied here
		lp.emailId(Uname);
		lp.password(Password);
		lp.signIn().click();
		
		
		
		if (driver.getCurrentUrl().equalsIgnoreCase("https://demo.guru99.com/V1/html/Managerhomepage.php"))
			
		{
			Assert.assertTrue(true);
			log.info("Url is correct");
			
		}
		else
			
		{
			log.error("Url is Incorrect");
			Assert.assertTrue(false);
			
			
		}
	}
	
	

}
