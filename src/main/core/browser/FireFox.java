package core.browser;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFox {
    private WebDriver driver;
    public WebDriver getDriver(){
        return this.driver;
    }

    public FireFox(){
        FirefoxDriverManager.getInstance().setup();
        driver = new FirefoxDriver();
    }
}
