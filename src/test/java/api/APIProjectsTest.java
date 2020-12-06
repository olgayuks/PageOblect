package api;

import baseEntities.BaseAPITest;
import com.google.gson.Gson;
import models.EndPoints;
import models.ProjectGson;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class APIProjectsTest extends BaseAPITest {

    private int projectID;

    @Test
    public void addProjectTest() {
        int projectID =
                given()
                        .body(String.format("{\n" +
                                "    \"name\": \"%s\"\n" +
                                "}", "WOW"
                        ))
                        .when()
                        .post(EndPoints.CREATE_PROJECT)
                        .then()
                        .log().body()
                        .statusCode(HttpStatus.SC_OK)
                        .extract().jsonPath().get("id");
    }

    @Test
    public void addProject() {
        ProjectGson projectGson = ProjectGson.builder()
                .name("WOW")
                .suite_mode(2)
                .build();

        Gson gson = new Gson();
        String json = gson.toJson(projectGson);
        System.out.println(json);

        int projectID =
                given()
                        .body(json)
                        .when()
                        .post(EndPoints.CREATE_PROJECT)
                        .then()
                        .log().body()
                        .statusCode(HttpStatus.SC_OK)
                        .extract().jsonPath().get("id");
    }



}
