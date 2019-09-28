Feature: Search For Hotels As Guest
  As a guest I should be able to search for hotels
  so that I can choose one suitable for my convenience


  Background:
    Given Given User enters the application url

  Scenario Outline: Hotel Search
    Given user clicks on the hotel Search tab
    And The user enters the destination "<destination>", "<check-in>" date, "<check-out>" date, "<adult>" adult, "<child>" child
    When the user clicks in the search button
    Then The user is redirected to hotel search results

    Examples:

      | destination | check-in   | check-out  | adult | child |
      | london      | 13/09/2019 | 18/09/2019 | 4          |2 |

