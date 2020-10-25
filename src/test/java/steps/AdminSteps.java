package steps;

import org.openqa.selenium.WebDriver;
import pages.AdminPage;

public class AdminSteps {
    private WebDriver driver;

    public AdminSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void deleteProject() {
        AdminPage adminPage = new AdminPage(driver, true);
        adminPage.getDeleteButtonSelector().click();
        adminPage.getCheckBoxButtonSelector().click();
        adminPage.getOkButtonSelector().click();
    }

    public EditPageSteps openEditProjectPage() {
        AdminPage adminPage = new AdminPage(driver, true);
        final String href = adminPage.getEditLink().getAttribute("href");
        return new EditPageSteps(driver, href);
    }
}
