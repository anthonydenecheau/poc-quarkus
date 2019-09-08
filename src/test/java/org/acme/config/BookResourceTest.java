package org.acme.config;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

import javax.ws.rs.core.MediaType;

@QuarkusTest
public class BookResourceTest {

    @Test
    public void testList() {
        given()
                .when().get("/books")
                .then()
                .statusCode(200)
                .body("$.size()", is(2),
                        "title", containsInAnyOrder("MyFirstBook", "MySecondBook"));
    }

    @Test
    public void testAdd() {

        int id = given()
                .body("{\"title\": \"MyThirdBook\"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .post("/books")
                .then()
                .statusCode(201)
//                .body("id", notNullValue())
//                .body("title", equalTo("MyThirdBook")
                .extract()
                .path("id");

        given()
                .body("{\"id\":"+Long.valueOf(id)+"}")
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .when()
                .delete("/books/"+Long.valueOf(id))
                .then()
                .statusCode(200);
    }    
}