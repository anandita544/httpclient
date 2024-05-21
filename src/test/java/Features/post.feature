Feature: Testing HTTP Post request

  Scenario: Send a POST request to a REST API
    Given user sends a request body
    When user hit the url of post api
    Then user should receive a valid status code
    And user should receive a valid responseBody