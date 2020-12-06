package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectPage extends BasePage {
    private static String EndPoint = "/admin/projects/add/1";


    protected By nameSelector = By.id("name");
    protected By buttonSelector = By.id("accept");
    protected By Error_MessageSelector = By.xpath("//div[contains(text(),'required field.')]");
    protected By checkbox_selector = By.id("show_announcement");

    public ProjectPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + EndPoint);
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

        return waits.getNameField(By.id("name"));
    }


    public WebElement getButton() {
        return waits.getClickableButton(buttonSelector);
    }


    public String getError_Message() {

        return driver.findElement(Error_MessageSelector).getText();
    }

    public boolean isCheckboxUnselected() {
        return waits.checkCheckboxState(checkbox_selector, false);
    }

}
