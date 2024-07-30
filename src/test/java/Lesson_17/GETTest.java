package Lesson_17;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

public class GETTest {
    @Test
    void getRequest() {
        given()
                .baseUri("https://postman-echo.com")
                .when()
                .contentType(ContentType.JSON)
                .get("/get")
                .then().log().all() //На всякий случай вывожу в консоль тело ответа
                .assertThat()
                .statusCode(200)
                .body("args", anEmptyMap())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", instanceOf(String.class))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-amzn-trace-id", instanceOf(String.class))
                .body("headers.user-agent", instanceOf(String.class))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", instanceOf(String.class))
                .body("url", equalTo("https://postman-echo.com/get"));
    }
}