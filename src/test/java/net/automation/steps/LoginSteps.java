package net.automation.steps;

import com.typesafe.config.Config;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.automation.pages.Login;
import utilities.ConfigLoader;


public class LoginSteps {
    Login login;
    static Config conf = ConfigLoader.load();


    @Given("^user navigates to ATS$")
    public void userNavigatesToATS() {
        login.openUrl(conf.getString("login_url"));
        login.getDriver().manage().window().maximize();


    }

    @When("^When I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
    public void whenIEnterUsernameAsAndPasswordAs(String email, String passwords) {

        login.enterInvalidData( email, passwords);



    }

    @Then("^Then login should be unsuccessful$")
    public void thenLoginShouldBeUnsuccessful() {
        System.out.println("please enter valid data");
    }
}
