package com.qa.opencart.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.utils.Constant;
import com.qa.opencart.utils.ExcelUtil;


public class AccountsPageTest extends BaseTest {
	@BeforeClass
	void setUp()
	{
		accountPage=loginpage.Login(prop.getProperty("UN"),prop.getProperty("PWD"));
	}

	@Test
	void getAccountPageTitleTest()
	{
		assertEquals(accountPage.getAccountPageTitle(),Constant.ACCPAGE_TITLE);
	}
	
	/*
	@Test
	void getPageHeaderTest()
	{
		assertEquals(accountPage.getPageHeader(),Constant.ACC_HEADER);
	}
	*/
	
	@Test
	void getPageContentTest()
	{
	 List<String> accPgC=accountPage.getPageContent();
	 Assert.assertEquals(accPgC, Constant.getPageContentConstant());
	}
	
	@Test
	void getSectionContentTest()
	{
	 List<String> accSecC=accountPage.getSectionContent();	
	// System.out.println(accSecC);
	 Assert.assertEquals(accSecC, Constant.getSectionContentConstant());
	}
	
	@Test(dataProvider = "productData")
	void searchTest(String data)
	{
		searchresult=accountPage.search(data);
		Assert.assertEquals(searchresult.getSearchPageText(),Constant.SEARCHED_PAGE);
		Assert.assertTrue(searchresult.getProductCount()>0);
	}
	
	@DataProvider
	Object[][] productData()
	{
		Object[][] data= {{"Mac"},{"Samsung"},{"Apple"}};
		return data;
	}
	
	@Test(dataProvider = "productDataComplex")
	void searchProductTest(String data1, String data2)
	{
		searchresult=accountPage.search(data1);
		prodInfo=searchresult.selectProduct(data2);
		Assert.assertEquals(prodInfo.getProductTitle(),data2);	
	}
	
	@DataProvider
	Object[][] productDataComplex()
	{
		Object[][] data= {{"Mac","MacBook"},
				         {"Samsung","Samsung Galaxy Tab 10.1"}};
		return data;
	}
	
//	@DataProvider
//	public Object[][] productDataComplex() throws EncryptedDocumentException, IOException
//	{
//		Object[][] data= ExcelUtil.readData(Constant.PRODUCT_SHEET_NAME);
//		return data;
//	}
//	
//	@Test(dataProvider ="productDataComplex")
//	void imageCountTest(String data1, String data2)
//	{
//		searchresult=accountPage.search(data1);
//		prodInfo=searchresult.selectProduct(data2);
//		assertTrue(prodInfo.imageCount() > 0);
//	}
//	
//	@Test(dataProvider ="productDataComplex")
//	void productMetaDataInfoTest(String data1, String data2)
//	{
//		searchresult=accountPage.search(data1);
//		prodInfo=searchresult.selectProduct(data2);
//		prodInfo.productMetaDataInfo();
//	}
//	
//	@Test(dataProvider ="productDataComplex")
//	void productPriceInfoTest(String data1, String data2)
//	{
//		searchresult=accountPage.search(data1);
//		prodInfo=searchresult.selectProduct(data2);
//		prodInfo.productPriceInfo();
//	}
}
