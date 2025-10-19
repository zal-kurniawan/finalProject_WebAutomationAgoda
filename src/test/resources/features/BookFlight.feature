Feature: Book Flight Scenario

Scenario Outline: User books a cheapest flight successfully
    When User select tab "<tab>"
    Then The flight search form should be displayed
    When User searches for a flight from "<flyFrom>" to "<flyTo>"
    And User select Departure date
    And User select flight class "<class>"
    And User click Search Flights button
    Then User is navigate to Flights List page
    When User click Cheapest tab
    And User selects the first flight in the list to see details
    And User click button select
    Then User is navigate to Customer Information page and verify airline and total price
    When User fill Contact details data with "<firstNameContact>", "<lastNameContact>", "<emailContact>", "<countryContact>", "<countryCodeContact>", "<phoneNumberContact>"
    And User fill Passenger data with "<gender>", "<firstNamePassenger>", "<lastNamePassenger>", "<dateOfBirth>", "<nationality>", "<passportNumber>", "<countryPassenger>", "<passportExpiryDate>"
    And User click Continue to Payment button
    And User close pop up 
    Then User can verify price, contact, and passenger detail in Payment Information Page with "<firstNameContact>", "<lastNameContact>", "<emailContact>", "<phoneNumberContact>", "<firstNamePassenger>", "<lastNamePassenger>"

    Examples:
      | tab         | flyFrom    | flyTo        | class              | firstNameContact   | lastNameContact | emailContact    | countryContact  | countryCodeContact  | phoneNumberContact  | gender  | firstNamePassenger |  lastNamePassenger | dateOfBirth     | nationality | passportNumber | countryPassenger | passportExpiryDate    |
      | flights     | Jakarta    | Singapore    | economy            |  Budi              | Sudarsono       | budi@gmail.com  | Singapore       |  Singapore          | 80932049281         | Male    | Budi               |   Sudarsono        | 20 May 1987     | Indonesia   | 4281209        |  Indonesia       |  10 October 2030      |
      | flights     | Singapore  | Jakarta      | economy            |  Susi              | Sulastri        | susi@gmail.com  | Malaysia        |  Malaysia           | 84029328122         | Female  | Susi               |   Sulastri         | 8 August 1995   | Indonesia   | 5481482        |  Indonesia       |  14 June 2035         |


Scenario Outline: User books a fastest flight successfully
    When User select tab "<tab>"
    Then The flight search form should be displayed
    When User searches for a flight from "<flyFrom>" to "<flyTo>"
    And User select Departure date
    And User select flight class "<class>"
    And User click Search Flights button
    Then User is navigate to Flights List page
    When User click Fastest tab
    And User selects the first flight in the list to see details
    And User click button select
    Then User is navigate to Customer Information page and verify airline and total price
    When User fill Contact details data with "<firstNameContact>", "<lastNameContact>", "<emailContact>", "<countryContact>", "<countryCodeContact>", "<phoneNumberContact>"
    And User fill Passenger data with "<gender>", "<firstNamePassenger>", "<lastNamePassenger>", "<dateOfBirth>", "<nationality>", "<passportNumber>", "<countryPassenger>", "<passportExpiryDate>"
    And User click Continue to Payment button
    And User close pop up 
    Then User can verify price, contact, and passenger detail in Payment Information Page with "<firstNameContact>", "<lastNameContact>", "<emailContact>", "<phoneNumberContact>", "<firstNamePassenger>", "<lastNamePassenger>"

    Examples:
      | tab         | flyFrom    | flyTo        | class              | firstNameContact   | lastNameContact | emailContact    | countryContact  | countryCodeContact  | phoneNumberContact  | gender  | firstNamePassenger |  lastNamePassenger | dateOfBirth     | nationality | passportNumber | countryPassenger | passportExpiryDate    |
      | flights     | Jakarta    | Singapore    | economy            |  Budi              | Sudarsono       | budi@gmail.com  | Singapore       |  Singapore          | 80932049281         | Male    | Budi               |   Sudarsono        | 20 May 1987     | Indonesia   | 4281209        |  Indonesia       |  10 October 2030      |
      | flights     | Singapore  | Jakarta      | economy            |  Susi              | Sulastri        | susi@gmail.com  | Malaysia        |  Malaysia           | 84029328122         | Female  | Susi               |   Sulastri         | 8 August 1995   | Indonesia   | 5481482        |  Indonesia       |  14 June 2035         |


Scenario Outline: User can't search a flight without filling Origin and Destination 
    When User select tab "<tab>"
    Then The flight search form should be displayed
    When User click Search Flights button without filling Oirign and Destination
    Then User will see a failed flight search pop-up
    
    Examples:
      | tab         |
      | flights     |