package com.qa.opencart.pages;

import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.opencart.utils.ElementUtil;

public class SearchResultPage {
	WebDriver driver;
	ElementUtil elemUtil;
	
	public SearchResultPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		elemUtil=new ElementUtil(driver);
	}
	
	private By searchPage=By.xpath("//*[@id=\"content\"]/child::label[text()=\"Search Criteria\"]");
	private By productResult=By.cssSelector("div.caption a");
	private By mainProduct=By.xpath("//*[@id=\"content\"]//div[@class=\"product-thumb\"]//a[text()=\"MacBook Air\"]");
	
	
	public String getSearchPageText()
	{
		return elemUtil.doGetText(searchPage);
	}

	public int getProductCount()
	{
		List<WebElement> resultCount=elemUtil.waitForElementsToBeVisible(productResult, 10, 2000);
		return resultCount.size();	
		
	}
	
	public ProductInfoPage selectProduct(String Product) {
		List<WebElement> result=elemUtil.waitForElementsToBeVisible(productResult, 20, 3000);
		for (WebElement c:result) {	
			if(c.getText().equals(Product)) {
				System.out.println("Main Product name is :"+Product);
				c.click();
				//elemUtil.doClear(mainProduct);
			    break;
		}
		}
		return new ProductInfoPage(driver);
	
		
	}
}
