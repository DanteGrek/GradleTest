package driver_package;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by osolomin on 15.03.17.
 */
public class Browser{
    static{
        ChromeDriverManager.getInstance().setup();
        FirefoxDriverManager.getInstance().setup();
    }

    private static ThreadLocal<String> browserType = new ThreadLocal<>();

    public static WebDriver getBrowserInstance(){
        return DriverContainer.getDriver();
    }

    public static WebDriver startLocalBrowser(){
        setBrowserType("local");
        return getDriver();
    }

    public static WebDriver startRemoteBrowser(){
        setBrowserType("remote");
        return getDriver();
    }

    public static WebDriver startAndroidBrowser(){
        setBrowserType("android");
        return getDriver();
    }

    public static void setUrl(String url){
            getDriver().get(url);
        }

    private static void setBrowserType(String type){
        browserType.set(type);
    }

    public static String getBrowserType(){
        return browserType.get();
    }

    private static WebDriver getDriver(){
        if(DriverContainer.getDriver() != null){
            return DriverContainer.getDriver();
        }
        switch (browserType.get()) {
            case "android":
                //	System.out.println("@ANDROID");
                DriverContainer.setDriver(initializeAndroidDriver());
                break;
            case "remote":
                //		System.out.println("@REMOTE");
                DriverContainer.setDriver(initializeRemoteDriver());
                DriverContainer.getDriver().manage().window().maximize();
                break;
            default:
                //    System.out.println("@LOCAL");
                DriverContainer.setDriver(initializeLocalDriver());
                DriverContainer.getDriver().manage().window().maximize();
                break;
        }
        return DriverContainer.getDriver();
    }

    private static AppiumDriver initializeAndroidDriver() {
        DesiredCapabilities cap = DesiredCapabilities.android();
        cap.setCapability("deviceName", "TA08305IHE");
        cap.setCapability("version", "6.0");
        cap.setCapability("platformName", Platform.ANDROID);
        cap.setCapability("browserName", BrowserType.CHROME);
        try {
            return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static WebDriver initializeRemoteDriver() {
        DesiredCapabilities cap;
        try {
            String browserProperty = System.getProperty("browser");
            if (browserProperty == null || browserProperty.equals("") || browserProperty.equals("chrome")) {
                cap = DesiredCapabilities.chrome();
            } else {
                cap = DesiredCapabilities.firefox();
            }
            return new RemoteWebDriver(new URL("http://10.10.0.71:4477/wd/hub"), cap);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static WebDriver initializeLocalDriver() {
        String browserProperty = System.getProperty("browser");
        if(browserProperty == null){
            browserProperty = "chrome";
        }
        if (browserProperty.equals("firefox")) {
            return new FirefoxDriver();
        } else {
            return new ChromeDriver();
        }
    }

    public static void closeBrowser(){
        if(DriverContainer.getDriver() != null) {
            DriverContainer.getDriver().quit();
            DriverContainer.removeDriver();
        }

    }
}
