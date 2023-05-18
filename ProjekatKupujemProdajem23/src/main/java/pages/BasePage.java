package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    @FindBy(xpath ="//*[@id='keywords']")
    WebElement searchField;
    @FindBy (xpath = "//div[@class=\'Header_header__PdXhf\']//a[@class=\'Link_link__J4Qd8 Logo_logo__2vSTN\' and @tabindex=\'-1\']")
    WebElement logoKupujemProdajem;
    @FindBy (xpath = "//*[@class=\"Button_base__Pz8U1 Button_big__6JOpp ButtonSearch_search__nLSRu ButtonSearch_isBlue__4Wdib\"]")
     WebElement searchButton;

    //*pomocne metode
    public static  void print (String s ){
        System.out.println(s);
    }

    BasePage(){}
    ChromeDriver driver;
    public BasePage(ChromeDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitforElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,20);
        Duration timeout = Duration.ofSeconds(20);
  //      WebDriverWait wait = new WebDriverWait(driver, timeout);
    }

    public boolean isElementPresent(WebElement element) {
        try {
            boolean isPresent = element.isDisplayed();
            return isPresent;
        } catch (Exception exc) {
            print(exc.getMessage());
            print("Element is not found");
            return false;
        }
    }

    //**ovo koristimo za elemente stranice gde treba da se skroluje do njih//

    public boolean isPageLoaded() {
        return driver.getTitle().contains(Strings.ITEM_PAGE);
    }

}

