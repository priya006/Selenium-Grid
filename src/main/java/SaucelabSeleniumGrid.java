import org.openqa.selenium.WebDriver;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class SaucelabSeleniumGrid {

    WebDriver driver;
    String appURL;


    @Parameters({"browser", "platform", "version"})
    @BeforeTest
    public void setUp(String browserName, String platformName, String versionName) {
        appURL = "https://www.google.com/";
        System.out.println("browser name is : " + browserName);
      //  String methodName = name.getName();

        MutableCapabilities sauceOpts = new MutableCapabilities();
        //sauceOpts.setCapability("name", methodName);
//        sauceOpts.setCapability("build", "Java-W3C-Examples");
        sauceOpts.setCapability("seleniumVersion", "3.141.59");
        sauceOpts.setCapability("username", "priya006");
        sauceOpts.setCapability("accessKey", "3f001225-4309-46e2-8447-381b56a2a03f");
        sauceOpts.setCapability("tags", "w3c-chrome-tests");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("sauce:options", sauceOpts);
        cap.setCapability("browserVersion", versionName);
        cap.setCapability("platformName", platformName);

        if (browserName.equals("chrome")) {
            cap.setCapability("browserName", "chrome");
        } else if (browserName.equals("firefox")) {
            cap.setCapability("browserName", "firefox");
        }
        // https://priya006:3f001225-4309-46e2-8447-381b56a2a03f@ondemand.us-west-1.saucelabs.com:443/wd/hub
        try {
            driver = new RemoteWebDriver(new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub"), cap);
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
