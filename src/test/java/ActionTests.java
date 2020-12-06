import baseEntities.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.DashboardPage;
import steps.LoginSteps;

import java.util.concurrent.TimeUnit;

public class ActionTests extends BaseTest {
    private static final Logger logger = LogManager.getLogger(ActionTests.class);

    @Test
    public void clickButtonLink() {
        logger.info("Info");
        logger.debug("Debug");
        logger.error("Error");
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUsername(),
                readProperties.getPassword());

        DashboardPage dashboardPage = new DashboardPage(driver, false);
        dashboardPage.clickButtonProjectLink();


    }

    @Test
    public void drugAndDropTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUsername(),
                readProperties.getPassword());

        driver.get("https://aqa071.testrail.io/index.php?/cases/edit/1/1");
        WebElement icon = driver.findElement(By.className("icon-markdown-image"));
        WebElement stepField = driver.findElement(By.cssSelector(".form-control.form-control-full.expected processed.textarea-with-grippie"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(icon, stepField).build().perform();
        actions.contextClick();

        icon.click();

//        WebElement dialogField = driver.findElement(By.id("attachmentDropzone"));
//        dialogField.sendKeys("C:/Users/user/Downloads/Telegram Desktop/Screenshot_1.png");
//        WebElement attachmentSubmit = driver.findElement(By.id("attachmentSubmit"));
//        attachmentSubmit.submit();
    }

}
