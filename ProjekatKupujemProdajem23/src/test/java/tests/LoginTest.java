//package tests;
//
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//import pages.LoginPage;
//import pages.Strings;
//
//
//public class LoginTest extends BaseTest {
//
//    @Test
//    public void successfulLogin() {
//        ChromeDriver driver = openChromeDriver();
//
//        try {
//            LoginPage loginPage = new LoginPage(driver);
//
//            print("0. Click on button Uloguj se");
//            loginPage.clickLoginButton();
//
//            print("1. Enter valid email");
//            loginPage.enterTextInEmailField(Strings.VALID_EMAIL);
//
//            print("2. Enter valid password");
//            loginPage.enterTextInPasswordField(Strings.VALID_PASS);
//
//            print("3. Click Login button");
//            loginPage.clickSubmitLoginButton();
//
//            print("4.Verify that user is on Moji oglasi");
//            String actualUrl = driver.getCurrentUrl();
//            assert actualUrl.equals(Strings.LOGGEDIN_PAGE_URL) : "User is on a wrong page. Expected: " +
//                    "" + Strings.LOGGEDIN_PAGE_URL + " Actual " + actualUrl;
//        } finally {
//            driver.quit();
//        }
//    }
//}



package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Strings;
/**
 * Open Chrome browser.
 * Navigate to the login page.
 * Click on the "Uloguj se" button.
 * Enter a valid email address.
 * Enter a valid password.
 * Click on the login button.
 * Verify that the user is redirected to the "Moji oglasi" page.
 * Close the browser.
 */

public class LoginTest extends BaseTest {


    @Test
    public void successfulLogin() {
        ChromeDriver driver = openChromeDriver();

        try {
            LoginPage loginPage = new LoginPage(driver);
            sleep(3);
            print("1. Click on 'Uloguj se' button");
            loginPage.clickLoginButton();
            sleep(3);
            print("2. Enter valid email");
            loginPage.enterTextInEmailField(Strings.VALID_EMAIL);

            print("3. Enter valid password");
            loginPage.enterTextInPasswordField(Strings.VALID_PASS);

            print("4. Click 'Uloguj se' button");
            loginPage.clickSubmitLoginButton();
            sleep(3);
            print("5. Verify that user is on Moji oglasi page");

            assert loginPage.isLogOutButtonDisplayed();

        } finally {
            driver.quit();
        }
    }
}


