package com.qa.opencart.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccountCreatedPageTest extends BaseTest {
	
@BeforeClass
public void AccountCreatedPageTestSetup()
{
   acp=registerpage.clickOnContinue();
   System.out.println(acp);
}

@Test
public void getAccountCreationMsgTest()
{
	String a=acp.getAccountCreationMsg();
	System.out.println(a);
}
}
