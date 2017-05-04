Feature: The user can login in the application

Scenario: Login
	
	Given the list of users:
	|	name	|	password	|
	|	maria@gmail.com	|		xxx	|
	|	pablo@gmail.com	|	xxx	|
	
	When inserting pablo@gmail.com and the password xxx
	Then i receive a welcome message