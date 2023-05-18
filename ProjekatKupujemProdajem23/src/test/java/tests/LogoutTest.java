package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Strings;

/**
 * Open Chrome browser
 * Creates a new instance of the LoginPage class.
 * Clicks on the "Uloguj se" button on the login page.
 * Enter the valid email address (presumably stored in Strings.VALID_EMAIL) in the email field.
 * Enters the valid password (presumably stored in Strings.VALID_PASS) in the password field.
 * Clicks the "Uloguj se" button to submit the login form.
 * Clicks the "Izloguj se" button to log out.
 * Retrieves the current URL.
 * Asserts that the login button is displayed on the page.
 * Asserts that the current URL is equal to Strings.LOGIN_PAGE. If not, displays an error message indicating the wrong URL.
 * Close the browser.
 */

public class LogoutTest extends BaseTest{

    @Test
    public void successfulLogin(){
        ChromeDriver driver = openChromeDriver();
        try {
            LoginPage loginPage = new LoginPage(driver);
            sleep(5);
            print("1. Click on 'Uloguj se' button");
            loginPage.clickLoginButton();
            sleep(5);
            print("2. Enter valid email");
            loginPage.enterTextInEmailField(Strings.VALID_EMAIL);

            print("3. Enter valid password");
            loginPage.enterTextInPasswordField(Strings.VALID_PASS);

            print("4. Click 'Uloguj se' button");
            loginPage.clickSubmitLoginButton();
            sleep(5);
            print("5. Verify that user is on Moji oglasi page");
            print("6. Click on 'Izloguj se' button");
            loginPage.clickLogOutButton();
            sleep(5);
            String currentUrl = driver.getCurrentUrl();
            assert loginPage.isLogInButtonDisplayed();
            assert currentUrl.equals(Strings.LOGIN_PAGE) : "Wrong url. Actual " + currentUrl;
//            print("7. Verify that user is on the login page");
//
//            String expectedUrl = "https://novi.kupujemprodajem.com/login";
//            //String currentUrl = driver.getCurrentUrl();
//            assert currentUrl.matches(expectedUrl) : "Current URL does not match expected url.";

        } finally {
            driver.quit();
        }
    }
}
