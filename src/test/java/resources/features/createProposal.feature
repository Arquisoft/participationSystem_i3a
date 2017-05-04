Feature: Be able to create a proposal
		 As registered user I want to create a proposal
	
Scenario: Create a proposal
	Given a login user
	When i write the proposal's content
	And i write the proposal's title
	And i select the proposal's category
	Then my proposal must be published