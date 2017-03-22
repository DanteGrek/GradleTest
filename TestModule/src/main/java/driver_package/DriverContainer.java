package driver_package;

import org.openqa.selenium.WebDriver;

/**
 * Created by osolomin on 21.03.17.
 */
public class DriverContainer {

    private static ThreadLocal<WebDriver> driverContainer = new ThreadLocal();

    public static WebDriver getDriver(){
        return driverContainer.get();
    }

    public static void setDriver(WebDriver driver){
        driverContainer.set(driver);
    }

    public static void removeDriver(){
        driverContainer.remove();
    }

    private DriverContainer() {
    }
}
