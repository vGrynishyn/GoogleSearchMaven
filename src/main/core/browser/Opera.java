package core.browser;

import io.github.bonigarcia.wdm.OperaDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Opera {
    private WebDriver driver;
    public WebDriver getDriver(){
        return this.driver;
    }
    public Opera(){
        OperaDriverManager.getInstance().setup();
        driver = new OperaDriver();
    }
}
