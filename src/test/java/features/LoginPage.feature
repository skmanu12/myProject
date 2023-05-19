Feature: Application Login

Scenario: Home page login
Given Landed on netbanking page
When user login application with username and password
Then Home page is populated
And Cards are displayed