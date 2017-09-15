package core.browser;

import io.github.bonigarcia.wdm.EdgeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Edge {
    private WebDriver driver;
    public WebDriver getDriver(){
        return this.driver;
    }
    public Edge(){
        EdgeDriverManager.getInstance().setup();
        driver = new EdgeDriver();

    }
}
