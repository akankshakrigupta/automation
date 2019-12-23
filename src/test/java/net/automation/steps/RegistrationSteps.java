package net.automation.steps;

import com.typesafe.config.Config;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.automation.pages.Registration;
import utilities.ConfigLoader;

public class RegistrationSteps {
    Registration registration;
    static Config conf = ConfigLoader.load();

    @Given("^I am on a new user registration page$")
    public void iAmOnANewUserRegistrationPage() {
        registration.openUrl(conf.getString("webdriver_base_url"));
        registration.getDriver().manage().window().maximize();
    }

    @When("^I enter valid data on the page$")
    public void iEnterValidDataOnThePage(DataTable dataTable) {
        registration.firstName(dataTable);
        registration.lastName(dataTable);
        registration.enterGender(dataTable);
        registration.enterExperience(dataTable);
        registration.date(dataTable);
        registration.enterProfession(dataTable);
        registration.profile(dataTable);
        registration.enterAutomationTool(dataTable);
        registration.selectContients(dataTable);
        registration.selectMultipleContinents(dataTable);
        registration.multipleCommands(dataTable);


    }



    @Then("^the user registration should be successfully$")
    public void theUserRegistrationShouldBeSuccessfully() {
        registration.buttonClick();
    }


}
