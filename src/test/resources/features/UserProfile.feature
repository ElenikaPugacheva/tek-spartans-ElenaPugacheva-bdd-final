@UserProfile
Feature: User Profile
  Background:
    Given user navigates to the home page and validate the TEK Insurance App title
    Then user click on Login button
    Then user enter username "supervisor" and "tek_supervisor" as password
    Then user navigated to "Customer Service Portal"
    @UserStory10
  Scenario: Validate Profile Info in Profile Side Drawer
    When user click on Profile button
    Then validate information in Profile Side Drawer is should match
      | User Type   | CSR        |
      | Full Name   | Supervisor |
      | UserName    | supervisor |
      | Authorities | admin      |
    @UserStory11
  Scenario: click on profile button and then click on Logout button make sure user navigate to home page
      When user click on Profile button
      Then user click on "Logout" button
      Given user navigates to the home page and validate the TEK Insurance App title


