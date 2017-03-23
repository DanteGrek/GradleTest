package steps;

import cucumber.api.java.en.Given;

/**
 * Created by osolomin on 22.03.17.
 */
public class DefaultStepDef {

    @Given("Print hello$")
    public void print() throws Throwable {
        System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\nHello\n");
    }
}
