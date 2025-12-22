package Tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C19_BaseUrlHerokuapp extends BaseUrlHerokuapp {

    @Test
    public void test01() {
        // 1-endpoint ve request body oluştur
        specHerokuapp.pathParam("pp1","booking");

        // 2-expected data

        // 3- request gonder ve donen response'i kaydet
        Response response = given()
                .when().spec(specHerokuapp)
                .get("/{pp1}");

        JsonPath responseJsonPath = response.jsonPath();
        System.out.println(responseJsonPath.getList("bookingid").size());
        // 4-assertions
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("bookingid",Matchers.hasSize(1541));


    }
}
