package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static javax.ws.rs.core.HttpHeaders.ACCEPT;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;
import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
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

    @Test
    public void shouldGetAllBooks(){
        given()
            .header(ACCEPT, APPLICATION_JSON).
        when()
            .get("/api/books").
        then()
            .statusCode(OK.getStatusCode())
            .body("size()", is(4));
    }

    @Test
    public void shouldCountAllBooks(){
        given()
            .header(ACCEPT, TEXT_PLAIN).
        when()
            .get("/api/books/count").
        then()
            .statusCode(OK.getStatusCode())
            .body(is("4"));
    }

    @Test
    public void shouldGetABook(){
        given()
            .header(ACCEPT, APPLICATION_JSON)
            .pathParam("id", 1).
        when()
            .get("/api/books/{id}").
        then()
            .statusCode(OK.getStatusCode())
            .body("title", is("Understanding Quarkus"))
            .body("author", is("Antonio"))
            .body("yearOfPublication", is(2020))
            .body("genre", is("IT"));

    }

}
