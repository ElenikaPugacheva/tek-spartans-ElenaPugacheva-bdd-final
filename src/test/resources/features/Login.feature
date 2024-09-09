@Login
Feature: Login
  Background:
    Then user click on Login button
  @UserStory7 @Positive
  Scenario: Navigate to login by clicking on Login button and enter valid csr user
    Then user enter username "supervisor" and "tek_supervisor" as password
    Then user navigated to "Customer Service Portal"
  @UserStory8 @UserStory9 @Negative
  Scenario Outline: Navigate to login and validate error messages
    Then user enter username "<username>" and "<password>" as password
    Then user should see an error "<expectedErrorMessage>"
    Examples:
      | username    | password       | expectedErrorMessage       |
      | supervisorp | tek_supervisor | User supervisorp not found |
      | supervisor  | tek_supervis   | Password not matched       |
