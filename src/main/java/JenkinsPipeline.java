import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class JenkinsPipeline {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/pboopathi/Downloads/chromedriver");    // <-- Change this path
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://experitest.com/";
        String expectedTitle = "Experitest: Mobile App & Cross-Browser Testing End-to-End";
        String actualTitle = "";
        driver.get(baseUrl);
        actualTitle = driver.getTitle();
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED");
        }
        driver.close();
    }

}
