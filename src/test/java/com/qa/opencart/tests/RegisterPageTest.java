package com.qa.opencart.tests;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constant;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest {
	
	@BeforeClass
	void setUp()
	{
		registerpage=loginpage.register();
		//System.out.println(registerpage);
	}
	
	String getRandomEmail()
	{
		Random randomGenerator=new Random();
		String email="Automation"+randomGenerator.nextInt(1000)+"@gmail.com";
		return email;
	}
	
	@DataProvider
	public Object[][] registerData() throws EncryptedDocumentException, IOException
	{
		    Object[][] obj=ExcelUtil.readData(Constant.SHEET_NAME);
			return obj;
		
	}
	
	@Test(dataProvider = "registerData" )
	void enterRegistrationDetailTest(String firstName,String lastName,String telephone,String address, String city, String postalCode, String country, String region,String password,String subscribe) throws InterruptedException
	{
		Boolean result=registerpage.enterRegistrationDetail(firstName, lastName, getRandomEmail(), telephone, address, city, postalCode, country, region, password, subscribe);

         Assert.assertTrue(result);
	}
	

}
