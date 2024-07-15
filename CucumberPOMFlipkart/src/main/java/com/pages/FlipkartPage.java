package com.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartPage {
	
	private WebDriver driver;
	private WebDriverWait wait;


	// 2. Constructor of the page class:
	public FlipkartPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

	/// Navigate to Flipkart
    public void navigateToFlipkart() {
        driver.get("https://www.flipkart.com/");
    }

    // Fetch all categories visible below the search bar
    public List<String> fetchVisibleCategories() {
        WebElement searchBar = driver.findElement(By.cssSelector("input[type='text']"));
        WebElement categoryContainer = searchBar.findElement(By.xpath("./ancestor::div[@class='_1qJTnd']//div[@class='_1kidPb']"));
        List<WebElement> categoryElements = categoryContainer.findElements(By.xpath(".//a[contains(@href, '/search?')]"));
        return categoryElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    // Click on a product and open its details page
    public void selectProduct(String productName) {
        WebElement searchBar = driver.findElement(By.cssSelector("input[type='text']"));
        searchBar.sendKeys(productName);
        searchBar.submit();
        // For simplicity, assuming the first product in search results
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_1AtVbE']//a")));
        firstProduct.click();
    }

    // Check the compare checkbox on the product details page
    public void checkCompareCheckbox() {
        WebElement compareCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'BjJfJf')]//label")));
        compareCheckbox.click();
    }

    // Click on compare modal
    public void clickCompareModal() {
        WebElement compareButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='COMPARE']")));
        compareButton.click();
    }

    // Validate if the compare modal opens
    public boolean isCompareModalOpened() {
        WebElement compareModal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, '_3e7xtJ')]")));
        return compareModal.isDisplayed();
    }

    // Navigate to compare page
    public void navigateToComparePage() {
        WebElement compareLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Compare']")));
        compareLink.click();
    }

    // Add products on the compare page
    public void addProductsToCompare() {
        // For simplicity, adding first 4 products
        List<WebElement> checkboxes = driver.findElements(By.xpath("//div[@class='_1AtVbE']//label"));
        for (int i = 0; i < 4 && i < checkboxes.size(); i++) {
            checkboxes.get(i).click();
        }
        WebElement compareButton = driver.findElement(By.xpath("//button[text()='COMPARE']"));
        compareButton.click();
    }

    // Fetch ratings and reviews for all products on compare page
    public void fetchRatingsAndReviews() {
        // Implement as per your requirement to fetch ratings and reviews
    }
}
