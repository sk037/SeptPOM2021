package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constant;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	WebDriver driver;
	ElementUtil elemUtil;
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		elemUtil=new ElementUtil(driver);
		
	}
	
	private By email=By.id("input-email");
	private By password=By.id("input-password");
	private By login=By.xpath("//*[@value='Login']");
	private By forgotpassword=By.xpath("(//*[text()='Forgotten Password'])[1]");
	private By register=By.xpath("(//*[text()=\"Register\"])[2]");
	//private By logout=By.xpath("//*[text()=\"Logout\"]");
	private By logout=By.cssSelector("body.account-account:nth-child(2) div.container:nth-child(4) div.row aside.col-sm-3.hidden-xs div.list-group > a.list-group-item:nth-child(13)");
	
	public String getTitle()
	{
		//return driver.getTitle();
		return elemUtil.doGetTitle(Constant.LOGINPAGE_TITLE,Constant.DEFAULT_TIME_OUT );
	}
	
	public boolean getUrl()
	{
		//return driver.getCurrentUrl();
		return elemUtil.waitForURLToBe(Constant.URL_FRACTION, Constant.DEFAULT_TIME_OUT);
	}
	
	public boolean checkfpLink()
	{
		//return driver.findElement(forgotpassword).isDisplayed();
		return elemUtil.doIsDisplayed(forgotpassword);
	}
		
	public AccountsPage Login(String un, String pwd)
	{
		//driver.findElement(email).sendKeys(un);
		//driver.findElement(password).sendKeys(pwd);
		//driver.findElement(login).click();
		elemUtil.doSendKeys(email, un,10);
		elemUtil.doSendKeys(password, pwd,10);
		elemUtil.doActionClick(login);	
		return new AccountsPage(driver);
		
	}
	
	public void logout()
	{
		elemUtil.doActionClick(logout);
	}
	public RegisterPage register()
	{
		//elemUtil.doClick(logout);
		elemUtil.doClick(register);
		return new RegisterPage(driver);
	}
	
}
