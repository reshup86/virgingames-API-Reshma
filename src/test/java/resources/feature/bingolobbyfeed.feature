Feature: Testing bingo games features of virgin games
  As a user I want to verify bingo games API features

  Scenario: I want to verify response data of bingo games
    Given I am on virgin games bingo field
    When I send Get request to the Lobby feed endpoint
    Then I get valid status code 200
    And  I verify that the stream name is "BloxBingoVirgin" at streams index