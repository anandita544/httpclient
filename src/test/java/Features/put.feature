Feature: Testing HTTP Put request

  Scenario: Send a Put request to a REST API
    Given user sends a request body
    When user hit the url of put api
    Then user should receive a valid status code 200
    And user get a response which contains updatedAt