import org.openqa.selenium.WebDriver;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class SaucelabSeleniumGrid {

    WebDriver driver;

    @Parameters({"browser", "platform", "version"})
    @BeforeMethod
    public void setUp(String browserName, String platformName, String versionName,  Method name) {

        System.out.println("browser name is : " + browserName);
        String methodName = name.getName();

        MutableCapabilities sauceOpts = new MutableCapabilities();
        sauceOpts.setCapability("name", methodName);
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

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
