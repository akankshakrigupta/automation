package net.automation.pages;

import com.typesafe.config.Config;
import net.thucydides.core.pages.PageObject;
//import org.apache.xpath.operations.String;
import utilities.ConfigLoader;

public class Google extends PageObject {
    private static Config config= ConfigLoader.load();

    public void goToHomePage(){
       // String url=config.getString("URL");
       // getDriver().get(url);
       // waitABit(1000);
//

    }


}
