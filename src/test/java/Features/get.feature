Feature: Testing HTTP GET request

  Scenario: Send a GET request to a REST API
    Given user send a GET request to "https://reqres.in/api/users?page=2"
    Then user should receive a valid response 200