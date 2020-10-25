package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage extends BasePage {
    private static String END_POINT = "/dashboard";

    protected By addProjectButton = By.id("sidebar-projects-add");

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

        return driver.findElement(addProjectButton);
    }

}
