package net.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class Login extends PageObject {
    @FindBy(xpath = "//input[@name=\"email\"]")
    WebElementFacade email1;

    @FindBy(xpath = "//input[@name=\"password\"]")
    WebElementFacade password1;

    @FindBy(xpath = "//div[@class=\"alert alert-danger\"]")
    WebElementFacade message;

    @FindBy(xpath="//button[@class=\"btn btn-primary btn-block btn-flat\"]")
    WebElementFacade btn;

    public void enterInvalidData(String email ,String passwords)
    {
        email1.sendKeys(email);
        password1.sendKeys(passwords);
        btn.withTimeoutOf(10, TimeUnit.SECONDS).click();

        System.out.print(message.getText());


    }





}
