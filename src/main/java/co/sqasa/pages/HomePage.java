package co.sqasa.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class HomePage extends PageObject {

    @FindBy(xpath = "//a[@href=\"https://jqueryui.com/datepicker/\"]")
    private WebElementFacade datePickerButton;

    public void clickOnDatePickerButton() {
        datePickerButton.click();
    }

}
