package com.qa.opencart.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	WebDriver driver;
	Properties prop;
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();
	
	
	public WebDriver init_driver(Properties prop)
	{
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		
		System.out.println(browserName + " launching");
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver();
		    /*Set the setHeadless is equal to true which will run test in Headless mode*/
			
			//ChromeOptions option=new ChromeOptions();
            //option.setHeadless(true);
			//driver=new ChromeDriver(option);
			tlDriver.set(new ChromeDriver());
			
			
		}
		
		else if(browserName.equals("Firefox"))
				{
			WebDriverManager.firefoxdriver().setup();
			//driver=new FirefoxDriver();
			tlDriver.set(new FirefoxDriver());
		}
		
	 getDriver().manage().window().maximize();
	 getDriver().manage().deleteAllCookies();
	 getDriver().get(prop.getProperty("URL"));
	 
	 return getDriver();
	}
	
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}
	
	public Properties init_prop()
	{
		prop=new Properties();
		FileInputStream fis=null;
		
		String envName=System.getProperty("env");
		
		if(envName == null) {
			System.out.println("Executing Prod env");
		try {
			fis = new FileInputStream("./src/test/resource/config/config.properties");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		else {
			
				System.out.println(envName);
				try {
			switch (envName) {
			case "qa":
				fis = new FileInputStream("./src/test/resource/config/qa.config.properties");
				break;
			case "dev":
				fis = new FileInputStream("./src/test/resource/config/dev.config.properties");	
				break;
			case "stage":
				fis = new FileInputStream("./src/test/resource/config/stage.config.properties");

			default:
				System.out.println("Enter correct environment name");
				break;
			}
			}
				catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		}
		
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
		
	}
	
	public String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	

}
