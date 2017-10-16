package testsaucelab;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BrowserStack {

  public static final String USERNAME = "mohammadsohail3"; // Prasanna: prasannahegde3 | Sohail: mohammadsohail3
  public static final String AUTOMATE_KEY = "d2ZswsyGqsUQotWdLf9U"; //Prasanna: swqrmuuvpPHgsmcDAGgz Sohail: d2ZswsyGqsUQotWdLf9U
  
  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

  // hub.browserstack.com 
  public static void main(String[] args) throws Exception {

    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("browser", "chrome");
    caps.setCapability("browserstack.debug", "true");
    caps.setCapability("build", "First build");
    caps.setCapability("name", "single_appium_test");
    caps.setCapability("realMobile", true);
    caps.setCapability("device", "Samsung Galaxy S7");
    //     "galaxy_s7": {    "device": "Samsung Galaxy S7"

    WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
    driver.get("http://www.google.com");
    WebElement element = driver.findElement(By.name("q"));

    element.sendKeys("BrowserStack");
    element.submit();

    System.out.println(driver.getTitle());
    driver.quit();

  }
}
