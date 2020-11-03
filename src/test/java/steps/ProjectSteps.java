package steps;

import org.openqa.selenium.WebDriver;
import pages.ProjectPage;

public class ProjectSteps {
    private WebDriver driver;

    public ProjectSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void project(String name) {
        ProjectPage projectPage = new ProjectPage(driver, true);

        projectPage.getNameField().sendKeys(name);
        projectPage.getButton().submit();

    }

}
