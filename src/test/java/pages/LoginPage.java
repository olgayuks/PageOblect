package pages;

import baseEntities.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import wrappers.Button;
import wrappers.UIElement;

public class LoginPage extends BasePage {
    private static String ENDPOINT = "/auth/login/";

    @FindBy(id = "name")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "button_primary")
    private WebElement loginButton;

    @FindBy(id = "error-text")
    public WebElement ERROR_MESSAGE_Selector;

    @FindBy(className = "loginpage-message-image")
    public WebElement LOGINPAGE_MESSAGE_Selector;

    @FindBy(xpath = "//div[text()='Password is required.']")
    public WebElement LOGINPAGE_TEXT_Locator;

    @FindBy(xpath = "//div[contains(text(),'is required')]")
    public WebElement LOGINPAGE_MESSAGES_Locator;

    @FindBy(id = "rememberme")
    public WebElement KEEP_ME_LOGGED_Locator;


//    protected By emailSelector = By.id("name");
//    protected By passwordSelector = By.id("password");
//    protected By loginSelector = By.id("button_primary");
//    protected By ERROR_MESSAGE_Selector = By.className("error-text");
//    protected By LOGINPAGE_MESSAGE_Selector = By.className("loginpage-message-image");
//    protected By LOGINPAGE_TEXT_Locator = By.xpath("//div[text()='Password is required.']");
//    protected By LOGINPAGE_MESSAGES_Locator = By.xpath("//div[contains(text(),'is required')]");
//    protected By KEEP_ME_LOGGED_Locator = By.id("rememberme");

    public LoginPage(WebDriver driver, boolean openPageByUrl) {

        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + ENDPOINT);
    }

    public boolean isPageOpened() {
        return loginButton.isDisplayed();

    }

    public UIElement getEmailField() {
//     return waits.getElementBy(emailSelector)
        new UIElement(driver, userName);
        return new UIElement(driver, userName);
    }

    public WebElement getPasswordField() {

        return null;
    }

    public Button getLoginButton() {

        return null;
    }

    public WebElement getErrorMessage() {
        return null;
    }

    public String getLoginPageMessage() {

        return null;
    }

    public String getLoginPageText() {

        return null;
    }

    public String getLoginPageMessages() {

        return null;
    }

    public boolean isKeepMeLoggedInSelected() {

        return false;
    }

    public boolean isNameInputHasAttributeNameWithValueName() {
        return false;
    }

    public boolean isPasswordContainsAutocompleteAttributeValuePassword() {
        return false;
    }

    public boolean isTitleLogin() {
        return false;
    }

    public boolean hasError() {
        return false;
    }

    public DashboardPage clickLoginButton() {
        loginButton.click();
        return new DashboardPage(driver, false);

    }
}
