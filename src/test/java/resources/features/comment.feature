Feature: Comment a proposal
		 As registered user I want to comment a proposal

Scenario: Comment a proposal
	Given an existing proposal
	And a login user
	When creating a comment
	Then the proposal must have my comment