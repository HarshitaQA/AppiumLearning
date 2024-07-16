import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class FirstSampleTest {
    @Test
    public void VerifyThatUserIsAbleToNavigateLoginPage() throws MalformedURLException {

        AndroidDriver driver;

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName","UiAutomator2");
        capabilities.setCapability("appium:deviceName","Medium Phone API 34");
        capabilities.setCapability("appium:app", "D:\\Projects\\Appium_Learning\\src\\main\\resources\\General-Store.apk");

        //This line creates a new AndroidDriver instance, connecting to the Appium server on localhost (127.0.0.1)and port 4723,
        // passing the previously configured options.
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);

        //Sets an implicit wait of 10 seconds.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Find the element with id and enter any name
        driver.findElement(By.id("nameField")).sendKeys("Gunjan Donga");

        //Hide the keyboard after entering the name.
       driver.hideKeyboard();

        //Click on the element
       // MobileElement element = driver.findElement(By.xpath("your_xpath"));
        //element.click();
        driver.findElement(AppiumBy.id("radioFemale")).click();
        driver.findElement(AppiumBy.id("android:id/text1")).click();

        //Scroll to the element
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Argentina']")).click();

        driver.findElement(AppiumBy.id("btnLetsShop")).click();

        String title = driver.findElement(AppiumBy.xpath("(//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productName'])[1]")).getAttribute("text");

        //Assert and verifies navigation to the product listing page.
        Assert.assertEquals(title, "Air Jordan 4 Retro", "The user is not navigated on the product listing page.");
    }
}
