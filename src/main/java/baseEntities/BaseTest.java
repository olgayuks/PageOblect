package baseEntities;

import browserService.BrowserService;
import browserService.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.Listener;

@Listeners(Listener.class)
public class BaseTest {

    public WebDriver driver;
    public ReadProperties readProperties = new ReadProperties();

    public BaseTest() {
    }

    @BeforeClass
    public void setUp() {
        this.driver = new BrowserService().getDriver();
//        driver.get(new ReadProperties().getURL());
        driver.get(readProperties.getURL());
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
