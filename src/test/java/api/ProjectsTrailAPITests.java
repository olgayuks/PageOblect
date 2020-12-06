package api;

import baseEntities.BaseAPITest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ProjectsTrailAPITests extends BaseAPITest {

    @Test
    public void testGetProjects() {

        final String endpoint = "index.php?/api/v2/get_projects";

        given()
                .get(endpoint)
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test
    public void testGetNotCompletedProjects() {

        final String endpoint = "index.php?/api/v2/get_projects&is_completed=0";

        given()
                .get(endpoint)
                .then()
                .statusCode(200)
                .log().body()
        .body("get(0).is_completed", equalTo(false));
    }

    @Test
    public void testGetProjectById() {

        final int id = 2;
        final boolean isCompleted = false;
        final String endpoint = "index.php?/api/v2/get_project/" + id;

        given()
                .get(endpoint)
                .then()
                .log().all()
                .statusCode(200)
                .body("id", equalTo(id))
                .body("is_completed", equalTo(isCompleted));
    }


}
