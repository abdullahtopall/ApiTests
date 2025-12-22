package Tests;

import baseUrl.BaseUrlJsonPlaceholder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlDummyRestapi extends BaseUrlJsonPlaceholder {

    @Test
    public void test01() {

        // 1-endpoint ve request body oluştur
        specJsonPlaceholder.pathParam("pp1","posts");

        // 2-expected data oluştur

        // 3- request gönder, dönen response'i kaydet
        Response response = given()
                .when().spec(specJsonPlaceholder)
                .get("/{pp1}");

        // 4-assertions
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title", Matchers.hasSize(100));
    }

    @Test
    public void test02() {
        // 1-endpoint ve request body oluştur
        specJsonPlaceholder.pathParams("pp1","posts","pp2",44);

        // 2-expected data oluştur

        // 3- request gönder,dönen response'i kaydet
        Response response = given()
                .when().spec(specJsonPlaceholder)
                .get("/{pp1}/{pp2}");

        // 4-assertions
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title",Matchers.equalTo("optio dolor molestias sit"));
    }

    @Test
    public void test03() {
        // 1-endpoint ve request body oluştur
        specJsonPlaceholder.pathParams("pp1","posts","pp2",50);

        // 2-expected data oluştur

        // 3-request gönder, dönen response'i kaydet
        Response response = given()
                .when().spec(specJsonPlaceholder)
                .delete("/{pp1}/{pp2}");

        // 4-assertions
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title",Matchers.nullValue());
    }
}
