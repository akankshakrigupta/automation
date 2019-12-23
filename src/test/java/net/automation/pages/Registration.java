package net.automation.pages;

import cucumber.api.DataTable;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class Registration extends PageObject {



    @FindBy(css = "input[name='firstname']")
    WebElementFacade firstName;

    @FindBy(xpath = "//input[@id='lastname']")
    WebElementFacade lastname;



    @FindBy(xpath = "//p[text()='Date: ']/input")
    WebElementFacade date1;

    @FindBy(xpath ="//select[@id=\"continents\"]")
    WebElementFacade cont;

    @FindBy(xpath="//input[@id=\"photo\"]")
    WebElementFacade photo;


    @FindBy(xpath = "//select[@id=\"continentsmultiple\"]")
    WebElementFacade multiSelect1;

    @FindBy(xpath = "//select[@id=\"selenium_commands\"]")
    WebElementFacade multiSelect2;

    @FindBy(xpath = "//button[@id='submit']")
    WebElementFacade btn;




    public void firstName( DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String first_name = data.get(0).get("First name");
        firstName.waitUntilVisible();
        firstName.sendKeys(first_name);
    }

    public void lastName(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String last_name = data.get(0).get("Last name");
        lastname.waitUntilVisible();
        lastname.sendKeys(last_name);
    }

    public void date(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String dates = data.get(0).get("Date");
        date1.sendKeys(dates);
        waitABit(5000);
    }

    public void enterGender(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String gender = data.get(0).get("Gender");
        getDriver().findElement(By.xpath("//input[@value='" + gender + "']")).click();
    }
    public void enterExperience(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String exp = data.get(0).get("Year of Experience");
        //((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", getDriver().findElement(By.xpath("//input[@value='" + exp + "']")));
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, 900)");
        getDriver().findElement(By.xpath("//input[@value='" + exp + "']")).click();
    }



    public void enterProfession(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String profession = data.get(0).get("Profession");
        Actions act1 = new Actions(getDriver());
        getDriver().findElement(By.xpath("//input[@value='"+profession+"']")).click();


    }

    public void profile(DataTable dataTable) //user is choosing the file from local
    {
        String current = System.getProperty("user.dir") + "/image/avatar-the-last-airbender_190013_2.jpg";
        photo.sendKeys(current);
        //System.out.println(current);
    }

    public void enterAutomationTool(DataTable dataTable){
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String tool = data.get(0).get("Automation Tool");
        Actions act = new Actions(getDriver());
        getDriver().findElement(By.xpath("//input[@type=\"checkbox\" and @ value='"+tool+"']")).click();


    }

    public void selectContients(DataTable dataTable){
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String continent=data.get(0).get("Continents");
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, 1150)");
        Select sel = new Select(cont);
        sel.selectByVisibleText(continent);
        cont.waitUntilVisible();

    }

    public void selectMultipleContinents(DataTable dataTable) //user is selecting multiple values
    {
        List<Map<String, String>> data;
        data = dataTable.asMaps(String.class, String.class);
        String continents=data.get(0).get("Continents – Multiple Select");
        String[] sep=continents.split(",");
        Select dropdown = new Select(multiSelect1);
        for(int i=0;i<sep.length;i++){ //selecting values one by one
            dropdown.selectByVisibleText(sep[i]);
        }
    }
    public void multipleCommands(DataTable dataTable) //user is selecting multiple commands
    {
        List<Map<String, String>> data;
        data = dataTable.asMaps(String.class, String.class);
        String continents=data.get(0).get("Selenium Commands");
        String[] sep=continents.split(",");
        Select dropdown = new Select(multiSelect2);
        for(int i=0;i<sep.length;i++) { //selecting values one by one
            dropdown.selectByVisibleText(sep[i]);
        }
    }

    public void buttonClick()
    {

      withAction().click(  btn).perform();
        btn.waitUntilVisible();
    }



}
