Feature: Perform operations on Flipkart website



Scenario: Verify categories and carousel on Flipkart homepage
Given I navigate to Flipkart
When I fetch all categories visible below the search bar
Then I verify the text of each category

Scenario: Compare products on Flipkart
Given I am on the Flipkart homepage
When I select any product and search for it
And I open the details page of the product
And I check the compare checkbox
Then I validate if the compare modal opens
And I click on the compare modal
And I validate that I am redirected to the compare page
And I validate that the selected device is visible
And I add products on the compare page

Scenario: Fetch ratings and reviews for 4 products on Flipkart
Given I am on the compare page on Flipkart
When I fetch ratings and reviews for all 4 products
Then I verify that ratings and reviews are fetched successfully