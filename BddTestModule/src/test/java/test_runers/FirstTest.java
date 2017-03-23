package test_runers;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

/**
 * Created by osolomin on 22.03.17.
 */
@Test
@CucumberOptions(features = {"src/test/java/scenario"}, glue ="steps", plugin = {
        "com.github.kirlionik.cucumberallure.AllureReporter",
        "pretty", "json:build/Cucumber.json",
        "html:build/cucumber-html-report"
})
public class FirstTest extends AbstractTestNGCucumberTests {
}
