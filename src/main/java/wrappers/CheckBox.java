package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox {

    private WebDriver driver;
    private UIElement uiElement;

    public CheckBox(WebDriver driver, By by) {
        this.driver = driver;
        uiElement = new UIElement(driver, by);

    }

    public CheckBox(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        uiElement = new UIElement(driver, webElement);
    }


    public void check(){
        if (!isSelected()) {
            uiElement.click();
        }

    }

    public void uncheck(){
        if (isSelected()) {
            uiElement.click();
        }

    }

    public boolean isSelected(){

        return uiElement.isSelected();
    }

}
