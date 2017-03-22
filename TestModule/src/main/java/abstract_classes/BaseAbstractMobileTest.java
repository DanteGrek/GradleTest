package abstract_classes;

import driver_package.AppiumManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by osolomin on 15.03.17.
 */
public abstract class BaseAbstractMobileTest {

    private AppiumManager appiumManager;

    @BeforeTest(alwaysRun = true)
    protected void beforeTest(){
        appiumManager = new AppiumManager();
        appiumManager.startAppium();
        System.out.println("\nBefore test.");
    }

    @AfterTest(alwaysRun = true)
    protected void afterTest(){
        appiumManager.stopAppium();
        System.out.println("\nAfter test.");
    }

}
