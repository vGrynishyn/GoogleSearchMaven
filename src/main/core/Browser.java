package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public  class Browser {

    public static void openWebPage(String url){
        LogInformation.info(String.format("Loading browser with %s",url));
        WebDriver wb =Driver.getWebDriver();
       // wb.manage().window().maximize();
        wb.get(url);
    }

    public static String getTitle(){
        LogInformation.info("Get browser title.");
        return Driver.getWebDriver().getTitle().toLowerCase();
    }

    public static void closeBrowser(){
        if (Driver.getWebDriver(false) != null){
            LogInformation.info("Close browser.");
            Driver.getWebDriver().quit();
            Driver.setWebDriver(null);
        }

    }
    public static void scrollToElement(WebElement element){
        ((JavascriptExecutor) Driver.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
