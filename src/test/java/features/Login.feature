Feature: Login of registered user
  As registered user I should be able to login successfully
  so that I am able to access my Account and benefit from doing the transactions on Phptravels website.


  Background:
    Given Initialize the browser with Chrome
    And user navigates to "https://www.phptravels.net" website
    And user is not logged in
    And user clicks on Login from MyAccount
    And the user is redirected to Login page

  Scenario Outline: Unsuccessful Login
    Given User enters "<email>" and "<password>"
    When User clicks on login button
    Then User is not logged and the page shows the error message "<Error Message>"

    Examples:
      | email     | password  | Error Message             |
      |           | Abcd1234! | Invalid Email or Password |
      | a.b@s.com |           | Invalid Email or Password |
      | 121234    | ancd      | Invalid Email or Password |


  Scenario Outline: Successful Login
    Given User enters "<email>" and "<password>"
    When User clicks on login button
    Then User is logged in successfully and the Account Page displays the greeting message for "<first_name>" and "<last_name>"

    Examples:
      | email     | password  | first_name | last_name |
      | x.b@c.com | Abcd1234! | fname         | lname        |

