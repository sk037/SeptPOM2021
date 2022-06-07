package com.qa.opencart.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constant;
import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {
	WebDriver driver;
	ElementUtil elemUtil;
	
	
	public RegisterPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		elemUtil=new ElementUtil(driver);
	}
	
	private By firstName=By.id("input-firstname");
	private By lastName=By.id("input-lastname");
	private By email=By.id("input-email");
	private By telephone=By.id("input-telephone");
	private By address=By.id("input-address-1");
	private By city=By.id("input-city");
	private By postalCode=By.id("input-postcode");
	private By country=By.id("input-country");
	private By region=By.id("input-zone");
	
	private By password=By.id("input-password");
	private By confirmPassword=By.id("input-confirm");
	private By subscribeRadioNo=By.xpath("(//*[@type='radio'])[3]");
	private By subscribeRadioYes=By.xpath("(//*[@class='radio-inline']//*[@type='radio'])[1]");
	private By policyCheckBox=By.xpath("//*[@type='checkbox']");
	private By continuebtn=By.xpath("//*[@type='submit']");
    private By accountCreationPage=By.xpath("//*[@id=\"content\"]/h1");
    private By logout=By.xpath("(//*[text()=\"Logout\"])[2]");
    private By register=By.xpath("(//*[text()=\"Register\"])[2]");
    
	
	public boolean enterRegistrationDetail(String firstName,String lastName,String email,String telephone,String address, String city, String postalCode, String country, String region,String password,String subscribe ) throws InterruptedException
	{
		elemUtil.doSendKeys(this.firstName, firstName,20);
		elemUtil.doSendKeys(this.lastName, lastName,20);
		elemUtil.doSendKeys(this.email, email,20);
		elemUtil.doSendKeys(this.telephone, telephone,20);
		elemUtil.doSendKeys(this.address, address,20);
		elemUtil.doSendKeys(this.city, city,20);
		elemUtil.doSendKeys(this.postalCode, postalCode,20);
		
		elemUtil.doDropDownSelectByVisibleText(this.country, country);
		Thread.sleep(500);
		elemUtil.doDropDownSelectByVisibleText(this.region, region);
		
		elemUtil.doSendKeys(this.password, password,20);
		elemUtil.doSendKeys(this.confirmPassword, password,20);
		
	//	elemUtil.getElement(subscribeRadioYes).click();
	//	Thread.sleep(500);
		
		if(subscribe.equals("Yes"))
			elemUtil.doActionClick(subscribeRadioYes);	
		
		else
			elemUtil.doActionClick(subscribeRadioNo);	
		
		elemUtil.doClick(policyCheckBox);	
		elemUtil.doClick(continuebtn);
		
		String msg=elemUtil.doGetText(accountCreationPage);
		System.out.println(msg);
		if(msg.contains(Constant.ACC_CREATIONMSG))
		{
			elemUtil.doClick(logout);
		    elemUtil.doClick(register);
			return true;
		}
		else
			return false;
			
		
	}
	
//	public void selectSubscribe()
//	{
//		
//	}
//	
//	public void clickOnCheckbox()
//	{
//		
//	}
	public AccountCreatedPage clickOnContinue()
	{
		return new AccountCreatedPage(driver);
	}

}
