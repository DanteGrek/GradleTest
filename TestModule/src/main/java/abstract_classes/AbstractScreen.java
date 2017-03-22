package abstract_classes;

import driver_package.App;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by osolomin on 16.03.17.
 */
public abstract class AbstractScreen {

    public AbstractScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(App.getApp()), this);
    }

    private WebDriverWait initWait(){
        return new WebDriverWait(App.getApp(),30);
    }

    public void acceptAlert(){
        initWait().until(ExpectedConditions.alertIsPresent()).accept();
    }

    public void tap(MobileElement element){
        initWait().ignoring(NullPointerException.class).until(ExpectedConditions.elementToBeClickable(element));
        element.tap(1,1);
    }

    public boolean isElementShown(WebElement element){
        return initWait().until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

}
