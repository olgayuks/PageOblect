package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButton {
    private WebDriver driver;
    private UIElement uiElement;

    public RadioButton(WebDriver driver, By by) {
        this.driver = driver;
        uiElement = new UIElement(driver, by);
    }

    public RadioButton(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        uiElement = new UIElement(driver, webElement);
    }

    public void clickButton() {
        if (!isSelected()) {
            uiElement.click();

        }

    }
    public boolean isSelected() {

        return uiElement.isSelected();
    }
}
