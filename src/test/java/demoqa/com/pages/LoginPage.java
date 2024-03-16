package demoqa.com.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import demoqa.com.setup.BrowserSetup;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static demoqa.com.utils.TestData.*;

public class LoginPage {
    private Page page;

    public LoginPage() {
        this.page = BrowserSetup.getBrowser().newPage();
    }

    public void navigateTo() {
        this.page.navigate(getLoginUrl());
    }

    public void setUsername(String username) {
        this.page.fill("input#userName", username);
    }

    public void setPassword(String password) {
        this.page.fill("input#password", password);
    }

    public void clickLogin() {
        this.page.click("button#login");
    }

    public void verifyUserOnDashboard() {
        assertThat(page).hasURL(getProfileUrl());
    }

    public void verifyErrorMessageDisplayed() {
        Locator invalidText = this.page.locator("p#name");
        assertThat(invalidText).containsText(getErrorMessage());
    }
}
