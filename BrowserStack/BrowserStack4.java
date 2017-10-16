package com.javatpoint;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserStack4 {

	public static final String USERNAME = "prasannahegde3"; // Prasanna: prasannahegde3 | Sohail: mohammadsohail3
	public static final String AUTOMATE_KEY = "swqrmuuvpPHgsmcDAGgz"; // Prasanna: swqrmuuvpPHgsmcDAGgz Sohail:
																		// d2ZswsyGqsUQotWdLf9U

	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	// hub.browserstack.com
	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browser", "chrome");
		caps.setCapability("browserstack.debug", "true");
		caps.setCapability("build", "First build");
		caps.setCapability("name", "single_appium_test");
		caps.setCapability("realMobile", true);
		caps.setCapability("device", "Google Pixel");
		caps.setCapability("device", "Samsung Galaxy S7");
		// "galaxy_s7": { "device": "Samsung Galaxy S7"
		System.out.println("-------------------------Test Started-----------------------------------");
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
		WebDriverWait wt = new WebDriverWait(driver, 300);
		driver.get("http://13.126.109.72/home/");
		Thread.sleep(2000);
		wt.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("PHP Samples")));
		WebElement element = driver.findElement(By.linkText("PHP Samples"));
		element.click();
		wt.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("Create Web List.")));
		WebElement element2 = driver.findElement(By.linkText("Create Web List."));
		element2.click();
		wt.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name("firstname")));
		driver.findElement(By.name("firstname")).sendKeys("Prasanna");
		driver.findElement(By.name("lastname")).sendKeys("Hegde");
		driver.findElement(By.name("email")).sendKeys("Prasannarhegde@gmail.com");
		driver.findElement(By.name("phone")).sendKeys("9768125870");
		driver.findElement(By.name("address")).sendKeys("Arolic555");
		driver.findElement(By.name("btnsubmit")).click();
		Thread.sleep(7000);
		String bdtxt = driver.getPageSource();
		if (bdtxt.contains("Prasanna")) {
			System.out.println("-------------------------Test Passed----------------------------------");
		} else {
			System.out.println("-------------------------Test Failed----------------------------------");
		}

		System.out.println(driver.getTitle());
		System.out.println("-------------------------Test Ended-----------------------------------");
		driver.quit();

	}
}
