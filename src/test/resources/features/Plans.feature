@Plans
Feature: Plans
  Background:
    Given user navigates to the home page and validate the TEK Insurance App title
    When user click on Login button
    Then user enter username "supervisor" and "tek_supervisor" as password
    Then user navigated to "Customer Service Portal"

    @UserStory12
  Scenario: Validate 4 row of data is present
    Given user navigates to the Plans Page and click on it
    Then plans page should be displayed
    And there should be 4 rows of data

    @UserStory13
  Scenario: Validate date
      Given user navigates to the Plans Page and click on it
      Then validate the Create Date is today's date in EST Time Zone
      And validate the Expire Date is one day after today's date in EST Time Zone

