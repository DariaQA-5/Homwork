package Lesson_17;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.  *  ;

public class POSTFormDataTest {
    @Test
    void postFromData() {
        given()
                .baseUri("https://postman-echo.com")
                .when()
                .contentType(ContentType.URLENC.withCharset("UTF-8"))
                .formParam("foo1", "bar1")
                .and().formParam("foo2", "bar2")
                .post("/post")
                .then()
                .assertThat()
                .log().all()
                .statusCode(200)
                .body("args", anEmptyMap())
                .body("data", equalTo(""))
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("files", anEmptyMap())
                .body("json", notNullValue())
        .body("url", equalTo ("https://postman-echo.com/post"));
    }
}
