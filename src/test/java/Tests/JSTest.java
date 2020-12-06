package Tests;

import baseEntities.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pages.DashboardPage;
import steps.LoginSteps;

public class JSTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(JSTest.class);

    @Test
    public void moveToElementTest(){
        logger.info("Info");
        logger.debug("Debug");
        logger.error("Error");
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUsername(),
                readProperties.getPassword());

        DashboardPage dashboardPage = new DashboardPage(driver, false);
        dashboardPage.clickButtonProjectLink();
    }
}
