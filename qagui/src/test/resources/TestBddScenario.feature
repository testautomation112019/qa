@BDD
Feature: User profile

  Background:

  @wordpress @login @userprofile
  Scenario: User profile
    Given User starts on main page
    When User logs to the user panel
    Then User can modify user profile


  @wordpress @login
  Scenario: User profile 2
    Given User starts on main page
    When User logs to the user panel
    Then User can modify user profile
#    When User update panel
#    Then user panel is updated