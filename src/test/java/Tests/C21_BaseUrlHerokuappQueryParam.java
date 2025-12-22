package Tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C21_BaseUrlHerokuappQueryParam extends BaseUrlHerokuapp {

    @Test
    public void test01() {
        // 1-endpoint ve request body hazirla
        specHerokuapp.pathParam("pp1","booking").queryParam("firstname","Eric");
        // 2- expected data

        // 3-request gonderip response'i kaydet
        Response response = given()
                .when().spec(specHerokuapp)
                .get("/{pp1}");

        // 4-assertions
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(2));

    }
}
