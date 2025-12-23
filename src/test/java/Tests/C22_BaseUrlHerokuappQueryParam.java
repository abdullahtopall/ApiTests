package Tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C22_BaseUrlHerokuappQueryParam extends BaseUrlHerokuapp {

    @Test
    public void test01() {
        // 1-endpoint ve requestbody
        specHerokuapp.pathParam("pp1","booking").queryParams("firstname","John","lastname","Smith");

        // 2- expected data

        // 3-request gonder ve donen response'i kaydet
        Response response = given().contentType(ContentType.JSON)
                .when().spec(specHerokuapp)
                .get("/{pp1}");

        // 4-assertions
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("bookingid",Matchers.notNullValue());
    }
}
