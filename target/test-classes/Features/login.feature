Feature: Login page Automation of saucedemo App
Scenario: check login is successfull with valid creds
Given User is on login page
When User enters valid username and password
And Clicks on Login button 
Then User is navigated to Home page
And Close the browser

Scenario: Login Data Driven
Given User is on login page
When User enters valid "<username>" and "<password>"
And Clicks on Login button 
Then User is navigated to Home page
And Close the browser

Examples:
|username | password |
|standard_user|secret_sauce|
|locked_out_user|secret_sauce|
|problem_user|secret_sauce|
|performance_glitch_user|secret_sauce|