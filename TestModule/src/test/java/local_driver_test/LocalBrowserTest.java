package local_driver_test;

import driver_package.Browser;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by osolomin on 22.03.17.
 */
public class LocalBrowserTest {

    @BeforeClass
    public void beforeClass(){
        Browser.startLocalBrowser();
        System.out.println("\nBefore class.");

    }
    @AfterClass
    public void closeBrowser(){
        Browser.closeBrowser();
        System.out.println("\nAfter class.");
    }

    @BeforeMethod
    public void setUrl(){
        Browser.setUrl("http://www.google.com.ua");
        System.out.println("\nBefore method.");
    }

    @Test(/*enabled = false*/)
    public void browserTest() {
        Assert.assertTrue(Browser.getBrowserInstance().getCurrentUrl().contains("google"));
        System.out.println("\nTest method.");
    }

}
