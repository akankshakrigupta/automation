package net.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class Drag extends PageObject {

    @FindBy(xpath = "//div[@id='todrag']//span[1]")
    WebElementFacade From;


    @FindBy(xpath = "//div[@id='mydropzone']")
    WebElementFacade To;


    public void DragDropItem() {


        Actions builder = new Actions(getDriver());

        Action dragAndDrop = builder.clickAndHold(From)
                .moveToElement(To)
                .build();

        dragAndDrop.perform();


    }
}

