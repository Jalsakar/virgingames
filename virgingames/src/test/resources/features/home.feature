@regression @Disha
Feature: Home Page Feature
  In Order to test Modern Slavery Statement in Home Page
  As a User
  I should navigate to MODERN SLAVERY POLICY Page successfully.

  Background:
    Given I Launch browser
    When  I Navigate to URL "https://www.virgingames.com/"
    And   I click on Manage All Cookies button
    Then  I Verify that home page is visible successfully

  @Sanity
  Scenario: Verify Modern Slavery Statement in home page
    When  I Scroll down to footer
    Then  I Verify text 'Modern Slavery Statement'
    And   I click on Modern Slavery Statement
    Then  I Navigate to Modern Slavery Policy Page
    Then  I Verify header message 'MODERN SLAVERY ACT TRANSPARENCY STATEMENT' is visible on page