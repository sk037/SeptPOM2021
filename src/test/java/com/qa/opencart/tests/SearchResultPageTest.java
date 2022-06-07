package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constant;

public class SearchResultPageTest extends BaseTest {
	@BeforeClass
	void setUp()
	{
		accountPage=loginpage.Login(prop.getProperty("UN"),prop.getProperty("PWD"));
	}
	
	@Test
	void getSearchPageTextTest()
	{
		searchresult=accountPage.search("Mac");
		System.out.println(searchresult.getSearchPageText());
		Assert.assertEquals(searchresult.getSearchPageText(), Constant.SEARCHED_PAGE);
	}
	
	@Test
	void getProductResultTest()
	{
		searchresult=accountPage.search("Mac");
		Assert.assertTrue(searchresult.getProductCount()>0);
	}
	
	@Test
	void selectProductTest()
	{
		searchresult=accountPage.search("Mac");
		prodInfo=searchresult.selectProduct("MacBook Air");
	}
}
