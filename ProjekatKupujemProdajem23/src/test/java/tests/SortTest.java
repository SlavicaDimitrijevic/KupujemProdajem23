package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;
import pages.Strings;

import java.util.List;

/**
 * Open Chrome browser.
 * "Navigate to the Home page"
 * "Click on the 'Automobili' button on the Home page"
 * "Get the price of the first item before sorting"
 * "Click on the 'Sortiraj' button on the Home page"
 * "Select the 'Jeftinije' option to sort items by price ascending"
 * "Get the price of the first item after sorting"
 * "Verify that the search results are sorted by price ascending"
 * Close the browser.
 */

public class SortTest extends BaseTest {

    @Test
    public void sortItemsTest() {
        ChromeDriver driver = openChromeDriver();
        try {
            sleep(3);
            print("1. Navigate to Home page");
            HomePage homePage = new HomePage(driver);
            sleep(3);
            print("2. Click on the 'Automobili' button on the Home page");
            homePage.clickAutomobilButton();
            sleep(3);
            print("3. Get the price of the first item before sorting");
            sleep(3);
            List<WebElement> allItemPricesBeforeSort = driver.findElements(By.xpath("//*[@id=\"146529283\"]/article/div/div[2]/div/div"));
            sleep(3);
            String firstItemPriceBeforeSort = allItemPricesBeforeSort.get(0).getText();
           String formattedPriceBeforeSort = firstItemPriceBeforeSort.replaceAll("[^0-9.]", "");
           double priceBeforeSort = Double.parseDouble(formattedPriceBeforeSort);

            sleep(3);
            print("4. Click on the 'Sortiraj' button on the Home page");
            homePage.clickSortButton();
            sleep(3);
            print("5. Select 'Jeftinije' option to sort items by price ascending");
            homePage.clickSortJeftinije();
            sleep(5);

            print("6. Get the price of the first item after sorting");
            List<WebElement> allItemPricesAfterSort = driver.findElements(By.xpath("//*[@id=\"151815712\"]/article/div/div[2]/div/div"));
            sleep(3);
            String firstItemPriceAfterSort = allItemPricesAfterSort.get(0).getText();
            String formattedPriceAfterSort = firstItemPriceAfterSort.replaceAll("[^0-9.]", "");
            double priceAfterSort = Double.parseDouble(formattedPriceAfterSort);

            print("7. Verify that the search results are sorted by price ascending");
            print("Price before sort: " + priceBeforeSort);
            print("Price after sort: " + priceAfterSort);

            if (priceBeforeSort > priceAfterSort) {
                print("Price before sort (" + priceBeforeSort + ") is greater than price after sort (" + priceAfterSort + ")");
            } else if (priceBeforeSort < priceAfterSort) {
                print("Price after sort (" + priceAfterSort + ") is greater than price before sort (" + priceBeforeSort + ")");
            } else {
                System.out.println("Prices are equal");
            }

            sleep(3);

            assert homePage.isJeftinijeButtonDisplayed();
            assert priceBeforeSort <= priceAfterSort : "Search results are not sorted by price ascending";

        } finally {
            driver.quit();
        }
    }
}


