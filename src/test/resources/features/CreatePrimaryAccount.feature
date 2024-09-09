@CreatePrimaryAccount
Feature: Create account Validation
  Background:
    Then the Create Primary Account button should exist and click on it
    Then user should be navigated to the Create Account form page
    Then user enter "Elena" in "First Name" field
    Then user enter "FEMALE" in "Gender" field
    Then user enter "SDET" in "Employment Status" field
    Then user enter "Ms." in "Title/Prefix" field
    Then user enter "Pugacheva" in "Last Name" field
    Then user enter "Married" in "Marital Status" field
  @UserStory2 @Positive
  Scenario: Navigate to Create Account page and validate form title
    Then user enters random email into "Email Address" field
    Then user enter "02/14/1991" in "Date Of Birth" field
    Then user click on "Create Account" button
  @UserStory3 @Negative
  Scenario: Validate user navigate to page and email address shows as expected
    Then user enters random email into "Email Address" field
    Then user enter "02/14/1991" in "Date Of Birth" field
    Then user click on "Create Account" button
    When user should be navigated on Sign up your account page
    Then user navigate to page email address and full name shows as expected
    Then user enter "elev73i03" in the Create Account username field
    Then user enter "Mona3yo#" in the Create Account password field
    Then user enter "Mona3yo#" in the Create Account confirm password field
    Then user click on "Submit" button
    Then validate Sign in to your Account page
  @UserStory4 @Negative
  Scenario Outline: Create account with existing email address and validate error message as expected
    Then user enter "elenikapu@gmail.com" in "Email Address" field
    Then user enter "02/14/1991" in "Date Of Birth" field
    Then user click on "Create Account" button
    Then user should see an error message
    Examples:
      | expectedResult                                  |
      | Account with email elenikapu@gmail.com is exist |
  @UserStory5
  Scenario: Create account with age less than 18 years old and validate error message as expected
    Then user enters random email into "Email Address" field
    Then user enter "02/14/2011" in "Date Of Birth" field
    Then user click on "Create Account" button
    Then user should see an error message 'you must be 18 years or older to create account'
  @UserStory6
  Scenario: Navigate To Create Account Page, Create a valid account
    Then user enters random email into "Email Address" field
    Then user enter "02/14/1991" in "Date Of Birth" field
    Then user click on "Create Account" button
    When user should be navigated on Sign up your account page
    Then user navigate to page email address and full name shows as expected
    Then user enter "elenmoni2103@" in the Create Account username field
    Then user enter "Mona3yo#" in the Create Account password field
    Then user enter "Mona3yo#" in the Create Account confirm password field
    Then user click on "Submit" button
    Then validate Sign in to your Account page
    Then user enter "elenmoni2103@" in the Sign In username field
    Then user enter "Mona3yo#" in the Sign In password field
    Then user click on "Sign In" button
    Then click on profile button
    Then validate FULL NAME displayed at profile section