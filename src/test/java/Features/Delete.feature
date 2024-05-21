Feature: Testing HTTP DELETE request
  Scenario:Send a Delete request to a REST API
    When user hit the url of delete api "users/2"
    Then user should receive a valid status code 204
