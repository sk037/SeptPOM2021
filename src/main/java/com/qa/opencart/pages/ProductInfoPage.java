package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	
	WebDriver driver;
	ElementUtil elemUtil;
	HashMap<String, String> hmprodInfo;
	HashMap<String, String> hmprodPriceInfo;
	
	public ProductInfoPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		elemUtil=new ElementUtil(driver);
		
	}
	
	private By productTitle= By.xpath("//*[@id=\"content\"]//h1");
	private By productImage= By.xpath("//*[@id=\"content\"]//ul/li[@class=\"image-additional\"]");
	private By productMetaData= By.xpath("(//*[@id=\"content\"]//ul)[3]");
	private By productPrice= By.xpath("(//*[@id=\"content\"]//ul)[4]");
	
	public String getProductTitle()
	{
		String productHeader=elemUtil.doGetText(productTitle);
		System.out.println("Inside prodinfo :"+productHeader);
		return productHeader;		
	}
	
	public int imageCount()
	{
		List<WebElement> count=elemUtil.waitForElementsToBeVisible(productImage, 20);
		System.out.println("Count of Image :"+ count.size());
		return count.size();
	}

	public void productMetaDataInfo()
	{
		hmprodInfo=new HashMap<String, String>();
		List<WebElement> prodInfo= elemUtil.waitForElementsToBeVisible(productMetaData, 20);
		for(WebElement e:prodInfo)
		{
			String text=e.getText();
//			Brand: Apple
//			Product Code: Product 16
//			Reward Points: 600
//			Availability: Out Of Stock
			String[] a=text.split(":");
			String metakey=a[0];
			String metavalue=a[1];
			hmprodInfo.put(metakey, metavalue);	
			
			for(Entry<String, String> entry:hmprodInfo.entrySet())
				System.out.println(entry.getKey() +"="+entry.getValue());
		}
	}
	
	public void productPriceInfo()
	{
		hmprodPriceInfo=new HashMap<String, String>();
		List<WebElement> prodPriceInfo= elemUtil.waitForElementsToBeVisible(productPrice, 20);
		String text1=prodPriceInfo.get(0).getText();
		System.out.println(text1);
		String text2=prodPriceInfo.get(1).getText();
		System.out.println(text2);
		String[] pricetext=text2.split(":");
		hmprodPriceInfo.put("price", text1);
		hmprodPriceInfo.put(pricetext[0], pricetext[1]);
		
		for(Entry<String, String> entry1:hmprodPriceInfo.entrySet())
			System.out.println(entry1.getKey() +"="+entry1.getValue());
 	}
	
	

}
