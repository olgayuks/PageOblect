package steps;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {
    private WebDriver driver;

    public LoginSteps(WebDriver driver) {

        this.driver = driver;
    }

    @Step
    public void login(String username, String psw) {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.userName.sendKeys(username);
        loginPage.password.sendKeys(psw);
        loginPage.clickLoginButton();


    }

        @Step
        public void login(User user) {
            LoginPage loginPage = new LoginPage(driver, true);
            loginPage.userName.sendKeys(user.getUsername());
            loginPage.password.sendKeys(user.getPassword());
            loginPage.clickLoginButton();


    }
}

