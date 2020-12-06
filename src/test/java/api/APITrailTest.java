package api;

import baseEntities.BaseAPITest;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APITrailTest extends BaseAPITest {

    @Test
    public void simpleAPITest() {
        String baseUrl = "https://aqa0702.testrail.io/";
        String endPoint = "index.php?/api/v2/get_projects";

        RestAssured.baseURI = baseUrl;

        //setup request object
        RequestSpecification requestSpecification = given();
        requestSpecification.header(HTTP.CONTENT_TYPE, ContentType.JSON);
        requestSpecification.auth().preemptive().basic("atrostyanko+072@gmail.com", "w3n1bU7F4rxOfnfvrBJL");

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
                .auth().preemptive().basic("atrostyanko+072@gmail.com", "w3n1bU7F4rxOfnfvrBJL")
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    @Test
    public void getUser() {
        String endpoint = "index.php?/api/v2/get_user/1";
        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .body("id", is(1))
                .body("name", equalTo("AQA7 Master"))
                .body("email", equalTo("atrostyanko+072@gmail.com"))
                .body("is_active", is(true))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getUserAsString() {
        String endpoint = "index.php?/api/v2/get_user/1";

        UserGson expectedUser = UserGson.builder()
                .name("AQA7 Master")
                .id(1)
                .email("atrostyanko+072@gmail.com")
                .is_active(true)
                .role_id(1)
                .role("Lead")
                .build();

        String jsonResponse = given().when().get(endpoint).asString();
        System.out.println(jsonResponse);

        Gson gson = new Gson();
        UserGson userGson = gson.fromJson(jsonResponse, UserGson.class);

        System.out.println(userGson);
        Assert.assertEquals(userGson, expectedUser);
        Assert.assertTrue(userGson.equals(expectedUser));
    }

    @Test
    public void getUsers() {
        String endpoint = "index.php?/api/v2/get_users";
        given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .body("id", hasItems(1, 2, 3))
                .body("name", hasItem("AQA7 Master")) // проверяем одно значение из массива
                .body("email[0]", equalTo("atrostyanko+072@gmail.com"))
//                .body("is_active", is(true))
                .statusCode(HttpStatus.SC_OK);
    }
}
