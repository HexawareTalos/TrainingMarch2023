@leave
Feature: Apply Leave in OHRM
  This feature file contains the functionality of Apply Leave in Orange HRM application.

  Background: login OHRM
    Given user navigate to OHRM application
    When user login to application
    Then user lands on "Dashboard" Page

  @Regression
  Scenario Outline: Search Leave with status "<Status>"
    When user click "Leave" in menu list
    Then user lands on "Leave" Page
    When User Enter FromDate as "<FromDate>" and ToDate as "<ToDate>"
    And  select show leave status as "<Status>"
    And user click Search
    Examples:
      | FromDate   | ToDate     | Status    |
      | 2023-03-20 | 2023-03-21 | Rejected  |
      | 2023-03-18 | 2023-03-21 | Cancelled |
      #| 2023-03-23 | 2023-03-24 | Rejection |

#
#    Scenario: search EMployee Record
#      When user click "PIM" in menu list
#      Then user lands on "PIM" Page
#      When user search with Employee ID "0038"
#      Then Employee record should display in below datatable
#
#
#
#
#
#
#
#
#
#
#
#
#
#  Scenario Outline: LOgin Validation
#    Given user navigate to OHRM application
#    When user enter username as "<Username>"
#    And user enter password as "<Password>"
#    And user click login button
#    Then verify Successful login screen "<validation>"
#    Examples:
#      | Username | Password | validation          |
#      | Admin    | admin123 | No Error            |
#      | john     | demo     | Invalid credentials |
#
#
#  Scenario: Search Leave with Rejected Status
#    Given user navigate to OHRM application
#    When user login to application
#    Then user lands on "Dashboard" Page
#    When user click "Leave" in menu list
#    Then user lands on "Leave" Page
#    When User Enter FromDate as "2023-03-20" and ToDate as "2023-03-21"
#    And  select show leave status as "Rejected"
#    And user click Search
#
#  Scenario: Search Leave with Pending Status
#    Given user navigate to OHRM application
#    When user login to application
#    Then user lands on "Dashboard" Page
#    When user click "Leave" in menu list
#    Then user lands on "Leave" Page
#    When User Enter FromDate as "2023-03-20" and ToDate as "2023-03-21"
#    And  select show leave status as "Pending"
#    And user click Search
#
#  Scenario: Search Leave with Approved Status
#    Given user navigate to OHRM application
#    When user login to application
#    Then user lands on "Dashboard" Page
#    When user click "Leave" in menu list
#    Then user lands on "Leave" Page
#    When User Enter FromDate as "2023-03-20" and ToDate as "2023-03-21"
#    And  select show leave status as "Approved"
#    And user click Search
#
#
#
#






