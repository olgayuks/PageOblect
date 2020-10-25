package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private static String ENDPOINT = "/auth/login/";

    protected By emailSelector = By.id("name");
    protected By passwordSelector = By.id("password");
    protected By loginSelector = By.id("button_primary");
    protected By ERROR_MESSAGE_Selector = By.className("error-text");
    protected By LOGINPAGE_MESSAGE_Selector = By.className("loginpage-message-image");
    protected By LOGINPAGE_TEXT_Locator = By.xpath("//div[text()='Password is required.']");
    protected By LOGINPAGE_MESSAGES_Locator = By.xpath("//div[contains(text(),'is required')]");

    public LoginPage(WebDriver driver, boolean openPageByUrl) {

        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {

        driver.get(BASE_URL + ENDPOINT);
    }

    public boolean isPageOpened() {

        try {
            return driver.findElement(By.id("button_primary")).isDisplayed();
        } catch (Exception ex) {
            return false;
        }

    }

    public WebElement getEmailField() {

        return driver.findElement(emailSelector);
    }

    public WebElement getPasswordField() {

        return driver.findElement(passwordSelector);
    }

    public WebElement getLoginButton() {

        return driver.findElement(loginSelector);
    }
    public String getErrorMessage() {

        return driver.findElement(ERROR_MESSAGE_Selector).getText();
    }
    public String getLoginPageMessage() {

        return driver.findElement(LOGINPAGE_MESSAGE_Selector).getText();
    }
    public String getLoginPageText() {

        return driver.findElement(LOGINPAGE_TEXT_Locator).getText();
    }
    public String getLoginPageMessages() {

        return driver.findElement(LOGINPAGE_MESSAGES_Locator).getText();
    }

}
