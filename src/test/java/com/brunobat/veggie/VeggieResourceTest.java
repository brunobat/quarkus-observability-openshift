package com.brunobat.veggie;


import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;

@QuarkusTest
public class VeggieResourceTest {

    private static final int PORT = 9000;  // The port for the other service
    private static final String BASE_URL = "http://localhost:" + PORT;

    @Test
    public void testProvisionAndList() {
        given()
                .header("Content-Type", "application/json; encoding=utf8; charset=utf8")
                .when().post("/veggies/init")
                .then()
                .statusCode(201);

        given()
                .when().get("/veggies")
                .then()
                .log().all()
                .statusCode(200)
                .body("$.size()", is(2),
                        "name", containsInAnyOrder("Carrot", "Zucchini"),
                        "description", containsInAnyOrder("Root vegetable, usually orange", "Summer squash"));
    }
}
