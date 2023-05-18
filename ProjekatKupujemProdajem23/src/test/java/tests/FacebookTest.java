package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.Strings;
/**
 * Open Chrome browser.
 *Opens the homepage of www.kupujemprodajem.rs.
 *Displays the message "1. Navigate to www.kupujemprodajem.rs" after a certain delay.
 *Scrolls down the page.
 *Finds the Facebook icon on the page.
 *Uses the scrollIntoView() function on the homePage object to bring the Facebook icon into view.
 *Displays the message "3. Verify that new Facebook Tab is open" after a certain delay.
 *Clicks on the Facebook icon.
 *After a certain delay, switches to the newly opened tab (the index of the tab is determined using the getWindowHandles() method).
 *Retrieves the current URL of the newly opened tab.
 *Prints the actual URL.
 *After a certain delay, checks if the actual URL is equal to Strings.FACEBOOK (presumably defined as a constant with the value "https://www.facebook.com"). If it's not equal, it displays the message "User is on a wrong page" along with the currently opened URL.
 *Close the browser..
 */

public class FacebookTest extends BaseTest{

    @Test
    public void clickFacebookBanner() {
        ChromeDriver driver = openChromeDriver();
        HomePage homePage = new HomePage(driver);
        try {
sleep(5);
            print("1.Navigate to www.kupujemprodajem.rs");
            print("2.Scroll down");
            WebElement facebookIcon = driver.findElement(By.xpath("//a[contains(@class, \"Link_link__J4Qd8\") and @href=\"https://www.facebook.com/KupujemProdajem\"]\n"));
            homePage.scrollIntoView(driver, facebookIcon);
            sleep(3);
            print("3.Verify that new Facebook Tab is open ");
            homePage.clickOnFacebookIcon();
            sleep(3);
            driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
            String actualUrl = driver.getCurrentUrl();
            print(actualUrl);
            sleep(5);
            assert actualUrl.equals(Strings.FACEBOOK) : "User is on a wrong page " + Strings.FACEBOOK;

        } finally {
            driver.quit();
        }

    }
}
