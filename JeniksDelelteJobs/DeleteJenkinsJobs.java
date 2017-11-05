package com.javatpoint;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteJenkinsJobs {
	public static WebDriver drv = null;
	public static WebDriverWait wt = null;
	public static String chromedriverpath = "E:\\Prasanna\\JavaTutorial\\Selenium\\chromedriver_win32\\chromedriver.exe";

	public static void main(String[] args) throws InterruptedException, AWTException {
		setup();
		login("Prasanna", "97bd916$");
		for (int i = 11; i < 52; i++) {
			String strjobid = Integer.toString(i);
			deletejobs(strjobid);

		}
		teardown();
	}

	public static void setup() {

		String baseurl = "http://13.126.109.72:8080";
		System.setProperty("webdriver.chrome.driver", chromedriverpath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches", "--disable-extensions");
		options.addArguments("disable-infobars");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		options.setExperimentalOption("prefs", prefs);
		drv = new ChromeDriver(options);
		drv.manage().window().maximize();
		drv.get(baseurl);
		wt = new WebDriverWait(drv, 500);
	}

	public static void login(String userName, String passWord) {
		wt.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("j_username")));
		drv.findElement(By.id("j_username")).sendKeys(userName);
		drv.findElement(By.name("j_password")).sendKeys(passWord);
		drv.findElement(By.id("yui-gen1-button")).click();
	}

	public static void deletejobs(String jobid) throws InterruptedException, AWTException {
		drv.findElement(By.linkText("BitBucket Test")).click();
		String xpathlocator = "//a[contains(@href,\"" + jobid + "\")]";

		System.out.println("Xpath locator" + xpathlocator);
		System.out.println("looking for link " + jobid);
		By bylocator = By.linkText("#" + jobid);
		if (elemexists(bylocator)) {
			// if (elemexists(By.xpath(xpathlocator))) {
			System.out.println("looking for Exisitng  link " + jobid);
			// movetoelem(drv.findElement(By.xpath(xpathlocator)));
			// scroll(drv.findElement(By.xpath(xpathlocator)));
			// robotmousemove(drv, drv.findElement(By.xpath(xpathlocator)));
			// scroll_Page(drv, drv.findElement(By.xpath(xpathlocator)), 200);
			Jscroll(drv.findElement(bylocator));
			drv.findElement(bylocator).click();
			wt.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.linkText("Delete Build")));
			drv.findElement(By.linkText("Delete Build")).click();
			wt.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[text()=\"Yes\"]")));
			drv.findElement(By.xpath("//button[text()=\"Yes\"]")).click();
		}

	}

	public static void teardown() {
		drv.close();
		drv.quit();
	}

	public static boolean elemexists(By bylocator) {
		boolean iselem = true;
		try {
			drv.findElement(bylocator);
		} catch (Exception e) {
			iselem = false;
		}

		return iselem;
	}

	public static void movetoelem(WebElement elm) {
		Actions acn = new Actions(drv);
		acn.moveToElement(elm).build().perform();
		acn.moveToElement(elm, 50, 50);
	}

	public static void scroll(WebElement e) throws InterruptedException {
		System.out.println("ln Scroll Function");
		Coordinates cor = ((Locatable) e).getCoordinates();
		cor.inViewPort();
		Thread.sleep(1000);
		System.out.println("Out Scroll Function");
	}

	public static void robotmousemove(WebDriver dr, WebElement el) throws AWTException, InterruptedException {
		org.openqa.selenium.Point point = el.getLocation();
		int xcord = point.getX();
		System.out.println("Element's Position from left side Is " + xcord + " pixels.");
		int ycord = point.getY();
		Robot r = new Robot();// construct a Robot object for default screen
		r.mouseMove(xcord, ycord);
		Thread.sleep(2000);
	}

	public static void scroll_Page(WebDriver drv, WebElement webelement, int scrollPoints) {

		// JavascriptExecutor jse = (JavascriptExecutor)drv;
		// jse.executeScript("window.scrollBy(0,250)", "");
		// jse.executeScript("scroll(0, 250);");
		// Identify the WebElement which will appear after scrolling down
		// WebElement element =
		// driver.findElement(By.xpath(".//*[@id='mCSB_3_container']/p[3]"));
		// now execute query which actually will scroll until that element is not
		// appeared on page.
		// je.executeScript("arguments[0].scrollIntoView(true);",element);
		try {
			Actions dragger = new Actions(drv);
			// drag downwards
			int numberOfPixelsToDragTheScrollbarDown = 10;
			// for (int i = 10; i < scrollPoints; i = i +
			// numberOfPixelsToDragTheScrollbarDown)
			// {
			dragger.moveToElement(webelement).clickAndHold().moveByOffset(0, numberOfPixelsToDragTheScrollbarDown)
					.release(webelement).build().perform();
			// }
			Thread.sleep(500);
			// return true;
		} catch (Exception e) {
			e.printStackTrace();
			// return false;
		}
	}

	public static void Jscroll(WebElement webelement) {
		JavascriptExecutor jse = (JavascriptExecutor) drv;
		// jse.executeScript("window.scrollBy(0,250)", "");
		// jse.executeScript("scroll(0, 250);");
		// Identify the WebElement which will appear after scrolling down
		// WebElement element =
		// driver.findElement(By.xpath(".//*[@id='mCSB_3_container']/p[3]"));
		// now execute query which actually will scroll until that element is not
		// appeared on page.
		jse.executeScript("arguments[0].scrollIntoView(true);", webelement);
	}
}
