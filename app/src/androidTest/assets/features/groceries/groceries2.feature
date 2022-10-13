Feature: Groceries 2
  # Tests for the list of groceries and the details of a particular grocery

  # Groceries list contains 10 static elements
  Scenario: User should see groceries list when opened the app
    Given The app started 2
    Then I see Groceries list screen 2

  Scenario: User should exit the app when pressing back in groceries list screen
    Given The app started 2
    And I see Groceries list screen 2
    When I press back 2
    Then I should exit the app 2