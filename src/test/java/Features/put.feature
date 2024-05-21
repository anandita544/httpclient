Feature: Testing HTTP Put request

  Scenario: Send a Put request to a REST API
    Given user sends a request body {"name": "John","job": "Developer"}
    When user hit the url of put api "https://reqres.in/api/users/2"
    Then user should receive a valid status code 200
    And user get a response which contains updatedAt