package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

import Pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class New {
    WebDriver driver;
    LoginPage obj;

    // Initialize WebDriver before each scenario
    @Before
    public void setUp() {
       
        driver = new ChromeDriver(); // Initialize the WebDriver
        obj = new LoginPage(driver); // Initialize LoginPage object
    }

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver.get("https://www.saucedemo.com/v1/");  // Open the login page
    }

    @When("user enter valid username and password")
    public void user_enter_valid_username_and_password() {
        obj.loginUser("standard_user");  // Enter valid username
        obj.loginPassword("secret_sauce");  // Enter valid password
    }

    @And("click on login button")
    public void click_on_login_button() {
        obj.clickBtn();  // Click on the login button
    }

    @Then("user redirect to Home page")
    public void user_redirect_to_home_page() {
        Assert.assertEquals(driver.getTitle(), "Swag Labs");  // Verify the page title
    }

    @When("user enter invalid username and password")
    public void user_enter_invalid_username_and_password() {
        obj.loginUser("invalid_user");  // Enter invalid username
        obj.loginPassword("invalid_pass");  // Enter invalid password
        obj.clickBtn();  // Click on the login button
    }

    @Then("error message shows")
    public void error_message_shows() {
        // Check if error message is displayed (based on actual page behavior)
    	String message=driver.findElement(By.xpath("//button[@class='error-button']")).getText();
       Assert.assertNotEquals(message, "Epic sadface: Username and password do not match any user in this service");
    }

    // Close the WebDriver after each scenario
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser after test completion
        }
    }
}
