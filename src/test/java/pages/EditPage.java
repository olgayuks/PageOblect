package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditPage extends BasePage {

    protected By nameSelector = By.id("name");
    protected By buttonSelector = By.id("accept");

    private String editPageUrl;

    public EditPage(WebDriver driver, String editPageUrl) {
        super(driver, false);
        this.editPageUrl = editPageUrl;
    }

    @Override
    public void openPage() {
        driver.get(editPageUrl);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return driver.findElement(By.id("accept")).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public WebElement getNameField() {

        return driver.findElement(nameSelector);
    }

    public WebElement getButton() {

        return driver.findElement(buttonSelector);
    }
}
