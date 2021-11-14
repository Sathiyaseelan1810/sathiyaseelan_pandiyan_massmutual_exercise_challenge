package com.test.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.listener.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author SATHIYASEELAN
 * 
 * Note: This Base class file to Instantiate the Web Driver and Properties Class 
 */
public class TestBase implements TestUtils
{	
	public static WebDriver driver;
	public static Properties properties;
	
	// Constructor to call the Properties File and get the values based on the key 
	public TestBase() 
	{
		try 
		{
			properties = new Properties();
			FileInputStream fileInput = new FileInputStream("D:\\GitHubLocal\\MockupExercise\\src\\main\\java\\com\\test\\config\\config.properties");
			properties.load(fileInput);			
		} 
		catch (IOException e)
		{
			Reporter.addStepLog("Config Files is not loaded " + e.getMessage());
		}
	}
	
	//launch browser
	public void browserInitialize()
	{
		String browserName = properties.getProperty("browser");
		if(browserName.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Reporter.addStepLog("Key matched and 'Chrome' browser is launched");	
			ReportLogs.logPassed(browserName + " browser is launched sucessfully");			
		}
		else		
			Reporter.addStepLog("Key not Matched with the config file");					
	}
	
	//Close Browser
	public void closeBrowser()
	{
		try 
		{
			driver.close();
			ReportLogs.logPassed("'Chrome' browser is closed sucessfully");	
		} 
		catch (Exception e) 
		{
			ReportLogs.logFailed("'Chrome' browser is not closed" + e.getMessage());	
		}
	}
	
	//Maximize Browser
	public void maximizeBrowser()
	{
		try 
		{
			implicitWait();
			driver.manage().window().maximize();
			ReportLogs.logPassed("Maximized the 'Chrome' browser");
		} 
		catch (Exception e) 
		{
			ReportLogs.logFailed("Unable to maximize the 'Chrome' browser" + e.getMessage());
		}
	}
	
	//Delete the cookies
	public void deleteCookies()
	{
		try 
		{
			implicitWait();
			driver.manage().deleteAllCookies();
			ReportLogs.logPassed("Deleted the cookies from the browser");
		} 
		catch (Exception e) 
		{
			ReportLogs.logFailed("Unable to delete the cookies from the browser " + e.getMessage());
		}
	}
	
	//Page Time load out
	public void pageLoadTime()
	{
		try 
		{
			implicitWait();
			driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			ReportLogs.logPassed("Page load Timeout applied");
		} 
		catch (Exception e) 
		{
			ReportLogs.logFailed("Page load Timeout not applied " + e.getMessage());
		}
	}
	
	//Implicit Wait
	public void implicitWait()
	{
		try 
		{
			driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
			ReportLogs.logPassed("Implicit wait applied");
		} 
		catch (Exception e) 
		{
			ReportLogs.logFailed("Implicit wait not applied" + e.getMessage());
		}
	}
	
	//Navigate URL
	public void navigateURL()
	{
		try 
		{
			maximizeBrowser();deleteCookies();pageLoadTime();
			driver.navigate().to(properties.getProperty("url"));
			ReportLogs.logPassed("Navigated to the URL " + properties.getProperty("url"));
		} 
		catch (Exception e) 
		{
			ReportLogs.logFailed("Unable to navigate to the url " + properties.getProperty("url"));
		}
	}
	
	

}
