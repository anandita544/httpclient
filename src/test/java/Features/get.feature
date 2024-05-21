Feature: Testing HTTP GET request

  Scenario: Send a GET request to a REST API
    Given user send a GET request
    Then user should receive a valid response
