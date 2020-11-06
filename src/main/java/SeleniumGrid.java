import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import sun.misc.Version;

public class SeleniumGrid {

    WebDriver driver;
    String baseURL, hubURL;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        baseURL = "http://demo.guru99.com/test/guru99home/";
        hubURL = "http://10.227.181.119:4444/wd/hub";
        DesiredCapabilities capability = new DesiredCapabilities();
        //capability.setBrowserName("firefox");
        //capability.setPlatform(Platform.MAC);
        capability.setPlatform(Platform.ANDROID);
        capability.setCapability("platformName", "Android");
        //real Device Version
       // capability.setVersion("86.0.4240.110");
        //Emulator version
        capability.setVersion("83.0.4103.106");
        capability.setBrowserName("chrome");
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
