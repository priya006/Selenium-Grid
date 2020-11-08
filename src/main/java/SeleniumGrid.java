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

        baseURL = "http://demo.guru99.com/test/guru99home/";
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
        capability.setPlatform(Platform.IOS);
        capability.setBrowserName("safari");
        capability.setCapability("platformName", "Ios");
        capability.setVersion("9");
        capability.setCapability("AutomationName" , "XCUITest");



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


        if (driver.getPageSource().contains("MOBILE TESTING")) {
            Assert.assertTrue(true, "Mobile Testing Link Found");
        } else {
            Assert.assertTrue(false, "Failed: Link not found");
        }

    }
}
