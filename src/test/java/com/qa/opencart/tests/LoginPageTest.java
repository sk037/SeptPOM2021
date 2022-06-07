package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constant;

public class LoginPageTest extends BaseTest {

@Test(priority = 1)
void getTitleTest()
{
   String title=loginpage.getTitle();
   Assert.assertEquals(title,Constant.LOGINPAGE_TITLE);
}

@Test(priority = 2)
void getUrlTest()
{
	Assert.assertTrue(loginpage.getUrl());
}

@Test (priority = 3)
void checkfpLinkTest()
{
	boolean result=loginpage.checkfpLink();
	Assert.assertTrue(result);
}

@Test(priority = 4)
void LoginTest()
{
	accountPage=loginpage.Login(prop.getProperty("UN"), prop.getProperty("PWD"));
	Assert.assertEquals(accountPage.getAccountPageTitle(), Constant.ACCPAGE_TITLE);
	//Assert.assertEquals(accountPage.getPageHeader(), Constant.ACC_HEADER);
	
}

@Test(priority = 5)
void RegisterationTest()
{
	loginpage.logout();
	registerpage=loginpage.register();
}
	
}
