

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GBGO_LoginTest {
	AppiumDriver<WebElement> driver;
	DesiredCapabilities capabilities;

	@BeforeSuite
	public void setup() throws MalformedURLException {
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "TA9330AGBL");// replace
																		// with
																		// the
																		// respective
																		// device
																		// name
		capabilities.setCapability("appPackage", "com.GallagherBassett.GBGOClaimant");
		capabilities.setCapability("appActivity", "com.GallagherBassett.GBGOClaimant.MainActivity");
		
		capabilities.setCapability("autoGrantPermissions", "true");
		
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void loginTest() {
		System.out.println("*******Inside test******** "+new SimpleDateFormat("dd-MM-YYYY hh mm ss").format(new Date()));
	   	
		wait_forSec(20); //Wait for x Sec
		 
		 /* Enter 'Login' */		 
		 Set<String> availableContexts = driver.getContextHandles();
		    String lastestContextView = (String) availableContexts.toArray()[availableContexts.size()-1];

		    if (lastestContextView.contains("WEBVIEW_") || lastestContextView.contains("WEBVIEW_com.GallagherBassett.GBGOClaimant")){
		       // driver.context(lastestContextView);
		    	System.out.println("*******webview******* ");
		    	System.out.println(lastestContextView.toString());
		    	driver.context(lastestContextView);
		    }
		    wait_forSec(5); //Wait for x Sec.		    
		    System.out.println("*******Webview Context ******* ");

		    new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='app-background-dark']/div/button")));
		    WebElement ele1 = driver.findElement(By.xpath("//*[@id='app-background-dark']/div/button"));
			ele1.click();
	   	
			wait_forSec(5); //Wait for x Sec.

			new WebDriverWait(driver, 25).until(ExpectedConditions.presenceOfElementLocated(By.id("txtLoginEmail")));
			WebElement eleLogin = driver.findElement(By.id("txtLoginEmail"));
			eleLogin.click();
			eleLogin.sendKeys("test120@test.com");
			
			wait_forSec(2); //Wait for x Seconds
			WebElement elePassword = driver.findElement(By.id("txtLoginPassword"));
			elePassword.click();
			elePassword.sendKeys("test120@test.com");

			wait_forSec(2); //Wait for x Seconds
			WebElement eleBtnLogin = driver.findElement(By.id("btnLogin"));
			eleBtnLogin.click();
			
			wait_forSec(20); //Wait for x Seconds


         System.out.println("*******outside test******** ");

	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
	
	public void wait_forSec(int int_sec) {
		try {
			int_sec = int_sec * 1000;
			Thread.sleep(int_sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
