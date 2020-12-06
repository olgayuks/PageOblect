package browserService;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class BrowserService {
    private WebDriver driver = null;
    private DriverManagerType driverManagerType =null;

    public BrowserService() {
        ReadProperties readProperties = new ReadProperties();
        String browserName = readProperties.getBrowserName();

        switch (browserName.toLowerCase()) {
            case "chrome":
//                ClassLoader classLoader = getClass().getClassLoader();
//                File file = new File(classLoader.getResource("drivers/chromedriver.exe").getFile());
//                String absolutePath = file.getAbsolutePath();

                driverManagerType = DriverManagerType.CHROME;
                WebDriverManager.getInstance(driverManagerType).setup();

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.setHeadless(readProperties.isHeadless());

                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
            break;

            case "firefox":
//                classLoader = getClass().getClassLoader();
//                file = new File(classLoader.getResource("drivers/geckodriver.exe").getFile());
//                absolutePath = file.getAbsolutePath();

                driverManagerType = DriverManagerType.FIREFOX;
                WebDriverManager.getInstance(driverManagerType).setup();
                driver = new FirefoxDriver();
                break;

            case "ie":
                break;
            case "edge":
                break;
            default:
                System.out.println("Browser is not supported.");
                break;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
