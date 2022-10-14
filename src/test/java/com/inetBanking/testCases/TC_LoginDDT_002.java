package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utillities.XlUtils;

public class TC_LoginDDT_002 extends Base{
	
	
	@Test(dataProvider="getData")
	public void loginDDT(String Username, String password)
	{
		

		LoginPage lp = new LoginPage(driver);//life of driver being applied here
		lp.emailId(Username);
		log.info("UserName is provided");
		lp.password(password);
		log.info("Password is provided");
		lp.signIn().click();
		
		if(isAlertPresence()==true)
		{
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			log.warn("Invalid creddentials");
			Assert.assertTrue(false);

		}
		else
		{
			Assert.assertTrue(true);
			log.info("Valid credentials");
			lp.logOut();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
		


	}
	
	public boolean isAlertPresence()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	@DataProvider
	public String[][] getData() throws IOException
	{
		
	String path =System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetBanking\\testData\\DataDrivenutil.xlsx";
	int rowNum = XlUtils.getRowCount(path,"testcases");
	int colcount = XlUtils.getCellCount(path, "testcases", 1);
	System.out.println(rowNum);
	System.out.println(colcount);
	
	String[][] logindata = new String[rowNum][colcount];
	
	for(int i =1;i<=rowNum;i++)
		
	{
		for(int j =0;j<colcount;j++)
			
		{
			logindata[i-1][j] = XlUtils.getCellData(path, "testcases", i, j);//1 0
			
			
		}	
	}
	return 	logindata;
	
	}

}
