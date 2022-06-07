package com.qa.opencart.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductInfoPageTest extends BaseTest {
	
	@BeforeClass
	void setUp() {
		accountPage=loginpage.Login(prop.getProperty("UN"),prop.getProperty("PWD"));
	}
	
	//@Test
	

}
