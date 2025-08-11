package co.sqasa.steps;

import co.sqasa.pages.HomePage;
import net.thucydides.core.annotations.Step;

public class HomePageSteps {

    HomePage homePage;

    @Step("Open the website")
    public void openJQueryUIHomePage() {
        homePage.open();
    }

    @Step("Click on the DatePicker button")
    public void clickDatePickerButton() {
        homePage.clickOnDatePickerButton();
    }
}