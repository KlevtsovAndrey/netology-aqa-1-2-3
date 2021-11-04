import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class PostmanEchoTest {
    @Test
    public void ShouldReturnName() {
        given()
                .baseUri("https://postman-echo.com")
                .body("Andrey") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("Andrey"))
        ;
    }
}
