package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    //webelementi

    @FindBy(xpath = "//button[contains(@class, 'MyKpMenu_loginButton')]")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id='email']")
    WebElement userEmailField;

    @FindBy(xpath = "//*[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id='kp-portal']//div[@class='LoginModal_remember__MZKNQ']/following-sibling::button")
    WebElement submitLoginButton;

    @FindBy (xpath = "//a[@class='Link_link__J4Qd8 MyKpMenu_item__ia6x9' and @id='' and @role='button' and @tabindex='-1' and @href='/login']\n")
    WebElement logOutButton;

    @FindBy(xpath = "//button[@class='Button_base__Pz8U1 Button_big__6JOpp ButtonSecondary_secondary__MOPh4 LoginPage_loginButton__d6kCL']\n")
    WebElement logInButton1;

    //konstruktor
    public LoginPage(ChromeDriver driver){
        this.driver = driver;
        driver.get(Strings.HOME_PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    //metode nad webelementima

    public void clickLoginButton() {
        loginButton.click();

    }

    public void enterTextInEmailField(String text) {
        userEmailField.click();
        userEmailField.sendKeys(text);
    }

    public void enterTextInPasswordField(String text) {
        passwordField.click();
        passwordField.sendKeys(text);
    }

    public void clickSubmitLoginButton() {
        submitLoginButton.click();

    }
    public boolean isLogOutButtonDisplayed(){
        return isElementPresent(logOutButton);

    }
    public boolean isLoginButtonDisplayed(){
        return isElementPresent(loginButton);
    }
      public boolean isLogInButtonDisplayed() {
        return isElementPresent(logInButton1);
   }

    public void clickLogOutButton(){
        logOutButton.click();
    }

//    public void isLoginUrlDisplayed(){
//        return isElementPresent(Strings.LOGIN_PAGE);
//    }


//    public boolean isSearchResultsPresent() {
//        System.out.println("isSearchResultsPresent");
//        return isElementPresent(searchResultsTabLocator);

//
//        public String getSearchErrorMessage() {
//        print("getSearchErrorMessage");
//        waitForElement(errorMessage);
//        return errorMessage.getText();
//    }
//    public void clickOnAutomobil() {
//        try {
//            WebElement automobil = driver.findElement(By.xpath("//div[p='Automobili']"));
//            automobil.click();
//        } catch (NoSuchElementException exc) {
//            System.out.println("Polje/dugme 'Automobil' nije pronađeno na stranici.");
//        }
}

