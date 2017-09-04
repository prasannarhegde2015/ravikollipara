package com.test.firefox;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class selerun {
	public WebDriver globalDriver;

	public void tc1_selenium() {
		try {
			String driverPath = "E:\\AllInstallablesEXE\\OpenSource\\AutomationTesting\\Selenium\\geckodriver-v0.18.0-win32\\";

			File file = new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			FirefoxBinary fbinary = new FirefoxBinary(file);
			ProfilesIni profiles = new ProfilesIni();
			FirefoxProfile fp = profiles.getProfile("Selenium");
			System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
			globalDriver = new FirefoxDriver(fbinary, fp);
			globalDriver.manage().window().maximize();
			globalDriver.get("https://dev23478.service-now.com/");
		} catch (Exception e) {
			System.out.println("Failure in  initializing Firefox Driver: " + e.toString());
		}
	}

}
