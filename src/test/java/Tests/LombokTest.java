package Tests;

import baseEntities.BaseTest;
import models.TestCaseLombok;
import models.TestCaseLombokBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LombokTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(LombokTest.class);
    @Test
    public void firstTest() {
        logger.info("Info");
        logger.debug("Debug");
        logger.error("Error");
        TestCaseLombok testCaseLombok = new TestCaseLombok();
        testCaseLombok.setTitle("Title");
        String title = testCaseLombok.getTitle();

        System.out.println(title);
        System.out.println(testCaseLombok.toString());
        System.out.println(testCaseLombok.hashCode());
        System.out.println(testCaseLombok.equals(testCaseLombok));
    }

    @Test
    public void secondTest() {
        TestCaseLombokBuilder testCaseLombokBuilder = TestCaseLombokBuilder.builder()
                .title("Title")
//        .estimate()
                .build();
        String title = testCaseLombokBuilder.getTitle();

        System.out.println(title);
        System.out.println(testCaseLombokBuilder.getEstimate());
        System.out.println(testCaseLombokBuilder.toString());
        System.out.println(testCaseLombokBuilder.hashCode());
        System.out.println(testCaseLombokBuilder.equals(testCaseLombokBuilder));

    }
}
