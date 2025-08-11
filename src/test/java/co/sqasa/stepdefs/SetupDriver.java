package co.sqasa.stepdefs;

import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class SetupDriver {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Before(order = 0)
    public void setupDriverBinary() {
        WebDriverManager.chromedriver().setup();
    }

    @Before(order = 1)
    public void maximizeWindow() {
        if (driver != null) {
            driver.manage().window().maximize();
        }
    }
}