package stepdefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pages.FlipkartPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlipkartSteps {
	
	private WebDriver driver;
    private FlipkartPage flipkartPage;
	
	
	
    @Given("I navigate to Flipkart")
    public void navigateToFlipkart() {
    	System.setProperty("webdriver.chrome.driver","G:\\Testing\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        flipkartPage = new FlipkartPage(driver);
        flipkartPage.navigateToFlipkart();
    }

    @When("I fetch all categories visible below the search bar")
    public void fetchCategories() {
        List<String> categories = flipkartPage.fetchVisibleCategories();
        // Assert or log categories
        for (String category : categories) {
            System.out.println("Category: " + category);
        }
    }

    @When("I select any product and search for it")
    public void searchProduct() {
        flipkartPage.selectProduct("Laptop"); // Replace with your product name
    }

    @When("I open the details page of the product")
    public void openProductDetails() {
        // Already implemented in FlipkartPage.java
    }

    @When("I check the compare checkbox")
    public void checkCompareCheckbox() {
        flipkartPage.checkCompareCheckbox();
    }

    @Then("I validate if the compare modal opens")
    public void validateCompareModal() {
        Assert.assertTrue(flipkartPage.isCompareModalOpened());
    }

    @When("I click on the compare modal")
    public void clickCompareModal() {
        flipkartPage.clickCompareModal();
    }

    @Then("I validate that I am redirected to the compare page")
    public void validateRedirectToComparePage() {
        flipkartPage.navigateToComparePage();
        // Validate if redirected to compare page
        Assert.assertEquals("Compare", driver.getTitle());
    }

    @Then("I validate that the selected device is visible")
    public void validateSelectedDevice() {
        // Implement as per requirement
    }

    @Then("I add products on the compare page")
    public void addProductsToCompare() {
        flipkartPage.addProductsToCompare();
    }

    @Given("I am on the compare page on Flipkart")
    public void navigateToComparePage() {
        flipkartPage.navigateToComparePage();
    }

    @When("I fetch ratings and reviews for all 4 products")
    public void fetchRatingsAndReviews() {
        flipkartPage.fetchRatingsAndReviews();
        // Implement as per requirement
    }

    @Then("I verify that ratings and reviews are fetched successfully")
    public void verifyRatingsAndReviews() {
        // Implement verification of ratings and reviews
    }

    // After scenario cleanup
    //@After
    public void tearDown() {
        driver.quit();
    }

}
