@Accounts
Feature: Accounts
  Background:
    Given user navigates to the home page and validate the TEK Insurance App title
    Then user click on Login button
    Then user enter username "supervisor" and "tek_supervisor" as password
    Then user navigated to "Customer Service Portal"
  @UserStory14
    Scenario: Navigate to Customer Service Portal with valid CSR credentials and navigate to Accounts verify 5 row
    Given user navigates to the Accounts Page and click on it
    Then user should see 5 rows per page by default
  @UserStory15
  Scenario: change drop down from 5 to 10, 25, 50
    Given user navigates to the Accounts Page and click on it
    Then user should see 5 rows per page by default
    Then click on drop down option Show 5 to 10
    And user should see 10 rows per page
    Then click on drop down option Show 10 to 25
    And user should see 25 rows per page
    Then click on drop down option Show 25 to 50
    And user should see 50 rows per page