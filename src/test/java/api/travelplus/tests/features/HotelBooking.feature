@Regression
Feature: Hotel booking


  @Flight @Hotel @Login @Search @Agoda @GDS
  Scenario Outline: User  login in web application
    Given Admin Login with his "<emailID>"
    When Get auth token "<emailID>" "<otp>"
    Then validate HTTP status code for login api <httpStatusCode> "<message>"
    Examples:
      | emailID                   | otp    | httpStatusCode | message               |
      | sudhir1.singh@fabhotels.com | 123456 | 200            | Login OTP validated. |
      #| vikas.yadav@fabhotels.com | 123456 | 200            | Login OTP validated. |
     #|sudhir.singh@fabhotels.com | 123456 | 200            | Login OTP validated. |

  @Hotel
  Scenario Outline: Search and book Hotel with minimum and maximum user
    Given User enter the details for search api "<city>" "<locality>" "<latitude>" "<longitude>" "<occupancy>"
    Then Validate Response and status code "<message>" <statuscode>
    When User hit the search get request "<city>" "<locality>" "<latitude>" "<longitude>" "<occupancy>"
    When User create hotels booking "<occupancy>"
    When User enter following booking information with payment option "<paymentoption>" "<guestType>" "<occupancy>" "<currentgststatus>"
      | field                               | value                  |
      | companyGstDetaxil.gSTCompanyAddress | Lok Kalyan Marg, Delhi |
      | companyGstDetail.gSTNumber          | 07AABCV0475C1ZN        |
      | companyGstDetail.gSTCompanyName     | Delhi new              |
      | companyGstDetail.gSTCompanyEmail    | test@test.com          |
      | gstPinCode                          | 110049                 |
      | traveller[0].countryCode            | +91                    |
      | traveller[0].title                  | Mr                     |
      | traveller[0].userId                 | null                   |
      | isSaveDetails                       | true                   |
      | middleName                          |                        |
      | corporateUserType                   | null                   |
      | corporateUserTypeResponse           | null                   |
      | guestTypeResponse                   | null                   |
      | corporateUserType                   | null                   |
      | id                                  | null                   |
    Then Validate HTTP status code and message
      | field      | value                                     |
      | statuscode | 200                                       |
      | message    | Online hotel booking created Successfully |

    Examples:
      | city   | locality | latitude   | longitude  | message                | statuscode | paymentoption | guestType | occupancy | currentgststatus |
      | Mumbai | Mumbai   | 19.0759837 | 72.8776559 | Hotel search initiated | 200        | WALLET        | INTERN    | 1         | false            |
      | Mumbai | Mumbai   | 19.0759837 | 72.8776559 | Hotel search initiated | 200        | BTC           | INTERN    | 2,2,2,2,1 | true             |
      | Mumbai | Mumbai   | 19.0759837 | 72.8776559 | Hotel search initiated | 200        | BTC           | INTERN    | 1         | false            |
      | Mumbai | Mumbai   | 12.9715987 | 77.5945627 | Hotel search initiated | 200        | BTC           | INTERN    | 2,2,2,2,1 | false            |
      | Mumbai | Mumbai   | 12.9715987 | 77.5945627 | Hotel search initiated | 200        | PAY_AT_HOTEL  | INTERN    | 1         | false            |


  @Search
  Scenario Outline: Search and book Hotel with minimum and maximum user
    Given User enter the details for search api "<city>" "<locality>" "<latitude>" "<longitude>" "<occupancy>"
    Then Validate Response and status code "<message>" <statuscode>
    When  Search api validation "<city>" "<locality>" "<latitude>" "<longitude>" "<occupancy>"
    Examples:
      | city            | locality        | latitude   | longitude  | message                | statuscode | paymentoption | guestType | occupancy | currentgststatus |
      #| New Delhi | New Delhi | 19.0759837 | 72.8776559 | Hotel search initiated | 200        | WALLET        | INTERN    | 1         | false            |
#      | Mumbai    | Mumbai    | 19.0759837 | 72.8776559 | Hotel search initiated | 200        | WALLET        | INTERN    | 1         | false            |
#      | Bangalore | Bangalore | 19.0759837 | 72.8776559 | Hotel search initiated | 200        | BTC           | INTERN    | 1         | true             |
#      | Goa       | Goa       | 19.0759837 | 72.8776559 | Hotel search initiated | 200        | BTC           | INTERN    | 1         | true             |
#      | Jaipur    | Jaipur    | 12.9715987 | 77.5945627 | Hotel search initiated | 200        | BTC           | INTERN    | 1         | true             |
#      | Chennai   | Chennai   | 19.0759837 | 72.8776559 | Hotel search initiated | 200        | PAY_AT_HOTEL  | INTERN    | 1         | false            |
#      | Hyderabad | Hyderabad | 19.0759837 | 72.8776559 | Hotel search initiated | 200        | WALLET        | INTERN    | 1         | false            |
#      | Pune      | Pune      | 19.0759837 | 72.8776559 | Hotel search initiated | 200        | BTC           | INTERN    | 1         | true             |
#      | Kolkata   | Kolkata   | 19.0759837 | 72.8776559 | Hotel search initiated | 200        | BTC           | INTERN    | 1         | true             |
#      | Gurgaon   | Gurgaon   | 12.9715987 | 77.5945627 | Hotel search initiated | 200        | BTC           | INTERN    | 1         | true             |
#      | Ahmedabad | Ahmedabad | 19.0759837 | 72.8776559 | Hotel search initiated | 200        | PAY_AT_HOTEL  | INTERN    | 1         | false            |
#      | Udaipur   | Udaipur   | 19.0759837 | 72.8776559 | Hotel search initiated | 200        | WALLET        | INTERN    | 1         | false            |
#      | Kochi     | Kochi     | 19.0759837 | 72.8776559 | Hotel search initiated | 200        | BTC           | INTERN    | 1         | true             |
#      | Manali    | Manali    | 19.0759837 | 72.8776559 | Hotel search initiated | 200        | BTC           | INTERN    | 1         | true             |
#      | Lucknow   | Lucknow   | 12.9715987 | 77.5945627 | Hotel search initiated | 200        | BTC           | INTERN    | 1         | true             |
#      | Varanasi  | Varanasi  | 19.0759837 | 72.8776559 | Hotel search initiated | 200        | PAY_AT_HOTEL  | INTERN    | 1         | false            |
#      | Amritsar  | Amritsar  | 19.0759837 | 72.8776559 | Hotel search initiated | 200        | WALLET        | INTERN    | 1         | false            |
#      | Bhopal    | Bhopal    | 19.0759837 | 72.8776559 | Hotel search initiated | 200        | BTC           | INTERN    | 1         | true             |
#      | Indore    | Indore    | 19.0759837 | 72.8776559 | Hotel search initiated | 200        | BTC           | INTERN    | 1         | true             |
#      | Dehradun  | Dehradun  | 12.9715987 | 77.5945627 | Hotel search initiated | 200        | BTC           | INTERN    | 1         | true             |
      | Maldive Islands | Maldive Islands | 12.9715987 | 77.5945627 | Hotel search initiated | 200        | BTC           | INTERN    | 1         | true             |

  @Agoda
  Scenario Outline: Search and book Hotel with minimum and maximum user for internation search
    When  User enter details for internation search "<city>" "<locality>" "<latitude>" "<longitude>" "<occupancy>" "<checkindate>" "<checkoutdate>"
    Then Validate Response and status code "<message>" <statuscode>
    When User hit the search get request "<city>" "<locality>" "<latitude>" "<longitude>" "<occupancy>"
    When User create hotels booking "<occupancy>"
    When User enter following booking information with payment option "<paymentoption>" "<guestType>" "<occupancy>" "<currentgststatus>"
      | field                               | value                  |
      | companyGstDetaxil.gSTCompanyAddress | Lok Kalyan Marg, Delhi |
      | companyGstDetail.gSTNumber          | 07AABCV0475C1ZN        |
      | companyGstDetail.gSTCompanyName     | Delhi new              |
      | companyGstDetail.gSTCompanyEmail    | test@test.com          |
      | gstPinCode                          | 110049                 |
      | traveller[0].countryCode            | +91                    |
      | traveller[0].title                  | Mr                     |
      | traveller[0].userId                 | null                   |
      | isSaveDetails                       | true                   |
      | middleName                          |                        |
      | corporateUserType                   | null                   |
      | corporateUserTypeResponse           | null                   |
      | guestTypeResponse                   | null                   |
      | corporateUserType                   | null                   |
      | id                                  | null                   |
    Then Validate HTTP status code and message
      | field      | value                                     |
      | statuscode | 200                                       |
      | message    | Online hotel booking created Successfully |
    Examples:
      | city             | locality         | latitude   | longitude  | message                | statuscode | paymentoption | guestType | occupancy | currentgststatus | checkindate | checkoutdate |
      | Maldives Islands | Maldives Islands | 12.9715987 | 77.5945627 | Hotel search initiated | 200        | BTC           | INTERN    | 1         | true             | 2024-01-15  | 2024-01-16   |
      | Maldives Islands | Maldives Islands | 12.9715987 | 77.5945627 | Hotel search initiated | 200        | WALLET        | INTERN    | 1         | true             | 2024-01-15  | 2024-01-16   |



