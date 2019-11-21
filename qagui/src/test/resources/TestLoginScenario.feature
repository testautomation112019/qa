@BDD
Feature: User panel

  Background:

  @wordpress @login @userprofile
  Scenario: User login
    Given User starts on main page
    When User logs to the user panel
    Then User can modify user profile


  @wordpress @login
  Scenario: User panel
    Given User starts on main page
    When User logs to the user panel
    Then User can modify user profile
#    When User update panel
#    Then user panel is updated