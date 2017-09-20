
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class AhaApp {

	private static RemoteWebDriver driver;
	
	@Test
	public void test1() throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
		capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "FA6B30300082"); //Pixel FA6B30300082 -- Samsung 4df1b7b052888f8b
		//capabilities.setCapability(MobileCapabilityType.UDID, "YT91165DPG");
		//capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.honda.hondalink");		
		capabilities.setCapability("appActivity", "com.honda.hir.HIRMain");		
		
		/*capabilities.setCapability("autoAcceptAlerts", true);		
		capabilities.setCapability("autoDismissAlerts", true);*/

		driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		
		
		
		System.out.println("driver : :"+driver);
		wait_forSec(15); //Wait for x Sec 
		//new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.id("com.honda.hondalink:id/editTextUsername")));
		
		
	/*	driver.findElement(By.id("com.honda.hondalink:id/editTextUsername")).sendKeys("Hlprod0101");
		
		driver.fin
		driver.findElement(By.id("com.honda.hondalink:id/editTextPassword")).sendKeys("123456");
		*/
		
		//driver.findElement(By.name("Email (Honda ID). Editing.")).sendKeys("Hlprod0101");
		wait_forSec(15); //Wait for x Sec 
		driver.findElement(By.id("com.honda.hondalink:id/editTextUsername")).sendKeys("Hlprod0101");
		driver.findElement(By.id("com.honda.hondalink:id/editTextPassword")).sendKeys("123456");
		//driver.findElement(By.xpath("//*[@id='editTextUsername']")).sendKeys("Hlprod0101");
		//new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='editTextPassword']")));
		//driver.findElement(By.xpath("//*[@id='editTextPassword']")).sendKeys("123456");
	//	//driver.hideKeyboard();
		driver.navigate().back();
		driver.findElement(By.id("com.honda.hondalink:id/buttonRememberMe")).click();
	//	driver.preseekeycode();
		
		
		
		driver.findElement(By.id("com.honda.hondalink:id/buttonLogin")).click();
		
		driver.findElement(By.xpath("//*[@id='navLeftButton']")).click();
		driver.findElement(By.xpath("//*[@class='android.widget.RelativeLayout' and ./*[@text='Support']]")).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='About']")));
		driver.findElement(By.xpath("//*[@text='About']")).click();
		wait_forSec(10); //Wait for x Sec  
	//	driver.pressKeyCode(AndroidKeyCode.BACK);
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='View FAQs']")));
		driver.findElement(By.xpath("//*[@text='View FAQs']")).click();
		driver.findElement(By.xpath("//*[@id='faq_dropdown_item_1']")).click();

		driver.findElement(By.xpath("//*[@text='How do I recover my username and password?']")).click();
		wait_forSec(2); //Wait for x Sec  
	//	driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.findElement(By.xpath("//*[@id='faq_dropdown_item_3']")).click();
		wait_forSec(2); //Wait for x Sec  
		driver.findElement(By.xpath("//*[@text='How do I contact Customer Service for questions about my vehicle or the app?']")).click();
		wait_forSec(2); //Wait for x Sec  
	//	driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.findElement(By.xpath("//*[@id='faq_dropdown_item_2']")).click();
		driver.findElement(By.xpath("//*[@text='Why can’t I use my app to change my station settings while in the vehicle?']")).click();
		wait_forSec(2); //Wait for x Sec  
		driver.findElement(By.xpath("//*[@id='navRightButton']")).click();
		driver.findElement(By.xpath("//*[@id='navLeftButton']")).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Associated Accounts']")));
		driver.findElement(By.xpath("//*[@text='Associated Accounts']")).click();
		/* */
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@contentDescription='Facebook Link']")));
		driver.findElement(By.xpath("//*[@contentDescription='Facebook Link']")).click();
		/* */
		wait_forSec(5); //Wait for x Sec  
	//	driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.findElement(By.xpath("//*[@id='navRightButton']")).click();
		driver.findElement(By.xpath("//*[@id='navLeftButton']")).click();
		driver.findElement(By.xpath("//*[@id='logout_view']")).click();
		wait_forSec(2); //Wait for x Sec  
		driver.findElement(By.xpath("//*[@text='Yes']")).click();
	}
	
	@After
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
