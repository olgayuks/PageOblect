import baseEntities.BaseTest;
import dataprovider.TestsDataProvider;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import steps.*;
import utils.Retry;

public class MainTest extends BaseTest {
    private LoginSteps loginSteps;
    private DashBoardSteps dashBoardSteps;
    private ProjectSteps projectSteps;
    private AdminSteps adminSteps;

//    @Test(priority = 4)
//    public void loginPositiveTest() {
//        loginSteps = new LoginSteps(driver);
//        loginSteps.login(readProperties.getUsername(),
//                readProperties.getPassword());
//
//        Assert.assertTrue(true);
//    }

//    @Test(priority = 0)
//    public void loginNegativeTest() {
//        loginSteps = new LoginSteps(driver);
//        loginSteps.login("fail",
//                readProperties.getPassword());
//
//        Assert.assertEquals(new LoginPage(driver, false).getErrorMessage(),
//                "Email/Login or Password is incorrect. Please try again.", "incorrect error message");
//    }
//
//    @Test(priority = 1)
//    public void loginNegativeTest1() {
//        loginSteps = new LoginSteps(driver);
//        loginSteps.login(" ",
//                readProperties.getPassword());
//
//        Assert.assertEquals(new LoginPage(driver, false).getLoginPageMessage(),
//                "Email/Login is required.", "incorrect login page message");
//    }
//
//    @Test(priority = 2)
//    public void loginNegativeTest2() {
//        loginSteps = new LoginSteps(driver);
//        loginSteps.login(readProperties.getUsername(),
//                " ");
//
//        Assert.assertEquals(new LoginPage(driver, false).getLoginPageText(),
//                "Password is required.", "incorrect login page message");
//    }

//    @Test(priority = 3)
//    public void loginNegativeTest3() {
//        loginSteps = new LoginSteps(driver);
//        loginSteps.login(" ", " ");
//        Assert.assertEquals(new LoginPage(driver, false).getLoginPageMessages(),
//                "Email/Login is required.", "incorrect message");
//    }



    @Test(dataProvider = "loginCredentialSource", dataProviderClass = TestsDataProvider.class, priority = 0)
    public void loginTest(String username, String psw) {
        loginSteps = new LoginSteps(driver);
        loginSteps.login(username, psw);
    }

    @Test (priority = 1)
    public void dashPositiveTest() {
        dashBoardSteps = new DashBoardSteps(driver);
        dashBoardSteps.dash();
    }

    //    @Test(priority = 6)
//    public void projectNegativeTest() {
//        projectSteps = new ProjectSteps(driver);
//        projectSteps.project(" ");
//
//        Assert.assertEquals(new ProjectPage(driver, false).getError_Message(),
//                "Field Name is a required field.", "Error");
//    }
//
//    @Test(priority = 7)
//    public void projectPositiveTest() {
//        projectSteps = new ProjectSteps(driver);
//        final String name = readProperties.getName();
//        projectSteps.project(name);
//
//    }

    @Test (dataProvider = "projectSource", dataProviderClass = TestsDataProvider.class, priority = 2)
    public void  createProjectTest(String projectName) {
        projectSteps = new ProjectSteps(driver);
        projectSteps.project(projectName);
    }

    @DataProvider(name = "editProjectSource")
    public Object[][] editProjectNames(){
        return new Object[][]{
                {" "},
                {"my new name"}

        };
    }

    @Test(priority = 3, dataProvider = "editProjectSource")
    public void editProjectTest(String projectName) {
        final AdminSteps adminSteps = new AdminSteps(driver);
        final EditPageSteps editPageSteps = adminSteps.openEditProjectPage();
        editPageSteps.editProject(projectName);
    }

    @Test(priority = 4)
    public void deleteProjectFromAdminPageTest() {
        adminSteps = new AdminSteps(driver);
        adminSteps.deleteProject();
    }

//    @Test
//    public void testLoginCreateEditProject() {
//        final LoginSteps loginSteps = new LoginSteps(driver);
//        loginSteps.login(readProperties.getUsername(), readProperties.getPassword());
//
//        final ProjectSteps projectSteps = new ProjectSteps(driver);
//        projectSteps.project(readProperties.getName());
//
//        final AdminSteps adminSteps = new AdminSteps(driver);
//        final EditPageSteps editPageSteps = adminSteps.openEditProjectPage();
//        editPageSteps.openEditPage(" ");
//        editPageSteps.openEditPage("my new name");
//        adminSteps.deleteProject();
//
//    }

//    @Test(retryAnalyzer = Retry.class)
//    public void retryTest(){
//        throw new NullPointerException();
    }
