package utils;

import browserService.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
    private WebDriver driver;
    private WebDriverWait webDriverWait;


    public Waits(WebDriver driver, int timeOut) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, timeOut);
    }

    public Waits(WebDriver driver) {
        this.driver = driver;
        ReadProperties readProperties = new ReadProperties();
        webDriverWait = new WebDriverWait(driver, readProperties.getTimeOut());
    }

    public boolean isElementDisplayed(By by) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }

    }

    public WebElement getElementBy(By by) {
        try {
            return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (TimeoutException ex) {
            return null;
        }

    }
    public WebElement isElementClickable(WebElement webElement) {
        try {
            return webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (TimeoutException ex) {
            return null;
        }

    }

    public boolean isCheckboxSelected(By by) {
        try {
            return webDriverWait.until(ExpectedConditions.elementToBeSelected(by));
        }catch (TimeoutException ex){
            return false;
        }
    }

    public boolean checkCheckboxState(By by, boolean state) {
        try {
            return webDriverWait.until(ExpectedConditions.elementSelectionStateToBe(by, state));
        }catch (TimeoutException ex){
            return false;
        }
    }

    public WebElement getClickableButton(By by) {
        try {
            return webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (TimeoutException ex) {
            return null;
        }
    }

    public boolean isElementAttributeContainsValue(By by, String attribute, String value) {
        try {
            return webDriverWait.until(ExpectedConditions.attributeContains(by, attribute, value));
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public boolean isElementAttributeWithValue(By by, String attribute, String value) {
        try {
            return webDriverWait.until(ExpectedConditions.attributeToBe(by, attribute, value));
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public boolean isTitle(String title) {
        try {
            return webDriverWait.until(ExpectedConditions.titleIs(title));
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public boolean isTitleContains(String title) {
        try {
            return webDriverWait.until(ExpectedConditions.titleContains(title));
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public boolean isInvisibleElementLocatedBy(By by) {
        try {
            return webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public boolean isInvisibleElementWithTextLocatedBy(By by, String text) {
        try {
            return webDriverWait.until(ExpectedConditions.invisibilityOfElementWithText(by, text));
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public boolean isMessageDisplayed(By by, String message) {
        try {
            return webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(by, message));
        } catch (TimeoutException ex) {
            return false;
        }

    }

    public WebElement getNameField(By by){
        try {
            return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (TimeoutException ex){
            return null;
        }
    }

}

