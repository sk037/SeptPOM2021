package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constant;
import com.qa.opencart.utils.ElementUtil;

public class AccountCreatedPage {
	//WebDriver driver;
	ElementUtil elemUtil;
	
	
	public AccountCreatedPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		//this.driver=driver;
		elemUtil=new ElementUtil(driver);
	}
	
	private By accountCreationPage=By.xpath("(//title[text()=\"Your Account Has Been Created!\"])");
	
	public String getAccountCreationMsg()
	{
		return elemUtil.doGetText(accountCreationPage);
	}

}
