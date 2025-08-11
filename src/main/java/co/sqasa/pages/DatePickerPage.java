package co.sqasa.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class DatePickerPage extends PageObject {

    @FindBy(xpath = "//h1[@class=\"entry-title\"]")
    private WebElementFacade datePickerPageTitle;

    @FindBy(xpath = "//iframe[@class='demo-frame']")
    private WebElementFacade iframe;

    @FindBy(id = "datepicker")
    public WebElementFacade txtDatePicker;

    @FindBy(css = "a.ui-datepicker-next")
    private WebElementFacade btnNextDatepicker;

    public void datePickerPageVisible() {
        datePickerPageTitle.isDisplayed();
    }

    public void openDatePicker() {
        waitFor(iframe).waitUntilPresent();
        getDriver().switchTo().frame(iframe);
        waitFor(txtDatePicker).waitUntilClickable().click();
    }

    public void selectDayOfTheMonth(int day) {
        WebElementFacade selectDay = find(By.xpath("//a[contains(@class,'ui-state-default') and @data-date='"+day+"']") );
        selectDay.waitUntilClickable().click();
    }

    public void clickNextButtonCalendar() {
        btnNextDatepicker.waitUntilClickable().click();
    }
    public void enterDateManually(String date) {
        txtDatePicker.waitUntilVisible().typeAndEnter(date);
    }


}
