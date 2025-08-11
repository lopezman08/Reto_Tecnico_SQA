package co.sqasa.steps;

import co.sqasa.pages.DatePickerPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DatePickerSteps {

    private DatePickerPage datePickerPage;
    private LocalDate currentDate = LocalDate.now();
    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.US);

    @Step("Datepicker title is visible")
    public void datePickerPageVisible() {
        datePickerPage.datePickerPageVisible();
    }

    @Step("Select date of the current month on the calendar")
    public void selectDateCurrentMonth(int day) {
        datePickerPage.openDatePicker();
        datePickerPage.selectDayOfTheMonth(day);
    }

    @Step("Validate selected date is shown in the field with current month and year")
    public void validateSelectedDateCurrentMonthYear(int selectedDay) {
        LocalDate dateSelected = readSelectedDate();
        Assert.assertThat(dateSelected.getYear(), equalTo(currentDate.getYear()));
        Assert.assertThat(dateSelected.getMonth(), equalTo(currentDate.getMonth()));
        Assert.assertThat(dateSelected.getDayOfMonth(), equalTo(selectedDay));
    }

    @Step("Select date of the next month on the calendar")
    public void selectDateNextMonth(int day) {
        datePickerPage.openDatePicker();
        datePickerPage.clickNextButtonCalendar();
        datePickerPage.selectDayOfTheMonth(day);
    }

    @Step("Validate selected date is shown in the field with current month and year")
    public void validateSelectedDateNextMonthYear(int selectDay) {
        LocalDate dateSelected = readSelectedDate();
        Assert.assertThat(dateSelected.getYear(), equalTo(currentDate.getYear()));
        Assert.assertThat(dateSelected.getMonth(), equalTo(currentDate.getMonth().plus(1)));
        Assert.assertThat(dateSelected.getDayOfMonth(), equalTo(selectDay));
    }

    @Step("Enter the date manually")
    public void enterTheDateManually(String date) {
        datePickerPage.openDatePicker();
        datePickerPage.enterDateManually(date);
    }

   @Step("Validate that the entered date manually matches the displayed date in the field")
    public void validateEnteredDateManuallyIsCorrect(String expectedDate) {
        LocalDate expected = LocalDate.parse(expectedDate, DATE_FMT);
        LocalDate enteredDate = readSelectedDate();
        if(!expected.equals(enteredDate)) {
            throw new AssertionError(String.format(
                    "Expected: %s | Actual: %s",
                    expected.format(DATE_FMT),
                    enteredDate.format(DATE_FMT)
            ));
        }
    }

    private LocalDate readSelectedDate() {
        String selectedDate = datePickerPage.txtDatePicker.getValue();
        return LocalDate.parse(selectedDate, DATE_FMT);
    }

}
