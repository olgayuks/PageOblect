package Tests;

import baseEntities.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(AlertTest.class);

    @Test
    public void infoAlertTest() {
        logger.info("Info");
        logger.debug("Debug");
        logger.error("Error");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    @Test
    public void confirmAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        alert = driver.switchTo().alert();
        alert.dismiss();
    }

    @Test
    public void promptAlertTest() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());

        alert.sendKeys("всё гуд");
        alert.accept();

        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        alert = driver.switchTo().alert();
        alert.dismiss();
    }

}
