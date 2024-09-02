@Home
Feature: Home Page Validation
@UserStory1
  Scenario: Validate home page title and presence of Create Primary Account button
    Given user navigates to the home page and validate the TEK Insurance App title
    Then the Create Primary Account button should exist
