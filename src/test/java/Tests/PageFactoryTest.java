package Tests;

import baseEntities.BaseTest;
import models.Project;
import models.TestCase;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import pages.*;
import steps.AdminSteps;
import steps.LoginSteps;

public class PageFactoryTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(PageFactoryTest.class);

    @Test(priority = 0)
    public void firstTest() {
        logger.info("Info");
        logger.debug("Debug");
        logger.error("Error");
       User user = new User(readProperties.getUsername(), readProperties.getPassword());
//
//        LoginPage loginPage = new LoginPage(driver, true);
//        loginPage.emailSelector.sendKeys();
//        loginPage.passwordSelector.sendKeys();
//        DashboardPage dashboardPage = loginPage.clickLoginButton();
//
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(user);
    }

    @Test(priority = 1)
    public void dashTest() {
        DashboardPF dashboardPF = new DashboardPF(driver, true);
        ProjectPage projectPage = dashboardPF.clickAddButton();
        System.out.println(projectPage.isPageOpened());
    }

    @Test
    public void secondTest(){
        TestCase testCase = new TestCase.Builder()
                .withTitle("Title")
                .withReference("AQA")
                .build();

    }
}
