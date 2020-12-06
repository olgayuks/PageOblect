package api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITests {

    @Test
    public void simpleAPITest() {
        String baseUrl = "https://reqres.in";
        String endPoint = "/api/users/2";

        RestAssured.baseURI = baseUrl;

        //setup request object
        RequestSpecification requestSpecification = given();

        //Setup Response object

        Response response = requestSpecification.request(Method.GET, endPoint);

        //Get Response Status

        int statusCode = response.statusCode();
        System.out.println("StatusCode " + statusCode);

        // Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println("Body " + responseBody);

        //Verify Status Code
        Assert.assertEquals(statusCode, 200, "Invalid status code");
    }

    @Test
    public void shotSimpleAPITest() {
        given()
                .when()
                     .get("https://reqres.in/api/users/2")
                .then()
                     .statusCode(HttpStatus.SC_OK)
                     .log().body();
    }
}
