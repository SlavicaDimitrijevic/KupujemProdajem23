package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    //web elementi
    @FindBy (xpath = "//div[@id='kp-portal']//span[text()='Jeftinije']")
            WebElement SortJeftinije;

    @FindBy(xpath = "//div[p='Automobili']")
    WebElement Automobili;

    @FindBy(xpath = "//div[contains(@class, 'PopUp_root__H7y4T')]//span[contains(@class, 'Button_children__3mYJw')][text()='Sortiraj']")
    WebElement SortButton;

    @FindBy(xpath = "//div[@id='kp-portal']//span[text()='Jeftinije']")
    WebElement SortCheaper;


    @FindBy(xpath = "//span[@class='Button_children__3mYJw']\n")
    WebElement sortingButton;

    @FindBy(xpath = "//div[@class=\"AdItem_name__RhGAZ\" and text()=\"iPhone 8\"]\n")
    WebElement iphone8;

    @FindBy(xpath = "//button[contains(span[@class='Button_children__3mYJw'], 'Pošaljite poruku')]\n")
    WebElement SendMessageButton;
    @FindBy(xpath = "//textarea[@id='message' and @name='message' and contains(@class, 'TextField_textField__nLxbF') and @placeholder='Unesite Vašu poruku. Za brže slanje pritisnite CTRL + ENTER']\n")
    WebElement WriteMessage;

    @FindBy(xpath = "//span[contains(@class, 'Button_children__3mYJw') and text()='Pošaljite poruku']\n")
    WebElement SendMessageInChat;
    @FindBy(xpath = "//div[@class=\"MessageChatBox_chatBoxHolder__4Q1lO\"]\n")
    WebElement ChatBox;

    @FindBy(xpath = "//a[contains(@class, \"Link_link__J4Qd8\") and @href=\"https://www.facebook.com/KupujemProdajem\"]\n")
    WebElement  FacebookIcon;

    public HomePage(ChromeDriver driver) {
        super(driver);
        driver.get(Strings.HOME_PAGE_URL);
        print("Home Page");
    }

    //metoda koja pronalazi Dugme Automobil i klikce na njega
    public void clickAutomobilButton() {
        Automobili.click();
}
    public void scrollIntoView(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript( "arguments[0].scrollIntoView(true); " , element);
    }
//    public void clickAutomobilButton() {
//        try {
//            WebElement automobil = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div/div[2]/section/div/a[4]"));
//            automobil.click();
//        } catch (NoSuchElementException exc) {
//            print("Polje/dugme 'Automobil' nije pronađeno na stranici.");
//        }
//    }


    public void clickSortButton() {
        SortButton.click();
    }
    public void clickSortJeftinije(){
        SortJeftinije.click();
    }


    public void clickSelectPriceOption() {
        // Kliknemo na padajući meni za sortiranje

        //WebElement sortMenu = driver.findElement(By.xpath("//div[contains(@class, 'PopUp_root__H7y4T')]//span[contains(@class, 'Button_children__3mYJw')][text()='Sortiraj']"));
        //sortMenu.click();

        // Pronađi opciju za sortiranje po ceni (rastuće) jeftinije i klikni na nju
        WebElement priceAscendingOption = driver.findElement(By.xpath("//div[@id='kp-portal']//span[text()='Jeftinije']"));
        priceAscendingOption.click();
    }

    //***metoda za search

    public void writeTextAndSearch(String text) {
        print("writeTextAndSearch");
        searchField.click();
        searchField.sendKeys(text);
    }

    public void clickSearchButton() {
        print("clickSearchButton");
        searchButton.click();
    }


    public boolean isPageLoaded() {
        String title = "KupujemProdajem | Pretraga";
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return driver.getTitle().equals(title) && searchField.isDisplayed() && searchButton.isDisplayed();
    }

    public static WebElement waitUntilElementIsVisible(WebDriver driver, By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void selectSortByPriceAscending() {
        //driver.findElement(By.xpath("//div[@id='kp-portal']//span[text()='Jeftinije']")).click();
        SortCheaper.click();
    }

    public boolean isSortingButtonPresent() {
        return isElementPresent(sortingButton);
    }

    public boolean isJeftinijeButtonDisplayed() {
        return driver.findElement(By.xpath("//*[@class='PopUp_root__H7y4T']//span[text()='Jeftinije']")).isDisplayed();
    }

    public void clickOnIPhone() {
        iphone8.click();
    }

    public void clickSendMessageButton() {
        SendMessageButton.click();
    }

    public void clickWriteMessage() {
        WriteMessage.click();
    }
    public void writeMessage(String text){
        WriteMessage.sendKeys(text);
    }

    public void sendMessageToUser() {
        SendMessageInChat.click();

    }
    public void clickOnFacebookIcon() {
        FacebookIcon.click();
    }
//    public boolean chatBoxVisibility(){
//        return isElementPresent(ChatBox);
//    }
    }

