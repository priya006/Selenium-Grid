import java.net.URL;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BrowserStackSeleniumGrid {

    WebDriver driver;
    String appURL;
    String URL;
    @Parameters({"browserName", "platform", "browserversion", "os_version"})
    @BeforeTest
    public void Setup(String browserName, String platformName, String browserversion, String os_version ){
        appURL = "https://www.google.com/";
        System.out.println("browser name is : " + browserName);
          final String USERNAME = "puthiyaulagam1";
          final String AUTOMATE_KEY = "3CLwDDzsAkstEoA3sTuA";
          final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "puthiyaulagam1");
        caps.setCapability("browserstack.key", "3CLwDDzsAkstEoA3sTuA");

        caps.setCapability("browserVersion", browserversion);
        caps.setCapability("os", platformName);
        caps.setCapability("os_version",os_version);


        // Specify device and os_version for testing
         caps.setCapability("device", "Samsung Galaxy S10e");
//        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "Java Android");
        caps.setCapability("name", "first_test");

        if (browserName.equals("chrome")) {
            caps.setCapability("browserName", "chrome");
        } else if (browserName.equals("firefox")) {
            caps.setCapability("browserName", "firefox");
        }

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above

        try {
            driver = new RemoteWebDriver(new URL(URL), caps);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }



    }

    @Test
    public void TestGoogle() {
        driver.get(appURL);
        System.out.println("Site is launched");

        if (driver.getPageSource().contains("Google Search")) {
            Assert.assertTrue(true, "Google Search Found");
        } else {
            Assert.assertTrue(false, "Failed: Google Search NOT found");
        }

    }
    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }


}
