@Regression
Feature: Create trip with employee and approve with manager

  @Trip @BTC
  Scenario Outline: User  login in web application of three manger
    Given Employee Login with his "<emailID>"
    When  Get employee auth token "<emailID>" "<otp>"
    Then validate Employee HTTP status code for login api <httpStatusCode> "<message>"
    Examples:
      | emailID  | otp    | httpStatusCode | message              |
      | employee | 123456 | 200            | Login OTP validated. |

#  @Trip @BTC
#  Scenario Outline: User  login in web application of one manger
#    Given Employee Login with his "<emailID>"
#    When  Get employee auth token "<emailID>" "<otp>"
#    Then validate Employee HTTP status code for login api <httpStatusCode> "<message>"
#    Examples:
#      | emailID  | otp    | httpStatusCode | message              |
#      | employee | 123456 | 200            | Login OTP validated. |

  @Trip
  Scenario Outline: Search flight and book  flight's details for single user for SBT flow with prepaid
    Given User enter the Employee details and search for the flight "<From>"  "<To>" "<Departure_Date>" <Traveller> "<Travel_Class>" "<arrivalCity>" "<sourceCity>"
    Then Validate search api status code and message and schema
      | field      | value   |
      | statuscode | 200     |
      | message    | Success |
    When User create a trip "<sourceCity>"  "<arrivalCity>" "<Travel_Class>" "<purposeoftravel>" "<type>" "<bookingMode>" "<Departure_Date>" <Traveller>
    When MANAGER one login and approval
      | field | value    |
      | email | manager1 |
      | otp   | 123456   |
    When MANAGER two login and approval
      | field | value    |
      | email | manager2 |
      | otp   | 123456   |
    When MANAGER three login and approval
      | field | value    |
      | email | manager3 |
      | otp   | 123456   |
    Then Validate HTTPS status code and message for trip approval
      | field      | value       |
      | statuscode | 200         |
      | message    | IN_PROGRESS |
    Then Validate pnr status
    Examples:
      | From | To  | arrivalCity | sourceCity | Departure_Date      | Traveller | Travel_Class | purposeoftravel | type   | bookingMode |
      #| BOM  | DEL | Delhi       | Mumbai     | 2023-11-29T00:00:00 | 1         | ECONOMY      | Conference      | ONWARD | SELF_BOOK   |
      | BOM  | DEL | Mumbai      | Delhi      | 2023-12-29T00:00:00 | 1         | ECONOMY      | Conference      | ONWARD | SELF_BOOK   |
     # | DEL  | GOI | Delhi       | Goa        | 2023-11-29T00:00:00 | 1         | ECONOMY      | Conference      | ONWARD | SELF_BOOK   |
     # | DEL  | GOI | Delhi       | Goa        | 2023-11-29T00:00:00 | 1         | ECONOMY      | Conference      | ONWARD | SELF_BOOK   |
     # | DEL  | GOI | Delhi       | Goa        | 2023-11-29T00:00:00 | 1         | ECONOMY      | Conference      | ONWARD | SELF_BOOK   |
     # | DEL  | GOI | Delhi       | Goa        | 2023-11-29T00:00:00 | 1         | ECONOMY      | Conference      | ONWARD | SELF_BOOK   |


  @BTC
  Scenario Outline: Search flight and book  flight's details for single user for SBT flow with BTC
    Given User enter the Employee details and search for the flight "<From>"  "<To>" "<Departure_Date>" <Traveller> "<Travel_Class>" "<arrivalCity>" "<sourceCity>"
    Then Validate search api status code and message and schema
      | field      | value   |
      | statuscode | 200     |
      | message    | Success |
    When User create a trip "<sourceCity>"  "<arrivalCity>" "<Travel_Class>" "<purposeoftravel>" "<type>" "<bookingMode>" "<Departure_Date>" <Traveller>
    When MANAGER three login and approval
      | field | value                          |
      | email | himanshu.shukla1@fabhotels.com |
      | otp   | 123456                         |
    Examples:
      | From | To  | arrivalCity | sourceCity | Departure_Date       | Traveller | Travel_Class | purposeoftravel | type   | bookingMode |
      | BOM  | DEL | Delhi       | Mumbai     | 2023-12-22 T00:00:00 | 1         | ECONOMY      | Conference      | ONWARD | SELF_BOOK   |


