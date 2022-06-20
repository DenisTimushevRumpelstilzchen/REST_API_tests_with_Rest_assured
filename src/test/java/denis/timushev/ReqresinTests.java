package denis.timushev;

import org.junit.jupiter.api.Test;

import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.core.Is.is;
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

    @Test
    void singleTest() {
        given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .body("data.id", is(2))
                .body("data.email", is("janet.weaver@reqres.in"));
    }

    @Test
    void singleNotFoundTest() {
        given()
                .when()
                .get("https://reqres.in/api/unknown/23")
                .then()
                .statusCode(404);
    }

    @Test
    void unsuccessfulTest() {

        String data = "{ \"email\": \"sydney@fife\" }";

        given()
                .contentType(JSON)
                .body(data)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .statusCode(400)
                .body("error", is("Missing password"));
    }
}
