package com.test.extent;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class SimpleTest {
	
	public static String baseurl = "https://dev23478.service-now.com";
	public static String iedriverpath = "D:\\Users\\Prasanna\\Automation\\Selenium\\Selenium Jar and Drivers\\IEDriverServer_Win32_2.53.1\\IEDriverServer.exe";
	public static String CHROMEdriverpath = "D:\\Users\\Prasanna\\Automation\\Selenium\\Selenium Jar and Drivers\\chromedriver_win32\\chromedriver.exe";
    public static WebDriver globalDriver = null;
    public static String ScreenshotDirectory = "D:\\Users\\Prasanna\\Automation\\Sample Utilities  and Coding\\Java\\RunTest\\Screenshots" ;
    public static String colnamesarray = "TestStep;Expected;Actual;Status";
    public static String  reportfilepath = "";
    static ExtentReports   report = null;
    static  ExtentIt   ext = new ExtentIt();
  
	public static void main(String[] args) throws InterruptedException, IOException
	{
		reportfilepath = System.getProperty("user.dir") + "\\Report\\reports.html";
	    report=new ExtentReports(reportfilepath, false);
	    test1();
	    test2();
	}
	
	public static void  test1() throws InterruptedException, IOException
	{
		setupdriver();
		ExtentTest logger=report.startTest("test case 1");
		globalDriver.get(baseurl);
		WebDriverWait wait = null ;
		try
		{
			wait = new WebDriverWait(globalDriver, 500);
		}
		catch(Exception ex)
		{
			
		}
		globalDriver.switchTo().frame(0);
		ext.creatextentReport(globalDriver, reportfilepath, logger, colnamesarray, "Step1;Befoerlog;Step1;Pass", ext.getscreenshotfilename());
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_name")));
		globalDriver.findElement(By.id("user_name")).clear();
		globalDriver.findElement(By.id("user_name")).sendKeys("admin");
		globalDriver.findElement(By.id("user_password")).clear();
		globalDriver.findElement(By.id("user_password")).sendKeys("admin");
		globalDriver.findElement(By.id("sysverb_login")).click();
		wait(5);
		ext.creatextentReport(globalDriver,reportfilepath, logger, colnamesarray, "Step2;Error;error;Fail", ext.getscreenshotfilename());
		globalDriver.close();
		globalDriver.quit();
		report.endTest(logger);
		report.flush();
		System.out.println("Test Ended Please llok at reports genereted ");
	}
	
	public static void  test2() throws InterruptedException, IOException
	{
		setupdriver();
		globalDriver.get(baseurl);
		ExtentTest logger=report.startTest("test case 2");
		globalDriver.get(baseurl);
		WebDriverWait wait = null ;
		try
		{
			wait = new WebDriverWait(globalDriver, 500);
		}
		catch(Exception ex)
		{
			
		}
		globalDriver.switchTo().frame(0);
		ext.creatextentReport(globalDriver,reportfilepath, logger, colnamesarray, "Step1;Befoerlog;Befoerlog;Pass", ext.getscreenshotfilename());
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_name")));
		globalDriver.findElement(By.id("user_name")).clear();
		globalDriver.findElement(By.id("user_name")).sendKeys("admin");
		globalDriver.findElement(By.id("user_password")).clear();
		globalDriver.findElement(By.id("user_password")).sendKeys("ServiceNow97bd916$");
		globalDriver.findElement(By.id("sysverb_login")).click();
		wait(12);
		ext.creatextentReport(globalDriver,reportfilepath, logger, colnamesarray, "Step2;Logsuccesg;Logsucccess;Pass", ext.getscreenshotfilename());
		
		globalDriver.close();
		globalDriver.quit();
		report.endTest(logger);
		report.flush();
		System.out.println("Test Ended Please llok at reports genereted ");
	}
	
	
	public static void  setupdriver()
	{
		System.setProperty("webdriver.chrome.driver", CHROMEdriverpath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches","--disable-extensions");
		options.addArguments("chrome.switches","--disable-infobars");
		Map<String, Object> prefs = new HashMap<String, Object>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    options.setExperimentalOption("prefs", prefs);
		globalDriver= new ChromeDriver(options);
		globalDriver.manage().window().maximize();
		globalDriver.get(baseurl);
		
		
	}
	
	public static void wait(int secs) throws InterruptedException
	{
		secs = secs * 1000;
		Thread.sleep(secs);
		
	}
		

}
