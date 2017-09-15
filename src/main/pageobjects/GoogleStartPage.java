package pageobjects;

import core.BasePage;
import core.Browser;
import core.LogInformation;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleStartPage extends BasePage {

    @FindBy(id = "lst-ib")
    private WebElement searchField;

    /**
     * Open the specified webpage
     * @param url
     * @return
     */
    public GoogleStartPage openWebPage(String url){
        LogInformation.info(String.format("Open '%s' address", url));
        Browser.openWebPage(url);
        if (!searchField.isDisplayed())
            LogInformation.error(String.format("Web page %s has not been loaded.", url));
        return this;
    }

    /**
     * Search for specified pattern
     * @param pattern
     * @return
     */
    public GoogleResultPage searchPattern(String pattern){
        LogInformation.info(String.format("Search for '%s' pattern", pattern));
        searchField.sendKeys(pattern + Keys.ENTER);
        return new GoogleResultPage();
    }
}
