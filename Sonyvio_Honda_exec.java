package Android;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.remote.MobileCapabilityType;

public class TestHonda {
	public RemoteWebDriver driver = null;
	// public AndroidDriver driver = null;
	// ******************** Device Version , Appium Version Details
	// Test Ran on Adroid version 7.0
	// Device Motto G4 Plus
	// Appium version desktop 1.2.1
	// Selenium version 2.53

	@BeforeTest
	public void initialize() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0");
		capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("appPackage", "com.honda.hondalink");
		capabilities.setCapability("appActivity", "com.honda.hir.HIRMain");
		try {
			driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			// driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),
			// capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testHondaLogin() {
		wait_forSec(10);
		driver.findElement(By.id("editTextUsername")).sendKeys("Hlprod0101");
		driver.findElement(By.id("editTextPassword")).sendKeys("123456");
		driver.findElement(By.id("buttonRememberMe")).click();
		driver.findElement(By.id("buttonLogin")).click();

	}

	@AfterTest
	public void teardown() {
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
