Feature: Add to cart

Scenario: Verify user is able to add a product to cart

Given Browser should be launched and url should be navigated
And user should be logged in with "standard_user" and "secret_sauce"
When user clicks on add to cart button
Then Product should be added to cart
And user should be logged out