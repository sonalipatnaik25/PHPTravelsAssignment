Feature: Login of registered user
  As registered user I should be able to login successfully
  so that I am able to access my Account and benefit from doing the transactions on Phptravels website.

  Background:
    Given User is on the "https://www.phptravels.net" website
    And User navigates to "LoginPage" Page

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
    Then The user is redirected to "Accounts" page
    Then Greeting message shown for "<first_name>", "<last_name>"

    Examples:
      | email     | password  | first_name | last_name |
      | xy.b@c.com | Abcd1234! | fname         | lname        |

