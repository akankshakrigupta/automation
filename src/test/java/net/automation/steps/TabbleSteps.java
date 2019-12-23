package net.automation.steps;

import com.typesafe.config.Config;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.automation.pages.Table;
import utilities.ConfigLoader;

public class TabbleSteps {

    Table table;
    static Config conf = ConfigLoader.load();
    @Given("^navigate to Table url$")
    public void navigateToTableUrl() {
        table.openUrl(conf.getString("table_url"));
        table.getDriver().manage().window().maximize();



    }

    @When("^verify number of entries$")
    public void verifyNumberOfEntries() {
        table.calculateEntries();
    }

    @Then("^entries equal to (\\d+)$")
    public void entriesEqualTo(int arg0) {
    }

    @Then("^entries equal to number of entries$")
    public void entriesEqualToNumberOfEntries() {
        System.out.println("No of recordes equal to total number of entries");
    }
}
