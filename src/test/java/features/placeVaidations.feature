Feature: Validating Place API's

  Scenario Outline: Verify if Place is being successfully added using AddPlaceAPI
    Given Add Place Payload with "<Name>" "<Language>" "<Phone_number>" "<Website>"
    When user calls "AddPlaceAPI" with "POST" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"

    Examples:
      | Name   | Language | Phone_number | Website        |  |
      | Samir  | Marathi  | 9370088496   | www.samir.com  |  |
      | Sayali | English  | 8356020253   | www.sayali.com |  |