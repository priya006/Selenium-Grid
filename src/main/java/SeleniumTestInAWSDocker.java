//
//import static org.testng.Assert.assertEquals;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//
//
//public class SeleniumTestInAWSDocker {
//
//
//
//
//        WebDriver driver;
//
//        @BeforeMethod
//        @Parameters("browser")
//        public void setup(String browser) {
//            if (browser.equalsIgnoreCase("chrome")) {
//
//                 DesiredCapabilities cap = new DesiredCapabilities();
//                 cap.setCapability("browserName", "chrome");
//                 try {
//                 driver = new RemoteWebDriver(new
//                         URL("http://35.165.129.54:4444/wd/hub"), cap);
//                 } catch (MalformedURLException e) {
//                 e.printStackTrace();
//                 }
//            }
//
//            else if (browser.equalsIgnoreCase("firefox")) {
//
//                 DesiredCapabilities cap = new DesiredCapabilities();
//                 cap.setCapability("browserName", "firefox");
//                 try {
//                 driver = new RemoteWebDriver(new
//
//                 //ec2 instance url. where the Selenium hub and Nodes are deployed as Docker container
//                 URL("http://35.165.129.54:4444/wd/hub"), cap);
//                 } catch (MalformedURLException e) {
//                 e.printStackTrace();
//                 }
//
//            }
//            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//            driver.get("https://www.freshworks.com/");
//
//        }
//
//        @Test(priority = 1)
//        public void freshWorkslogoTest() {
//            boolean flag = false;
//            flag = driver.findElement(By.cssSelector("a.logo.logo-fworks")).isDisplayed();
//            Assert.assertTrue(flag);
//        }
//
//        @Test(priority = 2)
//        public void freshWorksTitleTest() {
//            System.out.println(driver.getTitle());
//            assertEquals(driver.getTitle(), "A fresh approach to customer engagement");
//        }
//
//        @Test(priority = 3)
//        public void getFooterLinksTest() {
//            List<WebElement> footerLinksList = driver.findElements(By.cssSelector("ul.footer-nav li a"));
//            footerLinksList.forEach(ele -> System.out.println(ele.getText()));
//            assertEquals(footerLinksList.size(), 35);
//        }
//
//        @AfterMethod
//        public void tearDown() {
//            driver.quit();
//        }
//
//
//
//}
