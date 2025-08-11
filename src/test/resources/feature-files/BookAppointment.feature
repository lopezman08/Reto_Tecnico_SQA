Feature: Book an appointment by selecting a date on the datepicker

  Scenario: Select a date of the current month from the calendar
    Given the user is on the JQuery website
    And clicks on the Datepicker button
    When Selects the 15th day of the current month on the calendar
    Then the selected day is the 15th of the current month

  Scenario: Select a date of the next month from the calendar
    Given the user is on the JQuery website
    And clicks on the Datepicker button
    When Selects the 10th day of the next month on the calendar
    Then the selected day is the 10th of the next month

  Scenario: Enter a date manually on the datepicker field
    Given the user is on the JQuery website
    And clicks on the Datepicker button
    When Enter the "12/06/2032" in the datepicker field
    Then the entered date is "12/06/2032" and it displayed in the calendar
