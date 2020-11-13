//import java.net.URL;
//
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.Assert;
//import org.testng.annotations.*;
//
//
//import java.util.concurrent.TimeUnit;
//
//import java.net.MalformedURLException;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//
//
//public class BrowserStackSeleniumGrid {
//
//    WebDriver driver;
//    String appURL;
//    String URL;
//    @Parameters({"browser", "os", "browserversion", "os_version"})
//    @BeforeTest
//    public void Setup(String browser, String os, String browserversion, String os_version){
//        appURL = "https://www.google.com/";
//        System.out.println("browser name is : " + browser);
//
//        // Set your access credentials
////        caps.setCapability("browserstack.user", "puthiyaulagam1");
//  //        caps.setCapability("browserstack.key", "3CLwDDzsAkstEoA3sTuA");
//          final String USERNAME = "puthiyaulagam1";
//          final String AUTOMATE_KEY = "3CLwDDzsAkstEoA3sTuA";
//          final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
//        DesiredCapabilities caps = new DesiredCapabilities();
//
//
//
//        caps.setCapability("browser_version", browserversion);
//        caps.setCapability("os_version",os_version);
//
//        // Set other BrowserStack capabilities
//        caps.setCapability("project", "Cross Browser Testing");
//        caps.setCapability("build", "Selenium Grid Using BrowserStack");
//
//        if (browser.equals("chrome")) {
//            caps.setCapability("browser", "chrome");
//            caps.setCapability("os", os);
//            caps.setCapability("name", "ChromeTest_Mac");
//        } else if (browser.equals("firefox")) {
//            caps.setCapability("browser", "firefox");
//            caps.setCapability("os", os);
//            caps.setCapability("name", "FireFoxTest_Windows");
//        }else if(os.equals("iOS")  )
//        {
//            caps.setCapability("browser", "safari");
//            caps.setCapability("os", os);
//            caps.setCapability("name", "ChromeTest_IOS_RealDevice");
//            caps.setCapability("deviceName", "iPad Pro 12.9 2020");
//            caps.setCapability("realMobile", "true");
//        }
//
//        else if(os.equals("Android")  )
//        {
//            caps.setCapability("browser", "chrome");
//            caps.setCapability("os", os);
//            caps.setCapability("name", "ChromeTest_Android_RealDevice");
//            caps.setCapability("deviceName", "Google Pixel 3 XL");
//            caps.setCapability("realMobile", "true");
//        }
//
//        // Initialise the remote Webdriver using BrowserStack remote URL
//        // and desired capabilities defined above
//
//        try {
//            driver = new RemoteWebDriver(new URL(URL), caps);
//            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//
//
//    }
//
//    @Test
//    public void TestGoogle() {
//        driver.get(appURL);
//        System.out.println("Site is launched");
//
//        if (driver.getPageSource().contains("Google Search")) {
//            Assert.assertTrue(true, "Google Search Found");
//        } else {
//            Assert.assertTrue(false, "Failed: Google Search NOT found");
//        }
//
//    }
//    @AfterTest(alwaysRun = true)
//    public void tearDown() {
//        driver.quit();
//    }
//
//
//}
