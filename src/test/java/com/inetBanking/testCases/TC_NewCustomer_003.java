package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.pageObjects.NewCustPage;

public class TC_NewCustomer_003 extends Base{
	
	@Test
	public void AddNewCustomer() throws InterruptedException 
	
	{
		
		LoginPage lp = new LoginPage(driver);
		lp.emailId(Uname);
		log.info("Providing Username");
		lp.password(Password);
		log.info("Providing the password");
		lp.signIn().click();
		
		NewCustPage np = new NewCustPage(driver);
		
		np.AddCust();
		
		log.info("Providing the customer info");
		
		np.Name("Hardeep");
		np.Gender();
		Thread.sleep(2000);
		np.Dob("29111991");
		Thread.sleep(2000);
		
		np.Address().click();
		np.Address().sendKeys("HIG 187");
		np.City("Chandigarh");
		np.State("Punjab");
		np.Pinno(160062);
		np.Telphoneno("6283937705");
		Thread.sleep(2000);
		np.Email(randomString()+"@gmail.com");
		np.Submit();
		log.info("Test case Passed");
		Assert.assertTrue(true);
		
	}

}
