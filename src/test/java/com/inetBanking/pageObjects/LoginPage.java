package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) 
	{

		this.driver = driver;
		//initializing the findBy annotations
		//test case argument initializing to the local driver
		PageFactory.initElements(driver, this);
	}

	private By password = By.cssSelector("[name='password']");
	
	
	@FindBy(css="[name='btnLogin']")
	private WebElement signIn;
	
	@FindBy(xpath="//*[@name='uid']")
	private WebElement email;
	
	@FindBy(xpath="//*[@href='Logout.php']")
	private WebElement logout;
	
	//Action methods
	public void emailId(String emal) {
		//can provide the action directly here without returning the webelement
		//in this case we won't be able to click or send keys from the test case class file
		 email.sendKeys(emal);

	}

	public void password(String pswrd) {

		driver.findElement(password).sendKeys(pswrd);

	}

	public WebElement signIn() {
		
		//returning the webelement and performing the action there
		return signIn;

	}
	
	public void logOut() {
		
		logout.click();

	}

}
