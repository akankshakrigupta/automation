package net.automation.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Table extends PageObject {

    @FindBy(xpath ="//div[@id='example_info']")
    WebElementFacade entries;

    @FindBy(xpath ="//select[@name=\"example_length\"]//option[1]")
    WebElementFacade record;

    @FindBy(xpath="//a[@id=\"example_next\"]")
    WebElementFacade nextButton;

    public void calculateEntries(){
        String[] abc = entries.getText().split(" ");
        int totalRecords = Integer.parseInt(abc[abc.length - 2]);
        int perPageRecord = Integer.parseInt(record.getText());
        int totalPage = totalRecords / perPageRecord;
        totalPage = totalRecords - totalPage * perPageRecord == 0 ? totalPage : totalPage + 1;
        int currentTotal = 0;

        for(int i = 1; i <= totalPage; i++) {
            List<WebElement> rows =  getDriver().findElements(By.xpath("//table/tbody/tr"));
            int count = rows.size();
            //System.out.println("ROW COUNT : "+count);
            currentTotal += count;
            nextButton.click();

        }

        if(currentTotal == totalRecords) {
            // show right
            System.out.println("Record is correct");
        } else {
            // show wrong msg
            System.out.println("Record is incorrect");
        }
        System.out.println("Total COUNT : "+currentTotal);
        System.out.println("Total Page:"+ totalPage);

    }





}
