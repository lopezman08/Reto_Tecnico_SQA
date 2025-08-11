package co.sqasa.stepdefs;

import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class SetupDriver {

    @Managed(driver = "chrome")
    WebDriver driver;

    // 1) Asegura el binario del driver ANTES de que Serenity lo cree
    @Before(order = 0)
    public void setupDriverBinary() {
        WebDriverManager.chromedriver().setup();
    }

    // 2) Maximiza la ventana ya con el driver de Serenity
    @Before(order = 1)
    public void maximizeWindow() {
        if (driver != null) {
            driver.manage().window().maximize();
        }
    }
}