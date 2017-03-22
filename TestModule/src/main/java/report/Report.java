package report;

import driver_package.DriverContainer;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;

/**
 * Created by osolomin on 21.03.17.
 */
public class Report implements ITestListener {

    @Attachment (value = "Screenshot", type = "image/png")
    private byte[] makeScreenshot() {
        return ((TakesScreenshot) DriverContainer.getDriver()).getScreenshotAs(OutputType.BYTES);
    }


    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        makeScreenshot();
        System.out.println("\nMAKE SCREENSHOT\n");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        makeScreenshot();
        System.out.println("\nMAKE SCREENSHOT\n");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        makeScreenshot();
        System.out.println("\nMAKE SCREENSHOT\n");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

}
