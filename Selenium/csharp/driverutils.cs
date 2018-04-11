using System;
using System.Collections.Generic;
using System.Configuration;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Firefox;
using OpenQA.Selenium.IE;

namespace WebUIAutomationTests.SeleniumFramework
{
    static class DriverUtils
    {
        public static IWebDriver globalDriver = null;
        public static string baseurl = "";

        private static void InitializeDriver()
        {
            Trace.WriteLine("Starting Browser ...");
            string browser = ConfigurationManager.AppSettings["browser"];
            string firefoxbinary = ConfigurationManager.AppSettings["ffbinary"];
            baseurl = ConfigurationManager.AppSettings["baseurl"];

            switch (browser.ToLower())
            {
                case "ie":
                    {
                        var options = new InternetExplorerOptions
                        {
                            EnableNativeEvents = true, // just as an example, you don't need this
                            IgnoreZoomLevel = true,
                            IntroduceInstabilityByIgnoringProtectedModeSettings = true
                        };

                        globalDriver = new InternetExplorerDriver(options);
                        globalDriver.Manage().Window.Maximize();
                        globalDriver.Navigate().GoToUrl(baseurl);
                        break;
                    }
                case "chrome":
                    {
                        var options = new ChromeOptions();
                        options.AddArguments("chrome.switches", "--disable-extensions --disable-extensions-file-access-check --disable-extensions-http-throttling --disable-infobars --enable-automation --start-maximized");
                        options.AddUserProfilePreference("credentials_enable_service", false);
                        options.AddUserProfilePreference("profile.password_manager_enabled", false);
                        globalDriver = new ChromeDriver(options);
                        globalDriver.Manage().Window.Maximize();
                        globalDriver.Navigate().GoToUrl(baseurl);
                        break;
                    }
                case "firefox":
                    {
                        // Set all desired Firefox profiles using profiles Ini
                        try
                        {
                            FirefoxBinary fbinary = new FirefoxBinary(firefoxbinary);
                            FirefoxProfile profiles = new FirefoxProfile();
                            globalDriver = new FirefoxDriver(profiles);
                            globalDriver.Manage().Window.Maximize();
                            globalDriver.Navigate().GoToUrl(baseurl);
                        }
                        catch (Exception e)
                        {
                            Trace.WriteLine("Failure in  initializing Firefox Driver: " + e.ToString());
                        }

                        break;
                    }
                default:
                    break;
            }

        }

        public static IWebDriver getDriver()
        {
            if (globalDriver == null)
            {
               InitializeDriver();

            }
            return globalDriver;
        }

    }
}
