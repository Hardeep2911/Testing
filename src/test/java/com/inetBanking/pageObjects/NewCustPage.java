package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class NewCustPage {

	WebDriver driver;
	public NewCustPage(WebDriver driver)
	{
		this.driver= driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(xpath="//*[@href='addcustomerpage.php']")
	private WebElement addcust;
	
	@FindBy(name="name")
	private WebElement name;
	
	@FindBy(xpath="//*[text()='Gender']/following-sibling::td/input[1]")
	private WebElement gender;
	
	@FindBy(css="[name='dob']")
	private WebElement dob;
	
	@FindBy(xpath="//*[@class='layout']/tbody/tr/td/table/tbody/tr[7]/td[2]/textarea")
	private WebElement address;
	
	@FindBy(css="[name='city']")
	private WebElement city;
	
	@FindBy(css="[name='state']")
	private WebElement state;
	
	@FindBy(css="[name='pinno']")
	private WebElement pinno;
	
	@FindBy(css="[name='telephoneno']")
	private WebElement telephoneno;
	
	private By email = By.name("emailid");
	
	private By submit = By.xpath("//*[@name='sub']");
	
	public void AddCust()
	{
		addcust.click();
	}
	
	public void Name(String name1)
	{
		name.sendKeys(name1);
	}
	
	public void Gender()
	{
		gender.click();
	}
	
	public void Dob(String name1)
	{
		dob.sendKeys(name1);
	}
	
	public WebElement Address()
	{
		return address;
	}
	
	public void City(String name1)
	{
		city.sendKeys(name1);
	}
	
	public void State(String name1)
	{
		state.sendKeys(name1);
	}
	
	public void Pinno(int name1)
	{
		pinno.sendKeys(String.valueOf(name1));
	}
	
	public void Telphoneno(String name1)
	{
		telephoneno.sendKeys(name1);
	}
	
	public void Email(String name1)
	{
		driver.findElement(email).sendKeys(name1);
	}
	
	public void Submit()
	{
		driver.findElement(submit).click();
	}
	
	
	
	
	
}
