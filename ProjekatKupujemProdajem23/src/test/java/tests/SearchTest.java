//package tests;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//import pages.HomePage;
//import pages.SearchPage;
//import pages.Strings;
//
//
///**
// * Search for valid item
// * 1. Navigate to Home page
// * 2. Enter name of item into search field
// * 3. Click search  button
//
// * Expected result:
// * 4. Verify that the search results are present
// */
//public class SearchTest extends BaseTest {
//
//    @Test
//    public void searchItemTest() {
//        ChromeDriver driver = openChromeDriver();
//        try {
//            print("1. Navigate to Home page");
//            HomePage homePage = new HomePage(driver);
//            sleep(20);
//            print("2. Enter name of  item into search field");
//            homePage.writeTextAndSearch(Strings.ITEM);
//            sleep(20);
//            print("3. click search button");
//            homePage.clickSearchButton();
//            sleep(20);
//
//            SearchPage searchResultPage = new SearchPage(driver);
//            print("4. Verify that the search results are present");
//            //assert searchResultPage.isSearchResultsPresent() : "There are NO search results";
//            assert driver.getTitle().contains(Strings.ITEM) : "New page was not loaded successfully";
//        } finally {
//            driver.quit();
//        }
//             }
//
//
//    }
//
//
//
package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.Strings;

/**
 * "Navigate to Home page" - Test opens a Chrome browser and navigates to the home page.
 * "Enter the name of the item into the search field"
 * "Click the search button"
 * "Verify if the sorting button is present"
 * Close the browser..
 */

public class SearchTest extends BaseTest {

@Test
public void searchItemTest() {
    ChromeDriver driver = openChromeDriver();
    try {
        print("1. Navigate to Home page");
        HomePage homePage = new HomePage(driver);
        sleep(5);
        print("2. Enter name of  item into search field");
        homePage.writeTextAndSearch(Strings.ITEM);
        sleep(5);
        print("3. click search button");
        homePage.clickSearchButton();
        //sleep(10);
        assert homePage.isSortingButtonPresent();

    } finally {
        driver.quit();
    }
}

}
