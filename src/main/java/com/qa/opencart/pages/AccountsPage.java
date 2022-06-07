
package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.testng.annotations.DataProvider;

import com.qa.opencart.utils.Constant;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	
	WebDriver driver;
	ElementUtil elemUtil;
	
	public AccountsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		elemUtil=new ElementUtil(driver);
	}
	
	private By pageHeader=By.xpath("//*[text()=\"Your Store\"]");
	private By searchBar=By.xpath("//*[@name=\"search\"]");
	private By searchButton=By.xpath("//*[@id=\"search\"]/child::span/child::button[@type=\"button\"]");
	private By pageContent=By.xpath("//*[@id=\"content\"]/child::h2");
	private By sectionContent=By.xpath("(//*[@class=\"list-unstyled\"])[8]//li");
	
	
	public String getAccountPageTitle()
	{
		return elemUtil.doGetTitle(Constant.ACCPAGE_TITLE, Constant.DEFAULT_TIME_OUT);
	}
	
	public String getPageHeader()
	{
		return elemUtil.doGetText(pageHeader);
	}
	
	public List<String> getPageContent()
	{
		List<WebElement> list=elemUtil.waitForElementsToBeVisible(pageContent, Constant.DEFAULT_TIME_OUT);
		List<String> sectionElement=new ArrayList<String>();
		for(int i=0;i<list.size();i++)
		{
			String ele=list.get(i).getText();
			sectionElement.add(ele);
		}
		return sectionElement;
	}
	
	public List<String> getSectionContent()
	{
		List<WebElement> list=elemUtil.waitForElementsToBeVisible(sectionContent, Constant.DEFAULT_TIME_OUT);
		List<String> sectionContent=new ArrayList<String>();
		for(int i=0;i<list.size();i++)
		{
			String ele=list.get(i).getText();			
			sectionContent.add(ele);
		}
		return sectionContent;
	}
	public SearchResultPage search(String productname )
	{
		//System.out.println(productname);
		elemUtil.doClear(searchBar);
		elemUtil.doSendKeys(searchBar, productname,10);
		elemUtil.doClick(searchButton);
		elemUtil.doClear(searchBar);
		System.out.println("ProductName is :"+productname);
		return new SearchResultPage(driver);	
	}			
}
