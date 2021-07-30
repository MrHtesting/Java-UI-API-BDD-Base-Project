Feature: POC Feature

  @test
  Scenario: POC Scenario
    #When I click on Search using JS
   # When I enter abc in Search
    Then I should see element text are
      | Text Check   | Text.1 |
      | Text Check 2 | Text.1 |
   # When I click element Submit button

  Scenario:
    When I click element xyz
    When I enter abc in xyz
    When I select xyz from abc
    When I scroll to abc
    And I wait for element
    When I hover over element
    When I get Placeholder from Element
    And I select current window

    When I click on element using JS
    When I enter random String/Numbers of length in field
    When I enter random Email in field


    Then I should see current page URL contains xyz
    Then I should see abc text is abc
    Then I should see abc is displayed
    Then I should see xyz is selected

    Then I should see elements are displayed
      | xyz |
      | abc |
      | qwe |



