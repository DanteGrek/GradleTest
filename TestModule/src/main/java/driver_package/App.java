package driver_package;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by osolomin on 15.03.17.
 */
public class App{

//    private static ThreadLocal<AppiumDriver> driverContainer = new ThreadLocal(){
//        @Override
//        protected AppiumDriver initialValue() {
//            return startApp();
//        }
//    };

    public static AppiumDriver getApp() {
        if (DriverContainer.getDriver() == null) {
            return startApp();
        }else{
            return (AppiumDriver) DriverContainer.getDriver();
        }
    }

    private static AppiumDriver startApp(){
       // File app = new File("app/Reddit.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","TA08305IHE");
        capabilities.setCapability("platformVersion", "6.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("BROWSER_NAME", "Android");
       // capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
        try {
            DriverContainer.setDriver(new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities));
//            driver.installApp(app.getAbsolutePath());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return getApp();
    }

    public static void tearDown(){
        if(getApp() != null) {
            getApp().quit();
            DriverContainer.removeDriver();
        }
    }
}
