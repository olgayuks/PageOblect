package api;

import baseEntities.BaseAPITest;
import models.EndPoints;
import models.Project;
import models.ProjectBuilder;
import models.ProjectGson;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APITest2 extends BaseAPITest {

    private int projectId = 81;

    @Test(priority = 0)
    public void testCreateProject() {
        ProjectGson projectGson = ProjectGson.builder()
                .name("WOW")
                .suite_mode(2)
                .build();

        //builder pattern 1
        final Project project1 = Project.builder()
                .withName("WOW")
                .build();

        //builder pattern 2
        final Project project2 = ProjectBuilder.builder().name("WOW").build();

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", projectGson.getName());
        jsonMap.put("suite_mode", projectGson.getSuite_mode());

        projectId = given()
                .body(jsonMap)
                .when()
                .post(EndPoints.CREATE_PROJECT)
                .then()
                .log()
                .body()
                .body("announcement", is(nullValue()))
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().get("id");
    }

    @Test(priority = 1)
    public void testGetProjectById() {
        given()
                .get(EndPoints.GET_PROJECT + projectId)
                .then()
                .log().all()
                .statusCode(200)
                .body("id", equalTo(projectId))
                .body("is_completed", equalTo(false));
    }

    @Test(priority = 2)
    public void testUpdateProject() {
        ProjectGson projectGson = ProjectGson.builder()
                .name("WOW 1")
                .announcement("announcement")
                .show_announcement(true)
                .build();

        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("name", projectGson.getName());
        jsonMap.put("announcement", projectGson.getAnnouncement());
        jsonMap.put("show_announcement", projectGson.isShow_announcement());

        given()
                .body(jsonMap)
                .when()
                .post(EndPoints.UPDATE_PROJECT + projectId)
                .then()
                .log()
                .body()
                .body("announcement", is(equalTo("announcement")))
                .body("name", is(equalTo("WOW 1")))
                .body("show_announcement", is(true))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(priority = 3)
    public void testDeleteProject() {
        given()
                .when()
                .post(EndPoints.DELETE_PROJECT + projectId)
                .then()
                .log()
                .all()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(priority = 4)
    public void testGetDeletedProjectById() {
        given()
                .get(EndPoints.GET_PROJECT + projectId)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

}
