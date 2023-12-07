@Regression
Feature:-Verify One way Flight Booking

  @Smoke @Test @Flight
  Scenario Outline: Search flight and book  flight's details for single user
    Given User enter the details and search for the flight "<From>"  "<To>" "<Departure_Date>" "<Traveller>"  "<Travel_Class>"
    Then Validate HTTP status code and response for search Api <httpstatuscode> "<message>"
    When User is able to book the flight "<From>"  "<To>" "<Departure_Date>" "<Traveller>"  "<Travel_Class>"
    Then Validate HTTP status code and response for book flights  Api <httpstatuscode> "<message>"
    When the following booking information with "<PaymentOption>"
      | field                                    | value           |
      | companyGstDetail.gSTCompanyAddress       | UP, Meerut      |
      | companyGstDetail.gSTNumber               | 09AACCM2555K1Z9 |
      | companyGstDetail.gSTCompanyContactNumber | 7042424242      |
      | companyGstDetail.gSTCompanyName          | Testing         |
      | companyGstDetail.gSTCompanyEmail         | test@test.com   |
      | passengers[0].isLeadPax                  | true            |
      | passengers[0].isdCode                    | +91             |
      | passengers[0].countryName                | India           |
      | passengers[0].address                    | n/a             |
      | passengers[0].city                       | n/a             |
      | passengers[0].mealDetails                | null            |
      | passengers[0].seatDetails                | null            |
      | passengers[0].baggageDetails             | null            |
      | passengers[0].key                        | 0               |
      | passengers[0].gender                     | 1               |
      | passengers[0].title                      | Mr              |
      | passengers[0].nationality                | India           |
      | passengers[0].dateOfBirth                | null            |
      | passengers[0].userId                     | null            |
      | pasengers[0].selectedGender.text         | Male            |
      | pasengers[0].selectedGender.value        | 1               |
      | pasengers[0].selectedTitle.text          | Mr              |
      | pasengers[0].selectedTitle.value         | Mr              |
    Then validate HTTP status code and payment response <httpstatuscode> "<message>"
    When User hit the confirm post request
    Then Validate HTTP status code and conform response <httpstatuscode> "<message>"
    Then Validate flight booking details
   # Then validate HTTP status code and response message <httpstatuscode> "<message>"
    Then Validate flight booking HTTP status code and message
      | field      | value   |
      | statuscode | 200     |
      | message    | Success |
    Examples:
      | From | To  | Departure_Date      | Traveller | Travel_Class | PaymentOption | httpstatuscode | message |
      | BOM  | DEL | 2023-12-22T00:00:00 | 1         | ECONOMY      | WALLET        | 200            | Success |
     # | BOM  | BLR | 2023-12-24T00:00:00 | 1         | ECONOMY      | BTC           | 200            | Success |
     # | BOM  | BLR | 2023-12-25T00:00:00 | 1         | ECONOMY      | WALLET        | 200            | Success |
     # | PNQ  | GOI | 2023-11-29T00:00:00 | 3         | ECONOMY      | BTC           | 200            | Success |
    #  | LKO  | CCU | 2023-11-30T00:00:00 | 4         | ECONOMY      | WALLET        | 200            | Success |
     # | MAA  | HYD | 2023-12-01T00:00:00 | 5         | ECONOMY      | BTC           | 200            | Success |

  #@Flight
  Scenario Outline: Search flight and book  flight's details for single user with Paynow payment option
    Given User enter the details and search for the flight "<From>"  "<To>" "<Departure_Date>" "<Traveller>"  "<Travel_Class>"
    When User is able to book the flight "<From>"  "<To>" "<Departure_Date>" "<Traveller>"  "<Travel_Class>"
    When the following booking information with "<PaymentOption>"
      | field                                    | value           |
      | companyGstDetail.gSTCompanyAddress       | UP, Meerut      |
      | companyGstDetail.gSTNumber               | 09AACCM2555K1Z9 |
      | companyGstDetail.gSTCompanyContactNumber | 7042424242      |
      | companyGstDetail.gSTCompanyName          | Testing         |
      | companyGstDetail.gSTCompanyEmail         | test@test.com   |
      | passengers[0].isLeadPax                  | true            |
      | passengers[0].isdCode                    | +91             |
      | passengers[0].countryName                | India           |
      | passengers[0].address                    | n/a             |
      | passengers[0].city                       | n/a             |
      | passengers[0].mealDetails                | null            |
      | passengers[0].seatDetails                | null            |
      | passengers[0].baggageDetails             | null            |
      | passengers[0].key                        | 0               |
      | passengers[0].gender                     | 1               |
      | passengers[0].title                      | Mr              |
      | passengers[0].nationality                | India           |
      | passengers[0].dateOfBirth                | null            |
      | passengers[0].userId                     | null            |
      | pasengers[0].selectedGender.text         | Male            |
      | pasengers[0].selectedGender.value        | 1               |
      | pasengers[0].selectedTitle.text          | Mr              |
      | pasengers[0].selectedTitle.value         | Mr              |
    When Hit confirm payment request "<PaymentOption>"
    Examples:
      | From | To  | Departure_Date      | Traveller | Travel_Class | PaymentOption |
      | BOM  | DEL | 2023-10-22T00:00:00 | 1         | ECONOMY      | PAY_NOW       |
      | BOM  | BLR | 2023-10-24T00:00:00 | 1         | ECONOMY      | PAY_NOW       |


  @GDS
  Scenario Outline:  Search flight and book  flight's details for single user with specific provider
    Given User enter the details and search for the flight "<From>"  "<To>" "<Departure_Date>" "<Traveller>"  "<Travel_Class>"
    Then Validate HTTP status code and response for search Api <httpstatuscode> "<message>"
    When User is able to book the flight for source "<From>"  "<To>" "<Departure_Date>" "<Traveller>"  "<Travel_Class>" "<provider>" "<airlinecode>" "<pricetype>"
    Then Validate HTTP status code and response for book flights  Api <httpstatuscode> "<message>"
    When the following booking information with "<PaymentOption>"
  #  When the follow booking information with add-ons "<PaymentOption>" "<addons>"
      | field                                    | value           |
      | companyGstDetail.gSTCompanyAddress       | UP, Meerut      |
      | companyGstDetail.gSTNumber               | 09AACCM2555K1Z9 |
      | companyGstDetail.gSTCompanyContactNumber | 7042424242      |
      | companyGstDetail.gSTCompanyName          | Testing         |
      | companyGstDetail.gSTCompanyEmail         | test@test.com   |
      | passengers[0].isLeadPax                  | true            |
      | passengers[0].isdCode                    | +91             |
      | passengers[0].countryName                | India           |
      | passengers[0].address                    | n/a             |
      | passengers[0].city                       | n/a             |
      | passengers[0].mealDetails                | null            |
      | passengers[0].seatDetails                | null            |
      | passengers[0].baggageDetails             | null            |
      | passengers[0].key                        | 0               |
      | passengers[0].gender                     | 1               |
      | passengers[0].title                      | Mr              |
      | passengers[0].nationality                | India           |
      | passengers[0].dateOfBirth                | null            |
      | passengers[0].userId                     | null            |
      | pasengers[0].selectedGender.text         | Male            |
      | pasengers[0].selectedGender.value        | 1               |
      | pasengers[0].selectedTitle.text          | Mr              |
      | pasengers[0].selectedTitle.value         | Mr              |
    Then validate HTTP status code and payment response <httpstatuscode> "<message>"
    When User hit the confirm post request
    Then Validate HTTP status code and conform response <httpstatuscode> "<message>"
    Then Validate flight booking details
    Then validate HTTP status code and response message <httpstatuscode> "<message>"
    Then Validate flight booking HTTP status code and message
      | field      | value   |
      | statuscode | 200     |
      | message    | Success |
    Examples:
      | From | To  | Departure_Date      | Traveller | Travel_Class | PaymentOption | httpstatuscode | message | provider | airlinecode | pricetype |
      | DEL  | BOM | 2023-12-22T00:00:00 | 1         | ECONOMY      | WALLET        | 200            | Success | 9        | UK          | Regular   |
      | BOM  | DEL | 2023-12-22T00:00:00 | 1         | ECONOMY      | WALLET        | 200            | Success | 9        | UK          | Corporate Plus |
      | BOM  | DEL | 2023-12-22T00:00:00 | 1         | ECONOMY      | WALLET        | 200            | Success | 9        | AI          | Regular        |
      | BOM  | DEL | 2023-12-22T00:00:00 | 1         | ECONOMY      | WALLET        | 200            | Success | 9        | AI          | Corporate Plus |
      | BOM  | DEL | 2023-12-22T00:00:00 | 1         | ECONOMY      | BTC           | 200            | Success | 9        | UK          | Regular        |
      | BOM  | DEL | 2023-12-22T00:00:00 | 1         | ECONOMY      | BTC           | 200            | Success | 9        | UK          | Corporate Plus |
      | BOM  | DEL | 2023-12-22T00:00:00 | 1         | ECONOMY      | BTC           | 200            | Success | 9        | AI          | Regular        |
      | BOM  | DEL | 2023-12-22T00:00:00 | 1         | ECONOMY      | BTC           | 200            | Success | 9        | AI          | Corporate Plus |

