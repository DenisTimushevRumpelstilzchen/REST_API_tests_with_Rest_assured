package denis.timushev;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class ReqresinTests {

    @Test
    void deleteTest() {
        given()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204);
    }

    @Test
    void statusTest() {
        get("https://reqres.in/api/users/23")
                .then()
                .statusCode(404);
    }
}
