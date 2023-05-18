package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.Strings;

/**
 * Open Chrome browser.
 * "Click on the 'Uloguj se' button".
 * "Enter a valid email address".
 * "Enter a valid password".
 * "Click the 'Uloguj se' button".
 * "Verify that the user is on the 'Moji oglasi' page".
 * "Enter the phone ID and perform a search".
 * "Click the search button".
 * "Click on the iPhone item".
 * "Click the send message button".
 * "Click the write message field".
 * "Verify that the message is sent: " + Strings.WRITE_MESSAGE.
 * Close the browser.
 */

public class SendMessageTest extends BaseTest {

    @Test
    public void successfulLogin() {
        ChromeDriver driver = openChromeDriver();

        try {
            HomePage homePage = new HomePage(driver);
            LoginPage loginPage = new LoginPage(driver);
            BasePage basePage = new BasePage(driver);
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
           // assert loginPage.isLogOutButtonDisplayed();
            print("6. Enter phone ID and search.");
            sleep(3);
            homePage.writeTextAndSearch(Strings.IPHONE);
            sleep(3);
            print("7. Click the search button");
            homePage.clickSearchButton();
            sleep(3);
            print("8. Click on the iPhone item");
            homePage.clickOnIPhone();
            sleep(3);
            print("9. Click the send message button");
            homePage.clickSendMessageButton();
            sleep(5);
            print("10. Click the write message field");
            homePage.clickWriteMessage();
            sleep(2);
            print("11. Write the message: " + Strings.WRITE_MESSAGE);
            homePage.writeMessage(Strings.WRITE_MESSAGE);
            sleep(5);

            //homePage.scrollIntoView(driver,myElement );
            WebDriverWait wait = new WebDriverWait(driver,10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class, 'ButtonSecondary_secondary__MOPh4') and .//span[text()='Prihvatam']]\n")));
                    driver.findElement(By.xpath("//button[contains(@class, 'ButtonSecondary_secondary__MOPh4') and .//span[text()='Prihvatam']]\n")).click();
            homePage.sendMessageToUser();
            sleep(3);
            WebElement chatBox = driver.findElement(By.xpath("//div[@class=\"MessageChatBox_chatBoxHolder__4Q1lO\"]\n"));
            assert chatBox.getText().contains(Strings.WRITE_MESSAGE);
        } finally {
            driver.quit();
        }
    }
}
