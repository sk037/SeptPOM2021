package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.pages.AccountCreatedPage;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.DriverFactory;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.SearchResultPage;

public class BaseTest {
	DriverFactory df;
	Properties prop;
	WebDriver driver;
	LoginPage loginpage;
	RegisterPage registerpage;
	AccountCreatedPage acp;
	AccountsPage accountPage;
	SearchResultPage searchresult;
	ProductInfoPage prodInfo;
	
	
	
	@BeforeTest
	public void setup() throws Exception{
		
		df=new DriverFactory();
		prop=df.init_prop();
		driver=df.init_driver(prop);
		loginpage=new LoginPage(driver);
        registerpage=new RegisterPage(driver);
        acp=new AccountCreatedPage(driver);
        accountPage=new AccountsPage(driver);
        searchresult=new SearchResultPage(driver);
        prodInfo=new ProductInfoPage(driver);
	}
	
	@AfterTest
	void tearDown() {
		//driver.quit();
		
	}

}
