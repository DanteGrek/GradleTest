package android_driver_test;

import abstract_classes.BaseAbstractMobileTest;
import driver_package.App;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screenes.MainScreen;

/**
 * Created by osolomin on 15.03.17.
 */
public class AndroidNativeAppTest extends BaseAbstractMobileTest {

    private MainScreen mainScreen /*= new MainScreen()*/;

    @BeforeClass
    public void beforeClass(){
        mainScreen = new MainScreen();
        System.out.println("\nBefore class AndroidNativeAppTest");
    }

    @AfterClass
    public void afterClass(){
        App.tearDown();
        System.out.println("\nAfter class AndroidNativeAppTest");
    }

    @Test(enabled = false)
    public void androidNativeAppTest(){
        System.out.println("\n"+App.getApp().getContext()+"\n");
        mainScreen.clickOne();
        System.out.println("\nTest AndroidNativeAppTest");
    }
}
