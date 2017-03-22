package screenes;

import abstract_classes.AbstractScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created by osolomin on 16.03.17.
 */
public class MainScreen extends AbstractScreen {

//    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId('com.android.calculator2:id/digit_1')") private MobileElement one;
    @AndroidFindBy(xpath = "//*[@text = '1']") private MobileElement one;

    public void clickOne(){
        tap(one);
    }
}
