package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.EditPage;

public class EditPageSteps {

    private WebDriver driver;
    private String editPageEndpoint;

    public EditPageSteps(WebDriver driver, String editPageEndpoint) {
        this.driver = driver;
        this.editPageEndpoint = editPageEndpoint;
    }

    public void editProject(String newName) {
        final EditPage editPage = new EditPage(driver, editPageEndpoint);
        editPage.openPage();
        final WebElement nameField = editPage.getNameField();
        nameField.clear();
        nameField.sendKeys(newName);
        editPage.getButton().click();
    }


}
