package demoqa.com.tests.steps;

import demoqa.com.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static demoqa.com.utils.TestData.getPassword;
import static demoqa.com.utils.TestData.getUsername;


public class LoginSteps {
    private LoginPage loginPage = new LoginPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        loginPage.navigateTo();
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        loginPage.setUsername(getUsername());
        loginPage.setPassword(getPassword());
        loginPage.clickLogin();
    }

    @When("I enter invalid username and password")
    public void i_enter_invalid_username_and_password() {
        loginPage.setUsername("invalidUsername");
        loginPage.setPassword("invalidPassword");
        loginPage.clickLogin();
    }

    @Then("I should see the user dashboard")
    public void i_should_see_the_user_dashboard() {
        loginPage.verifyUserOnDashboard();
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        loginPage.verifyErrorMessageDisplayed();
    }
}
