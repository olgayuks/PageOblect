package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage extends BasePage {
    private static String EndPoint = "/admin/projects/overview/";

    protected By editButton = By.xpath("//a[text()='Next']");
    protected By deleteButtonSelector = By.className("icon-small-delete");
    protected By checkBoxButtonSelector = By.xpath("//*[@class='icon-progress-inline']/following::input");
    protected By okButtonSelector = By.xpath("//*[@class='icon-progress-inline']/following::a[1]");

    public AdminPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + EndPoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return driver.findElement(By.className("icon-small-delete")).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public WebElement getDeleteButtonSelector() {

        return driver.findElement(deleteButtonSelector);
    }

    public WebElement getCheckBoxButtonSelector() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(checkBoxButtonSelector));

    }

    public WebElement getOkButtonSelector() {
        return driver.findElement(okButtonSelector);
    }

    public WebElement getEditLink() {
        return driver.findElement(editButton);
    }
}
