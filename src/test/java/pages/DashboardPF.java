package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPF extends BasePage {
    private static String END_POINT = "/dashboard";

    @FindBy(id = "sidebar-projects-add")
    private WebElement addProjectButton;

    @FindBy(linkText = "MainProject")
    private WebElement buttonProjectLink;

    public DashboardPF(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL + END_POINT);
    }

    @Override
    public boolean isPageOpened() {
        return addProjectButton.isDisplayed();
    }

    public ProjectPage clickAddButton(){
        addProjectButton.click();
        return new ProjectPage(driver, false);
    }
}
