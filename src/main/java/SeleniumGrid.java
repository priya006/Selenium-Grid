import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SeleniumGrid {

    WebDriver driver;
    String baseURL, hubURL;

    @BeforeTest
    public void setUp() throws MalformedURLException {

        baseURL = "https://www.google.com/";
        hubURL = "http://localhost:4444/wd/hub";
        DesiredCapabilities capability = new DesiredCapabilities();

        //Node A
        capability.setPlatform(Platform.MAC);
        capability.setBrowserName("firefox");


        //Node B
        capability.setPlatform(Platform.ANDROID);
        capability.setBrowserName("chrome");
        capability.setCapability("platformName", "Android");
        //real Device Version
        capability.setVersion("86.0.4240.185");

        //Node C
        //Emulator version
        capability.setVersion("83.0.4103.106");

        //Node D
        //Real Device IOS Ipad16GB
//        capability.setPlatform(Platform.IOS);
//        capability.setBrowserName("safari");
//        capability.setCapability("platformName", "Ios");
//        capability.setVersion("9");
//        capability.setCapability("deviceName", "Ipad16gb");
//        capability.setCapability("automationName" , "XCUITest");
//        capability.setCapability("udid", "aab81c2d-22e9-4d8c-8e6f-b3a7f45090fa");



        //Node E
        //Simulator
        capability.setPlatform(Platform.IOS);
        capability.setBrowserName("safari");
        capability.setCapability("platformName", "Ios");
        capability.setVersion("13.1");
        capability.setCapability("deviceName", "iPhone");
        capability.setCapability("udid","971651FD-BFBC-41DF-B67A-C13BB11844D4");
        capability.setCapability("automationName" , "XCUITest");

        //Start the driver
        driver = new RemoteWebDriver(new URL(hubURL), capability);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
    @Test
    public void sampleTest() {
        driver.get(baseURL);
        System.out.println("Site is launched");

        if (driver.getPageSource().contains("Google Search")) {
           Assert.assertTrue(true, "Google Search Found");
        } else {
            Assert.assertTrue(false, "Failed: Google Search NOT found");
        }

    }
}
