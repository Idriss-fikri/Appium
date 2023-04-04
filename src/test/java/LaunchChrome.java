import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.URL;

public class LaunchChrome {

    public static void main(String[] args) {
        try {
            openChrome(); // Appel de fonction .
        } catch (Exception exp) {
            System.out.println(exp.getCause());
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }
    }

    public static void openChrome() throws Exception {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        cap.setCapability(ChromeOptions.CAPABILITY, options);

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AppiumDriver driver = new AndroidDriver(url, cap);
        driver.get("https://www.google.com");


        // recupere l'url  de google

        // Find the accept cookies button by its CSS selector
        WebElement acceptButton = driver.findElement(By.cssSelector("#L2AGLb"));

        if (acceptButton.isDisplayed()) {
            acceptButton.click();
        }
        
        driver.quit();
    }
}