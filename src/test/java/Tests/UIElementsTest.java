package Tests;

import baseEntities.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.LoginSteps;
import wrappers.*;

public class UIElementsTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(UIElementsTest.class);

  @Test
    public void initTest(){
      logger.info("Info");
      logger.debug("Debug");
      logger.error("Error");
        LoginPage loginPage = new LoginPage(driver, true);
        UIElement element = loginPage.getEmailField();
        element.click();

      Button loginButton = loginPage.getLoginButton();
       loginButton.click();
    }
    @Test
    public void tableTest(){
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUsername(),
                readProperties.getPassword());

        driver.get("https://aqa0702.testrail.io/index.php?/admin/projects/overview");

        Table table = new Table(driver, By.cssSelector("table.grid"));
        table.clickItemInRow(1);
    }

    @Test
    public void checkboxTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUsername(), readProperties.getPassword());

        driver.get("https://aqa0702.testrail.io/index.php?/admin/projects/edit/48");

        final CheckBox checkBox = new CheckBox(driver, By.id("show_announcement"));
        checkBox.check();
        Assert.assertTrue(checkBox.isSelected());

    }

    @Test
    public void radioButtonClick(){
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUsername(),
                readProperties.getPassword());
        driver.get("https://aqa0702.testrail.io/index.php?/admin/projects/edit/48");
        final RadioButton radioButton = new RadioButton(driver, By.id("suite_mode_single"));
        radioButton.clickButton();

    }
@Test
    public void DropDownTest(){
    LoginSteps loginSteps = new LoginSteps(driver);
    loginSteps.login(readProperties.getUsername(),
            readProperties.getPassword());
    driver.get("https://aqa0702.testrail.io/index.php?/projects/overview/48");
    final DropDownMenu dropDownMenu = new DropDownMenu(driver, By.xpath("//a[@href='#reportDropdown']"));
    dropDownMenu.click();
}

}
