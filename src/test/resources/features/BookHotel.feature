Feature: Book Hotel Scenario

Scenario Outline: User successfully books a hotel after sorting by 'Top reviewed by all guests'
    When User select tab "<tab>"
    Then The hotel search form should be displayed
    When User search destination "<destination>"
    And User selects the check in and check out date
    And User set rooms "<rooms>" and guests "<guests>"
    And User click Search button
    Then User is navigate to Hotel List page
    When User sorting by 'Top reviewed by all guests' on Hotel List page
    And User click the first hotel in the list
    Then User is navigate to Hotel Detail page
    When User click View This Deal button
    And User click Book Now button on the first room in the list
    Then User is navigate to Customer Information 
    When User fill guest detail with "<firstName>", "<lastName>", "<email>", "<country>", "<phoneNumber>", "<specialRequest>"
    And User click button Next Final Step
    Then User is navigate to Payment Information page

     Examples:
      | tab     |   destination     |   rooms   |   guests  |   firstName   |   lastName    |   email           |   country     |   phoneNumber     |   specialRequest          |
      | hotels  |   Bandung         |   2       |      4    |   Budi        |    Sudarsono  |   budi@gmail.com  |   Indonesia   |   08429384212     |   Smoking - TwinBed       |
      | hotels  |   Malang          |   3       |      5    |   Susi        |    Sulastri   |   susi@gmail.com  |   Japan       |   08342194729     |   NonSmoking - LargeBed   |


Scenario Outline: User successfully books a hotel after sorting by 'Lowest Price First'
    When User select tab "<tab>"
    Then The hotel search form should be displayed
    When User search destination "<destination>"
    And User selects the check in and check out date
    And User set rooms "<rooms>" and guests "<guests>"
    And User click Search button
    Then User is navigate to Hotel List page
    When User sorting by 'Lowest Price First' on Hotel List page
    And User click the first hotel in the list
    Then User is navigate to Hotel Detail page
    When User click View This Deal button
    And User click Book Now button on the first room in the list
    Then User is navigate to Customer Information 
    When User fill guest detail with "<firstName>", "<lastName>", "<email>", "<country>", "<phoneNumber>", "<specialRequest>"
    And User click button Next Final Step
    Then User is navigate to Payment Information page

     Examples:
      | tab     |   destination     |   rooms   |   guests  |   firstName   |   lastName    |   email           |   country     |   phoneNumber     |   specialRequest          |
      | hotels  |   Bandung         |   2       |      4    |   Budi        |    Sudarsono  |   budi@gmail.com  |   Indonesia   |   08429384212     |   Smoking - TwinBed       |
      | hotels  |   Malang          |   3       |      5    |   Susi        |    Sulastri   |   susi@gmail.com  |   Japan       |   08342194729     |   NonSmoking - LargeBed   |


Scenario Outline: User can't search a Hotel without filling Destination 
    When User select tab "<tab>"
    Then The hotel search form should be displayed
    When User click Search button without filling Destination
    Then User will see a failed hotel search pop-up

    Examples:
      | tab         |
      | hotels      |
      | hotels      |