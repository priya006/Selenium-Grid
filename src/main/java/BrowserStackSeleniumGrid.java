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

    @Parameters({"browser", "platform", "browser_version"})
    @BeforeTest
    public void Setup(String browserName, String platformName, String versionName ){
        appURL = "https://www.google.com/";
        System.out.println("browser name is : " + browserName);
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "puthiyaulagam1");
        caps.setCapability("browserstack.key", "3CLwDDzsAkstEoA3sTuA");

        caps.setCapability("browserVersion", versionName);
        caps.setCapability("platformName", platformName);

        // Set URL of the application under test
        caps.setCapability("app", appURL);

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
            driver = new RemoteWebDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), caps);
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
