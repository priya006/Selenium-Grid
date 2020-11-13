//import org.openqa.selenium.*;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import java.net.MalformedURLException;
//import java.net.URL;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.Assert;
//import org.testng.annotations.*;
//
//public class SeleniumGrid {
//
//    WebDriver driver;
//    String appURL, hubURL;
//
//    @Parameters({"portNO"})
//    @BeforeTest
//    public void setUp(String portNO ) throws MalformedURLException {
//
//        appURL = "https://www.google.com/";
//        hubURL = "http://127.0.0.1:4444/wd/hub";
//        DesiredCapabilities capability = new DesiredCapabilities();
//
//        if(portNO.equalsIgnoreCase("5566")) {
//            //Node A
//            //Mac As Node
//            System.out.println("Firefox Browser Test Environment created");
//            capability.setPlatform(Platform.MAC);
//            capability.setBrowserName("firefox");
//            //Start the driver
//            driver = new RemoteWebDriver(new URL(hubURL), capability);
//        }
//
//        else
//            if(portNO.equalsIgnoreCase("4725")) {
//                //Node B
//                //Android Real Device
//                System.out.println("Chrome Browser Test Environment created in Android Real Device");
//                capability.setPlatform(Platform.ANDROID);
//                capability.setBrowserName("chrome");
//                capability.setCapability("platformName", "Android");
//                //real Device Version
//                capability.setVersion("86.0.4240.185");
//                capability.setCapability("automationName", "UiAutomator2");
//                driver = new RemoteWebDriver(new URL(hubURL), capability);
//            }
//
//
//            else
//                if(portNO.equalsIgnoreCase("4999")) {
//                    //Node C
//                    //Emulator version
//                    System.out.println("Chrome Browser Test Environment created in Android Emulator");
//                    capability.setPlatform(Platform.ANDROID);
//                    capability.setBrowserName("chrome");
//                    capability.setCapability("platformName", "Android");
//                    capability.setVersion("83.0.4103.106");
//                    capability.setCapability("automationName", "UiAutomator2");
//                    driver = new RemoteWebDriver(new URL(hubURL), capability);
//                }
//
//        //Node D
//        //Real Device IOS Ipad16GB
////        capability.setPlatform(Platform.IOS);
////        capability.setBrowserName("safari");
////        capability.setCapability("platformName", "Ios");
////        capability.setVersion("9");
////        capability.setCapability("deviceName", "Ipad16gb");
////        capability.setCapability("automationName" , "XCUITest");
////        capability.setCapability("udid", "aab81c2d-22e9-4d8c-8e6f-b3a7f45090fa");
//
//
//
//        //Node E
//        //IOS Simulator
//        else
//            if(portNO.equalsIgnoreCase("5777")) {
//                capability.setPlatform(Platform.IOS);
//                capability.setBrowserName("safari");
//                capability.setCapability("platformName", "Ios");
//                capability.setVersion("13.1");
//                capability.setCapability("deviceName", "iPhone");
//                capability.setCapability("udid", "971651FD-BFBC-41DF-B67A-C13BB11844D4");
//                capability.setCapability("automationName", "XCUITest");
//                driver = new RemoteWebDriver(new URL(hubURL), capability);
//            }
//
//            else
//                System.err.println("Provide correct port no");
//
//    }
//
//    @AfterTest
//    public void afterTest() {
//        driver.quit();
//    }
//    @Test
//    public void sampleTest() {
//        driver.get(appURL);
//        System.out.println("Site is launched");
//
//        if (driver.getPageSource().contains("Google Search")) {
//           Assert.assertTrue(true, "Google Search Found");
//        } else {
//            Assert.assertTrue(false, "Failed: Google Search NOT found");
//        }
//
//    }
//}
