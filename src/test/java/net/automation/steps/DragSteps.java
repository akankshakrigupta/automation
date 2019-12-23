package net.automation.steps;

import com.typesafe.config.Config;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.automation.pages.Drag;
import utilities.ConfigLoader;

public class DragSteps {


    Drag drag;
    static Config conf = ConfigLoader.load();


    @Given("^navigate to Url$")
    public void navigateToUrl() throws Exception{
        drag.openUrl(conf.getString("drag_url"));
        drag.getDriver().manage().window().maximize();
        Thread.sleep(3000);
    }

    @When("^Drag all the item one by one into list$")
    public void dragAllTheItemOneByOneIntoList() throws Exception {
        drag.DragDropItem();
    }

    @Then("^successfully show item in dropdown item list$")
    public void successfullyShowItemInDropdownItemList() {
    }
}
