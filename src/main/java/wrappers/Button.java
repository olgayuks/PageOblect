package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button {

    private WebDriver driver;
    private UIElement uiElement;

    public Button(WebDriver driver, By by) {
        this.driver = driver;
        uiElement = new UIElement(driver, by);
    }

    public Button(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        uiElement = new UIElement(driver, webElement);
    }

    public void click(){
        uiElement.click();
    }
}
