package api;

import baseEntities.BaseAPITest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UsersTrailAPITests extends BaseAPITest {

    @Test
    public void getUsersTest(){

        final String end_point = "/index.php?/api/v2/get_users";

        given()
                .get(end_point)
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test
    public void getUserTest(){

        final int id = 1;
        final String end_point = "index.php?/api/v2/get_user/" + id ;


        given()
                .get(end_point)
                .then()
                .log().all()
                .statusCode(200)
                .body("id", equalTo(id));

    }


}
