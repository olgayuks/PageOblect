package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DashboardPage extends BasePage {
    private static String END_POINT = "/dashboard";

    protected By addProjectButton = By.id("sidebar-projects-add");
    protected By buttonProjectLink = By.linkText("MainProject");

    public DashboardPage(WebDriver driver, boolean openPageByUrl) {

        super(driver, openPageByUrl);
    }


    @Override
    protected void openPage() {
        driver.get(BASE_URL + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return driver.findElement(By.id("sidebar-projects-add")).isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public WebElement getAddProjectButton() {

        return waits.getClickableButton(By.id("sidebar-projects-add"));
    }

    public boolean isTitleContainsAllProject() {

        return waits.isTitleContains("All Projects");

    } public WebElement getButtonProjectLink() {

        return waits.getElementBy(buttonProjectLink);
    }
    public void clickButtonProjectLink(){
        WebElement webElement = getButtonProjectLink();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("arguments[0].scrollIntoView(true)", webElement);
        jsExecutor.executeScript("arguments[0].click;", webElement);
//        webElement.click();
    }


}
