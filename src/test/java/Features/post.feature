Feature: Testing HTTP Post request

  Scenario: Send a POST request to a REST API
    Given user sends a request body {"name": "John","job": "Developer"}
    When user hit the url of post api
    Then user should receive a valid status code 201
    And user should receive a valid responseBody