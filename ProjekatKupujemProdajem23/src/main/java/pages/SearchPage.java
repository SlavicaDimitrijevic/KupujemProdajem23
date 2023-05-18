package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class, 'Link_link__J4Qd8') and contains(@href, 'volkswagen-passat-b6')]/div[@class='AdItem_name__RhGAZ']")
    WebElement searchResultLocator;


    @FindBy(xpath = "//div[contains(@class, 'NotificationBox_holder') and contains(@class, 'NotificationBox_info')]//p[contains(@class, 'NotificationBox_title')]")
    WebElement searchErrorMessage;


    public WebDriverWait wait;

    public SearchPage(ChromeDriver driver) {
        super(driver);

    //    wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    public void waitForSearchResults() {
        wait.until(ExpectedConditions.visibilityOf(searchResultLocator));
    }

    public boolean isSearchResultsPresent() {
        print("isSearchResultsPresent");
        return isElementPresent(searchResultLocator);
    }

    public String getSearchErrorMessage() {
        print("getSearchErrorMessage");
        return searchErrorMessage.getText();

    }



}