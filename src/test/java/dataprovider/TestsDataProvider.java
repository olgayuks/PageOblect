package dataprovider;

import browserService.ReadProperties;
import org.testng.annotations.DataProvider;

public class TestsDataProvider {

    private static ReadProperties readProperties = new ReadProperties();

    @DataProvider(name = "loginCredentialSource")
    public static Object[][] credentialsForTest() {
        final String username = readProperties.getUsername();
        final String password = readProperties.getPassword();
        return new Object[][]{
                {"fail", "somePassword"},
                {"fail", password},
                {" ", "somePassword"},
                {" ", " "},
                {username, "wrong"},
                {username, password},
        };
    }
    @DataProvider(name = "projectSource")
    public static Object[][] projectNames(){
        final String name = readProperties.getName();
        return new Object[][]{
                {" "},
                {name}
        };

    }

    @DataProvider(name = "editProjectSource")
    public static Object[][] editProjectNames(){
        return new Object[][]{
                {" "},
                {"my new name"}

        };
    }
}
