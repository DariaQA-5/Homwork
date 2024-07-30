package Lesson_17;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class POSTRawTextTest {
    @Test
    void postRawText() {
        given()
                .baseUri("https://postman-echo.com")
                .when()
                .contentType(ContentType.TEXT)
                .body("{\"test\": \"value\"}")
                .post("/post")
                .then().log().all()
                .assertThat()
                .statusCode(200)
                .body("args", anEmptyMap())
                .body("data", equalTo("{\"test\": \"value\"}"))
                .body("files", anEmptyMap())
                .body("form", anEmptyMap())
                .body("json", nullValue())
                .body("url", equalTo("https://postman-echo.com/post"));
    }
}
