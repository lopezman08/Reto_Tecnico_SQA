package co.sqasa.stepdefs;

import co.sqasa.steps.DatePickerSteps;
import co.sqasa.steps.HomePageSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class TestStepDefinition {
    
    @Steps
    HomePageSteps homePageSteps;
    @Steps
    DatePickerSteps datePickerSteps;

    @Given("the user is on the JQuery website")
    public void goToJQueryUIHomePage(){
        homePageSteps.openJQueryUIHomePage();
    }

   @Given("^clicks on the Datepicker button$")
    public void clicksOnTheDatepickerButton() {
        homePageSteps.clickDatePickerButton();
    }

    @When("^Selects the (\\d+)th day of the current month on the calendar$")
    public void selectsTheDayOfTheCurrentMonthOnTheCalendar(int day) {
        datePickerSteps.datePickerPageVisible();
        datePickerSteps.selectDateCurrentMonth(day);
    }

    @Then("^the selected day is the (\\d+)th of the current month$")
    public void theSelectedDateShouldBeDisplayedInTheTextField(int day) {
        datePickerSteps.validateSelectedDateCurrentMonthYear(day);
    }

    @When("^Selects the (\\d+)th day of the next month on the calendar$")
    public void selectsTheThDayOfTheNextMonthOnTheCalendar(int day) {
        datePickerSteps.selectDateNextMonth(day);
    }


    @Then("^the selected day is the (\\d+)th of the next month$")
    public void theSelectedDayFromTheNextMonthIsDisplayedInTheCalendar(int day) {
        datePickerSteps.validateSelectedDateNextMonthYear(day);
    }

    @When("^Enter the \"([^\"]*)\" in the datepicker field$")
    public void enterTheDateInTheDatepickerField(String date) {
        datePickerSteps.enterTheDateManually(date);
    }


    @Then("^the entered date is \"([^\"]*)\" and it displayed in the calendar$")
    public void theEnteredDateIsDisplayedInTheCalendar(String expectedDate) {
        datePickerSteps.validateEnteredDateManuallyIsCorrect(expectedDate);
    }

}
