package pageobjects;

import core.BasePage;
import core.Browser;
import core.LogInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class GoogleResultPage extends BasePage {

    @FindBy(className = "cur")
    private WebElement numberOfCurrentPage;
    @FindBy(xpath = "//*[@class='r']/a[@href]")
    private List<WebElement> resultWebElement;
    @FindBy(className = "_Rm")
    private List<WebElement> resultUrls;
    @FindBy(id = "pnnext")
    private WebElement nextPageButton;

    /**
     * Click needed position on result page
     * @param position
     */
    public void clickNeededNumOfResultLinks(int position){
        getSearcResultWebElements().get(position).click();
    }

     /**
     * Search for result links
     */
    public ArrayList<String> getResultLinks() {
        LogInformation.info("Get searched links.");
        ArrayList<String> links = new ArrayList();
        for (WebElement element : resultUrls) {
            links.add(element.getText());
        }
        return links;
    }

    /**
     * Search for the expected template (domain name) in results search link on numOfSearchPage  pages
     * @param expectedDomainName
     * @param numOfSearchPage
     * @return
     */
    public String getSearchLinkFromResults(String expectedDomainName, int numOfSearchPage){
        LogInformation.info(String.format("Search %s link on search results pages(page: 1-5).",expectedDomainName));
        while(Integer.valueOf(numberOfCurrentPage.getText()) < numOfSearchPage)
        {
            ArrayList<String> actualDomainName = getResultLinks();
            for (String link:actualDomainName){
                if (link.contains(expectedDomainName)) {
                    return link; }
            }
            clickToNextPage();
        }
        return "";
    }

    /**
     * Search for webelements of search result title for click
     */
    private ArrayList<WebElement> getSearcResultWebElements(){
        ArrayList<WebElement> webElements = new ArrayList<>();
        for (WebElement element: resultWebElement){
            webElements.add(element);
        }
        return webElements;
    }

    /**
     * Click next page
     */
    private void clickToNextPage(){
        LogInformation.info("Click to next page.");
        Browser.scrollToElement(nextPageButton);
        nextPageButton.click();
    }
}
