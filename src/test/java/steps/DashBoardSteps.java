package steps;

import org.openqa.selenium.WebDriver;
import pages.DashboardPage;

public class DashBoardSteps {
    private WebDriver driver;

    public DashBoardSteps (WebDriver driver) {
        this.driver = driver;
    }
    public void dash(){
        DashboardPage dashboardPage = new DashboardPage(driver, true);
        System.out.println(dashboardPage.isTitleContainsAllProject());
        dashboardPage.getAddProjectButton().click();
    }
}
