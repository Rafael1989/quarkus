package org.agoncal.quarkus.starting;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class BookResourceTest {

    @Test
    public void testHelloEndpoint(){
        given().
        when()
            .get("/api/books/hello").
        then()
            .statusCode(200)
            .body(is("Hello RestEasy"));

    }
}
