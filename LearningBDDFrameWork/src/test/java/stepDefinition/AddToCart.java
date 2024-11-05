package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilPackage.DriverFactory;
import utilityClasses.FileUtility;

public class AddToCart {
	WebDriver driver=DriverFactory.getDriver();
	LoginPage loginPage=new LoginPage(driver);
	HomePage homePage=new HomePage(driver);
	
	@Given("Browser should be launched and url should be navigated")
	public void browser_should_be_launched_and_url_should_be_navigated() throws Exception {
	    String actualURL=driver.getCurrentUrl();
	    FileUtility fileUtility=new FileUtility();
	    String expectedURL=fileUtility.getDataFromPropertiesFiles("url");
	    Assert.assertEquals(actualURL, expectedURL,"URL is not navigated");
	    //log
	}

	@Given("user should be logged in with {string} and {string}")
	public void user_should_be_logged_in_with_and(String username, String password) {
	   loginPage.login(username, password);
	   //add assertion
	}


	@When("user clicks on add to cart button")
	public void user_clicks_on_add_to_cart_button() {
	   homePage.getBackupAddToCartButton().click();
	}

	@Then("Product should be added to cart")
	public void product_should_be_added_to_cart() {
	    homePage.getCartIcon().click();
	    WebElement productName = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
	    Assert.assertTrue(productName.isDisplayed(),"Item is not added to cart");
	    //log message
	}
	
	@Then("user should be logged out")
	public void user_should_be_logged_out() {
	   homePage.logout();
	}
}
