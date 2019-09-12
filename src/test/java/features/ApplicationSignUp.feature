Feature: Registration of new User
  As a new user I want to be able to register successfully
  so that I am able to access my Account and benefit from doing the transactions on Phptravels website.


  Background:
    Given Initialize the browser with Chrome
    And user navigates to "https://www.phptravels.net" website
    And user clicks on Signup from MyAccount
    And the user is redirected to "Registration" page

  Scenario Outline: UnSuccessful Registration
    Given User enters his firstname "<firstname>", lastname "<lastname>", mobile number "<mobile_number>", email "<email>", password "<password>", confirm password "<confirm_password>"
    When User clicks on Sign up button
    Then User is not registered successfully and the error message "<error_message>" is shown on the page

    Examples:
      | firstname | lastname | mobile_number | email     | password | confirm_password | error_message                                              |
      | f1        | l1       | 121212        | a.b@c.com | abc      | abc              | The Password field must be at least 6 characters in length |
      | f1        | l1       | 121212        | a.b@c.com | abc      | abcdef           | Password not matching with confirm password.               |
      | f1        | l1       | 121212        | a.b@com   | abc      | abcdef           | The Email field must contain a valid email address.        |
      |           | l1       | 1234          | a.b@c.com | abc123   | abc123           | The First name field is required.                          |
      | f1        |          | 1234          | a.b@c.com | abc123   | abc123           | The Last name field is required.                           |

@successfulRegistration
  Scenario Outline: Successful Registration
    Given User enters his firstname "<firstname>", lastname "<lastname>", mobile number "<mobile_number>", email "<email>", password "<password>", confirm password "<confirm_password>"
    When User clicks on Sign up button
    Then User is registered successfully


  Examples:
    | firstname | lastname | mobile_number | email     | password  | confirm_password |
    | f1        | l1       | 121212        | x.b@c.com | Abcd1234! | Abcd1234!        |

