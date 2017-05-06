Feature: Comment a proposal
		 As registered user I want to comment a proposal

Scenario: Comment a proposal
	Given a logged user
	When I select a proposal
	And I write a comment
	Then the comment must be published